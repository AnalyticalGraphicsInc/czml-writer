package agi.foundation.compatibility;

/**
 * A marker interface for types implementing an enumeration based on an integer value.
 * Types implementing this interface are also expected to provide a static
 * getFromValue(int) method, and a getDefault() method, both returning an instance of the
 * enumeration.
 */
public interface Enumeration {
	int getValue();
}
