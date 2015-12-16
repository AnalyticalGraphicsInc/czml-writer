package agi.foundation.compatibility;

/**
 * ISeekableStream provides methods to get and set the position in a stream.
 */
public interface ISeekableStream {
	/**
	 * Gets the current position of this stream.
	 */
	long getPosition();

	/**
	 * Sets the current position of this stream.
	 * 
	 * @param position
	 *            The new position of this stream.
	 */
	void setPosition(long position);
}
