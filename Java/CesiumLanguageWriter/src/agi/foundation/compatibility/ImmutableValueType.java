package agi.foundation.compatibility;

/**
 * Marker interface for a {@link ValueType} that is declared to be immutable, that is,
 * none of the contained data may change after construction. This means that instances can
 * be shared instead of copied when passed around.
 */
public interface ImmutableValueType extends ValueType {}
