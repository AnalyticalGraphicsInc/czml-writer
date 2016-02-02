package agi.foundation.compatibility;

import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

public class HttpWebRequest extends WebRequest {
	private String method;
	private String userAgent;

	HttpWebRequest(URL url) {
		super(url);
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	@Override
	protected void configureConnection(URLConnection connection) {
		HttpURLConnection httpConnection = (HttpURLConnection) connection;

		if (method != null) {
			try {
				httpConnection.setRequestMethod(method);
			} catch (ProtocolException e) {}
		}

		if (userAgent != null) {
			connection.setRequestProperty("User-Agent", userAgent);
		}
	}
}
