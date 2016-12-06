package agi.foundation.compatibility;

/**
 * Supports cloning, which creates a new instance of a class with the same value as an
 * existing instance.
 */
public interface ICloneable extends Cloneable {
    /**
     * Creates a new object that is a copy of the current instance.
     * 
     * @return A new object that is a copy of this instance.
     */
    Object clone();
}
