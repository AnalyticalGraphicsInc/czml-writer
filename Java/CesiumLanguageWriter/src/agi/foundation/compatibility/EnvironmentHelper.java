package agi.foundation.compatibility;

/**
 * Helper methods related to the environment.
 */
public final class EnvironmentHelper {
	private EnvironmentHelper() {}

	/**
	 * Gets the newline string defined for this environment.
	 * 
	 * @return A string containing "\r\n" for non-Unix platforms, or a string
	 *         containing "\n" for Unix platforms.
	 */
	public static String newLine() {
		return System.getProperty("line.separator");
	}
}
