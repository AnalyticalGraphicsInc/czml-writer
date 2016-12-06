package agi.foundation.compatibility;

import java.net.URL;
import java.net.URLConnection;

public class FtpWebRequest extends WebRequest {
    FtpWebRequest(URL url) {
        super(url);
    }

    @Override
    protected void configureConnection(URLConnection connection) {}
}
