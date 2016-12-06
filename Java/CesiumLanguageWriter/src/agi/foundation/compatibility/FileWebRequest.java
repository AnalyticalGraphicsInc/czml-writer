package agi.foundation.compatibility;

import java.net.URL;
import java.net.URLConnection;

public class FileWebRequest extends WebRequest {
    FileWebRequest(URL url) {
        super(url);
    }

    @Override
    protected void configureConnection(URLConnection connection) {}
}
