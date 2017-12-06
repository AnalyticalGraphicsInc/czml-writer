package agi.foundation.compatibility;

import java.net.URL;
import java.net.URLConnection;

import javax.annotation.Nonnull;

public class FtpWebRequest extends WebRequest {
    FtpWebRequest(@Nonnull URL url) {
        super(url);
    }

    @Override
    protected void configureConnection(URLConnection connection) {}
}
