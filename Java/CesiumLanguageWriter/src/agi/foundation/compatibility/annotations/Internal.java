package agi.foundation.compatibility.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Marker interface for declarations that were internal in C#.
 */
@Documented
@Retention(RetentionPolicy.CLASS)
public @interface Internal {}
