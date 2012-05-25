using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace GenerateFromSchema
{
    public abstract class Generator
    {
        public abstract void Generate(Schema packetSchema);
    }
}
