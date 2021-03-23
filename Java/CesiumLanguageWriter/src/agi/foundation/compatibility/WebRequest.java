package agi.foundation.compatibility;

import agi.foundation.compatibility.annotations.Internal;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import javax.annotation.Nonnull;

/**
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public abstract class WebRequest {
    @Nonnull
    protected final URL url;
    protected Proxy proxy;
    protected int timeout;

    protected WebRequest(@Nonnull URL url) {
        this.url = url;
    }

    public static WebRequest create(@Nonnull String requestUriString) {
        ArgumentNullException.assertNonNull(requestUriString, "requestUriString");

        return create(UriHelper.create(requestUriString));
    }

    public static WebRequest create(@Nonnull URI requestUri) {
        ArgumentNullException.assertNonNull(requestUri, "requestUriString");

        try {
            return create(requestUri.toURL());
        } catch (MalformedURLException e) {
            throw new RuntimeMalformedURLException(e);
        }
    }

    private static WebRequest create(@Nonnull URL url) {
        switch (url.getProtocol()) {
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
     * @return The Proxy to use to access the Internet resource.
     */
    public Proxy getProxy() {
        return proxy;
    }

    /**
     * Sets the network proxy to use to access this Internet resource.
     *
     * @param proxy
     *            The Proxy to use to access the Internet resource.
     */
    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    /**
     * Gets the length of time, in milliseconds, before the request times out.
     *
     * @return The length of time, in milliseconds, until the request times out.
     */
    public int getTimeout() {
        return timeout;
    }

    /**
     * Sets the length of time, in milliseconds, before the request times out.
     *
     * @param timeout
     *            The length of time, in milliseconds, until the request times out.
     */
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public WebResponse getResponse() {
        try {
            @Nonnull
            URLConnection connection;
            if (proxy == null) {
                connection = url.openConnection();
            } else {
                connection = url.openConnection(proxy);
            }

            if (timeout != 0) {
                connection.setConnectTimeout(timeout);
            }

            configureConnection(connection);

            connection.connect();

            return createResponse(connection);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
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
