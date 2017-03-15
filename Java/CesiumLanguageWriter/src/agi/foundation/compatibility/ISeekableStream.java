package agi.foundation.compatibility;

/**
 * Seekable streams can get and set their position and length.
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

    /**
     * Gets the length in bytes of this stream.
     *
     * @return The length of the stream in bytes.
     */
    long getLength();

    /**
     * Sets the length of this stream.
     *
     * @param length
     *            The new length of this stream in bytes.
     */
    void setLength(long length);
}
