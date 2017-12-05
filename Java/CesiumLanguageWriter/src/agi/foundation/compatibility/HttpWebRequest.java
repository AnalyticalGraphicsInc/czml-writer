package agi.foundation.compatibility;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.annotation.Nonnull;

public class HttpWebRequest extends WebRequest {
    private String userAgent;

    HttpWebRequest(@Nonnull URL url) {
        super(url);
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String value) {
        userAgent = value;
    }

    @Override
    protected void configureConnection(URLConnection connection) {
        HttpURLConnection httpConnection = (HttpURLConnection) connection;

        if (userAgent != null) {
            connection.setRequestProperty("User-Agent", userAgent);
        }
    }

    @Override
    protected WebResponse createResponse(URLConnection connection) {
        return new WebResponse(connection);
    }
}
