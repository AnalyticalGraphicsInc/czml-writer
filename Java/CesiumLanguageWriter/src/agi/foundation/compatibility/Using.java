package agi.foundation.compatibility;

import agi.foundation.compatibility.annotations.Internal;

import static agi.foundation.compatibility.DisposeHelper.disposeObject;

import javax.annotation.Nullable;

/**
 * Wraps an arbitrary resource for use in a try-with-resources. Any checked exception
 * thrown when closing the underlying resource will be wrapped in a RuntimeException.
 *
 * @deprecated Internal use only.
 */
@Internal
@Deprecated
public final class Using<TResource> implements AutoCloseable {
    @Nullable
    public final TResource resource;

    public Using(@Nullable TResource resource) {
        this.resource = resource;
    }

    @Override
    public void close() {
        disposeObject(resource);
    }
}
