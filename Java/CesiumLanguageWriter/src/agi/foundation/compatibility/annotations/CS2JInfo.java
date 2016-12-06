package agi.foundation.compatibility.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface CS2JInfo {
    String[] value();
}
