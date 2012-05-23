using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace GenerateFromSchema
{
    public abstract class PropertyGenerator
    {
        public abstract void Generate(CodeWriter writer, Schema schema, Property property);
    }
}
