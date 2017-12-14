package agi.foundation.compatibility;

import agi.foundation.compatibility.annotations.Internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.net.URLConnection;

/**
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public class WebResponse implements IDisposable {
    protected final URLConnection connection;
    private InputStream inputStream;

    public WebResponse(URLConnection connection) {
        this.connection = connection;
    }

    public InputStream getResponseStream() {
        if (inputStream == null) {
            try {
                inputStream = connection.getInputStream();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
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
