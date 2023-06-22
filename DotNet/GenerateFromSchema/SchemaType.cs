using System;

namespace GenerateFromSchema
{
    [Flags]
    public enum SchemaType
    {
        // @formatter:int_align_fields true
        None    = 0b0000000,
        String  = 0b0000001,
        Float   = 0b0000010,
        Integer = 0b0000100,
        Boolean = 0b0001000,
        Object  = 0b0010000,
        Array   = 0b0100000,
        Null    = 0b1000000,
        Any     = 0b1111111,
    }
}