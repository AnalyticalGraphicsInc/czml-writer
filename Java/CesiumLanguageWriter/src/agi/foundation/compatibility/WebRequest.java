package agi.foundation.compatibility;

import static agi.foundation.compatibility.ArgumentNullException.assertNonNull;

import agi.foundation.compatibility.annotations.Internal;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public abstract class WebRequest {
    @Nonnull
    protected final URL url;
    @Nullable
    protected Proxy proxy;
    protected int timeout;
    @Nullable
    private URLConnection connection;

    protected WebRequest(@Nonnull URL url) {
        this.url = url;
    }

    public static WebRequest create(@Nonnull String requestUriString) {
        assertNonNull(requestUriString, "requestUriString");

        return create(UriHelper.create(requestUriString));
    }

    public static WebRequest create(@Nonnull URI requestUri) {
        assertNonNull(requestUri, "requestUri");

        return create(toURL(requestUri));
    }

    @Nonnull
    private static URL toURL(@Nonnull URI requestUri) {
        try {
            return requestUri.toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeURISyntaxException(e);
        }
    }

    private static WebRequest create(@Nonnull URL url) {
        return create(url, url.getProtocol());
    }

    private static WebRequest create(@Nonnull URL url, String protocol) {
        switch (protocol) {
        case "http":
        case "https":
            return new HttpWebRequest(url);
        case "ftp":
            return new FtpWebRequest(url);
        case "file":
            return new FileWebRequest(url);
        default:
            return new UnknownWebRequest(url);
        }
    }

    /**
     * Fallback class for which there is no specifically registered scheme.
     */
    private static final class UnknownWebRequest extends WebRequest {
        UnknownWebRequest(@Nonnull URL url) {
            super(url);
        }

        @Override
        protected void configureConnection(URLConnection connection) {}
    }

    /**
     * Gets the network proxy to use to access this Internet resource.
     *
     * @return The proxy.
     */
    public Proxy getProxy() {
        return proxy;
    }

    /**
     * Sets the network proxy to use to access this Internet resource.
     *
     * @param value
     *            The proxy.
     */
    public void setProxy(Proxy value) {
        proxy = value;
    }

    /**
     * Gets the length of time, in milliseconds, before the request times out.
     *
     * @return The timeout.
     */
    public int getTimeout() {
        return timeout;
    }

    /**
     * Sets the length of time, in milliseconds, before the request times out.
     *
     * @param value
     *            The timeout.
     */
    public void setTimeout(int value) {
        timeout = value;
    }

    /**
     * Returns a response to this request.
     *
     * @return The response.
     */
    public WebResponse getResponse() {
        return createResponse(getConnection());
    }

    @Nonnull
    private URLConnection getConnection() {
        if (connection != null)
            return connection;

        connection = createConnection();
        return connection;
    }

    @Nonnull
    private URLConnection createConnection() {
        URLConnection connection;
        try {
            connection = proxy != null ? url.openConnection(proxy) : url.openConnection();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        if (timeout != 0) {
            connection.setConnectTimeout(timeout);
        }

        configureConnection(connection);

        try {
            connection.connect();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

        return connection;
    }

    @Nonnull
    public URI getRequestUri() {
        return UriHelper.toURI(url);
    }

    @Nonnull
    protected WebResponse createResponse(@Nonnull URLConnection connection) {
        return new WebResponse(connection);
    }

    protected abstract void configureConnection(@Nonnull URLConnection connection);
}
