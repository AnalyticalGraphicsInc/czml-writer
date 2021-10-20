package agi.foundation.compatibility;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.Closeable;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Iterator;

import javax.annotation.Nullable;

import agi.foundation.compatibility.annotations.Internal;

/**
 * Helper methods to safely dispose various types.
 *
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public final class DisposeHelper {
    private DisposeHelper() {}

    /**
     * Dispose the given object if not null.
     *
     * @param o
     *            the object to dispose.
     */
    public static void dispose(@Nullable Closeable o) {
        try {
            if (o != null)
                o.close();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * Dispose the given object if not null.
     *
     * @param o
     *            the object to dispose.
     */
    public static void dispose(@Nullable IDisposable o) {
        if (o != null)
            o.dispose();
    }

    /**
     * Dispose the given object if not null.
     *
     * @param o
     *            the object to dispose.
     */
    public static void dispose(@Nullable MemoryStream o) {
        // we need this overload because MemoryStream implements IDisposable and Closeable
        // and the calls would be ambiguous between the two.
        dispose((IDisposable) o);
    }

    /**
     * Dispose the given object if not null.
     *
     * @param o
     *            the object to dispose.
     */
    public static void dispose(@Nullable Graphics2D o) {
        if (o != null)
            o.dispose();
    }

    /**
     * Dispose the given object if not null.
     *
     * @param o
     *            the object to dispose.
     */
    public static void dispose(@Nullable BufferedImage o) {
        if (o != null)
            o.flush();
    }

    /**
     * Dispose the given object if not null.
     *
     * @param o
     *            the object to dispose.
     */
    public static void dispose(@Nullable RenderedImage o) {
        if (o instanceof BufferedImage) {
            dispose((BufferedImage) o);
        }
    }

    /**
     * Dispose the given object if not null.
     *
     * @param o
     *            the object to dispose.
     */
    public static void dispose(@Nullable Iterator<?> o) {
        if (o instanceof IDisposable) {
            dispose((IDisposable) o);
        }
    }

    /**
     * Dispose the given object if it is one of the known disposable types.
     */
    static void disposeObject(@Nullable Object o) {
        if (o == null)
            return;
        else if (o instanceof Iterator)
            dispose((Iterator<?>) o);
        else if (o instanceof BufferedImage)
            dispose((BufferedImage) o);
        else if (o instanceof RenderedImage)
            dispose((RenderedImage) o);
        else if (o instanceof Graphics2D)
            dispose((Graphics2D) o);
        else if (o instanceof MemoryStream)
            dispose((MemoryStream) o);
        else if (o instanceof IDisposable)
            dispose((IDisposable) o);
        else if (o instanceof Closeable)
            dispose((Closeable) o);
    }
}
