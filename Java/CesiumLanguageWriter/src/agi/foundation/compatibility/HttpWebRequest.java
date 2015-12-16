package agi.foundation.compatibility;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;

public class HttpWebRequest extends WebRequest {
	private URL url;
	private String method;
	private String userAgent;
	private int timeout;
	private Proxy proxy;

	public HttpWebRequest(String urlString) {
		try {
			url = new URL(urlString);
		} catch (MalformedURLException e) {
			throw new RuntimeMalformedURLException(e);
		}
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public void setProxy(Proxy proxy) {
		this.proxy = proxy;
	}

	@Override
	public WebResponse getResponse() {
		HttpURLConnection connection;
		try {
			if (proxy == null)
				connection = (HttpURLConnection) url.openConnection();
			else
				connection = (HttpURLConnection) url.openConnection(proxy);

			if (timeout != 0) {
				connection.setConnectTimeout(timeout);
			}

			if (method != null) {
				try {
					connection.setRequestMethod(method);
				} catch (ProtocolException e) {}
			}

			if (userAgent != null) {
				connection.setRequestProperty("User-Agent", userAgent);
			}

			connection.connect();
			return new WebResponse(connection);
		} catch (IOException e) {
			throw new RuntimeIOException(e);
		}
	}
}
