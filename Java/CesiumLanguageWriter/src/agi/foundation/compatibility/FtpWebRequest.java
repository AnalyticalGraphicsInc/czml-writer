package agi.foundation.compatibility;

import agi.foundation.compatibility.annotations.Internal;

import java.net.URL;
import java.net.URLConnection;

import javax.annotation.Nonnull;

/**
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public class FtpWebRequest extends WebRequest {
    FtpWebRequest(@Nonnull URL url) {
        super(url);
    }

    @Override
    protected void configureConnection(URLConnection connection) {}
}
