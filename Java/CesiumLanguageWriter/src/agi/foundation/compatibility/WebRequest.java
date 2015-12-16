package agi.foundation.compatibility;

public abstract class WebRequest {
	public static WebRequest create(String requestUriString) {
		return new HttpWebRequest(requestUriString);
	}

	public abstract WebResponse getResponse();
}
