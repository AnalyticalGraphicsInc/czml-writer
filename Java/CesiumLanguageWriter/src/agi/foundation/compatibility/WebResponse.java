package agi.foundation.compatibility;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

public class WebResponse implements IDisposable {
	private final URLConnection connection;
	private InputStream inputStream;

	public WebResponse(URLConnection connection) {
		this.connection = connection;
	}

	public InputStream getResponseStream() {
		if (inputStream == null) {
			try {
				inputStream = connection.getInputStream();
			} catch (IOException e) {
				throw new RuntimeIOException(e);
			}
		}
		return inputStream;
	}

	public String getContentType() {
		return connection.getContentType();
	}

	@Override
	public void dispose() {
		if (inputStream != null)
			DisposeHelper.dispose(inputStream);
	}
}
