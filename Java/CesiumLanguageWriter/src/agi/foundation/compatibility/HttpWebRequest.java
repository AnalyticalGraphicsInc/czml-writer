package agi.foundation.compatibility;

import agi.foundation.compatibility.annotations.Internal;

import java.net.URL;
import java.net.URLConnection;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public class HttpWebRequest extends WebRequest {
    @Nullable
    private String userAgent;
    @Nonnull
    private static final String USER_AGENT_HEADER = "User-Agent";

    HttpWebRequest(@Nonnull URL url) {
        super(url);
    }

    public void setUserAgent(String value) {
        userAgent = value;
    }

    @Override
    protected void configureConnection(URLConnection connection) {
        if (userAgent != null) {
            connection.setRequestProperty(USER_AGENT_HEADER, userAgent);
        }
    }

    @Override
    protected WebResponse createResponse(URLConnection connection) {
        return new WebResponse(connection);
    }
}
