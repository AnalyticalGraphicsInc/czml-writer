package agi.foundation.compatibility;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public abstract class WebRequest {
    protected URL url;
    protected Proxy proxy;
    protected int timeout;

    public static WebRequest create(String requestUriString) {
        try {
            return create(new URL(requestUriString));
        } catch (MalformedURLException e) {
            throw new RuntimeMalformedURLException(e);
        }
    }

    public static WebRequest create(URI requestUri) {
        try {
            return create(requestUri.toURL());
        } catch (MalformedURLException e) {
            throw new RuntimeMalformedURLException(e);
        }
    }

    private static WebRequest create(URL url) {
        String protocol = url.getProtocol();

        if ("http".equals(protocol) || "https".equals(protocol)) {
            return new HttpWebRequest(url);
        } else if ("ftp".equals(protocol)) {
            return new FtpWebRequest(url);
        } else if ("file".equals(protocol)) {
            return new FileWebRequest(url);
        } else {
            return new UnknownWebRequest(url);
        }
    }

    /**
     * Fallback class for which there is no specifically registered scheme.
     */
    private static final class UnknownWebRequest extends WebRequest {
        UnknownWebRequest(URL url) {
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

    protected WebRequest(URL url) {
        this.url = url;
    }

    public WebResponse getResponse() {
        try {
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

            return new WebResponse(connection);
        } catch (IOException e) {
            throw new RuntimeIOException(e);
        }
    }

    protected abstract void configureConnection(URLConnection connection);
}
