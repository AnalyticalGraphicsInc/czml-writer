package agi.foundation.compatibility;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Helper methods for Enums.
 */
public final class EnumHelper {
    private EnumHelper() {}

    /**
     * Retrieves an array of the values of the constants in a specified enumeration.
     *
     * @param enumType
     *            An enumeration type.
     * @return An array that contains the values of the constants in enumType.
     */
    public static <T> T[] getValues(Class<T> enumType) {
        T[] values;

        if (enumType.isEnum()) {
            values = enumType.getEnumConstants();
        } else {
            Method method;
            try {
                method = enumType.getMethod("values", new Class<?>[0]);
                method.setAccessible(true);
            } catch (NoSuchMethodException e) {
                throw new RuntimeNoSuchMethodException(e);
            }
            try {
                @SuppressWarnings("unchecked")
                T[] temp = (T[]) method.invoke(null);
                values = temp;
            } catch (IllegalAccessException e) {
                throw new RuntimeIllegalAccessException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeInvocationTargetException(e);
            }
        }

        return values;
    }
}
