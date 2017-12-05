package agi.foundation.compatibility;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;

public final class UriHelper {
    // from rfc2396, appendix B
    @Nonnull
    private static final Pattern uriRegex = Pattern.compile("^(?:([^:/?#]+):)?(?://([^/?#]*))?([^?#]*)(?:\\?([^#]*))?(?:#(.*))?");
    @Nonnull
    private static final Pattern opaqueUriRegex = Pattern.compile("^(?:([^:/?#]+):)([^/][^#]*)(?:#(.*))?");

    private UriHelper() {}

    /**
     * Initializes a new instance of the URI class with the specified URI.
     *
     * @param uri
     *            A URI.
     */
    @Nonnull
    public static URI create(@Nonnull String uri) {
        uri = uri.trim();

        int pos = uri.indexOf(':');
        if (pos == 0)
            throw new RuntimeMalformedURLException("Invalid URI: The format of the URI could not be determined.");

        char firstChar = uri.charAt(0);

        try {
            if (pos < 0) {
                if (firstChar == '/' && File.separatorChar == '/') {
                    // ParseAsUnixAbsoluteFilePath

                    String path;
                    if (uri.length() >= 2 && firstChar == '/' && uri.charAt(1) == '/') {
                        uri = StringHelper.trimStart(uri, '/');
                        path = '/' + uri;
                    } else {
                        path = uri;
                    }

                    return new URI("file", "", path, null);
                } else if (uri.length() >= 2 && firstChar == '\\' && uri.charAt(1) == '\\') {
                    // ParseAsWindowsUNC
                    uri = StringHelper.trimStart(uri, '\\');

                    String path;
                    String host;

                    int backslashPos = uri.indexOf('\\');
                    if (backslashPos > 0) {
                        path = uri.substring(backslashPos);
                        host = uri.substring(0, backslashPos);
                    } else {
                        host = uri;
                        path = "/";
                    }

                    path = StringHelper.replace(path, "\\", "/");

                    return new URI("file", host, path, null);
                }
            } else if (pos == 1) {
                // ParseAsWindowsAbsoluteFilePath
                if (!Character.isLetter(firstChar))
                    throw new RuntimeMalformedURLException("URI scheme must start with a letter.");

                if (uri.length() > 2 && uri.charAt(2) != '\\' && uri.charAt(2) != '/')
                    throw new RuntimeMalformedURLException("Relative file path is not allowed.");

                String path = StringHelper.replace(uri, "\\", "/");

                return new URI("file", "", "/" + path, null);
            }

            // first see if this an "opaque" URI
            Matcher matcher = opaqueUriRegex.matcher(uri);
            if (matcher.matches()) {
                String scheme = matcher.group(1);
                String schemeSpecificPart = matcher.group(2);
                String fragment = matcher.group(3);

                return new URI(scheme, schemeSpecificPart, fragment);
            }

            // otherwise treat it as a normal URI by decomposing the pieces,
            // and calling the multi-arg constructor so that it gets escaped
            // properly

            matcher = uriRegex.matcher(uri);

            if (!matcher.matches())
                throw new RuntimeMalformedURLException("Invalid URI.");

            // group number to piece mapping also from rfc2396, appendix B
            String scheme = matcher.group(1);
            String authority = matcher.group(2);
            String path = matcher.group(3);
            if (StringHelper.isNotNullOrEmpty(authority) && StringHelper.isNullOrEmpty(path))
                path = "/";

            String query = matcher.group(4);
            String fragment = matcher.group(5);

            return new URI(scheme, authority, path, query, fragment);
        } catch (URISyntaxException e) {
            throw new RuntimeURISyntaxException(e);
        }
    }

    /**
     * Initializes a new instance of the URI class with the specified URI. This
     * constructor allows you to specify if the URI string is a relative URI, absolute
     * URI, or is indeterminate.
     *
     * @param uriString
     * @param uriKind
     * @return
     */
    @Nonnull
    public static URI create(@Nonnull String uriString, @Nonnull UriKind uriKind) {
        return create(uriString);
    }
}
