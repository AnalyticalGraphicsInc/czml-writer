using System.Collections.Generic;
using System.Linq;
using JetBrains.Annotations;
using Newtonsoft.Json.Schema;

namespace GenerateFromSchema
{
    public class Schema
    {
        public Schema()
        {
        }

        public string Name { get; set; }

        public string Description { get; set; }

        public bool IsValue { get; set; }

        public string ExtensionPrefix { get; set; }

        [NotNull]
        public List<Schema> Extends { get; } = new List<Schema>();

        public JsonSchemaType JsonTypes { get; set; }

        [NotNull]
        public List<Property> Properties { get; } = new List<Property>();

        public Property AdditionalProperties { get; set; }

        public List<SchemaEnumValue> EnumValues { get; set; }

        public List<string> Examples { get; set; }

        public bool IsSchemaFromType => Name == SchemaFromTypeName;

        public string NameWithPascalCase => Name.CapitalizeFirstLetter();

        public bool IsInterpolatable => Extends.Any(schema => schema.Name == InterpolatableProperty);

        /// <summary>
        /// Mixins are other schemas whose properties we inherit.  Because we can't use multiple
        /// inheritance, this defines a set of interfaces we implement, but the implementations
        /// are generated in each class.
        /// </summary>
        public IEnumerable<Schema> Mixins => Extends.Where(schema => schema.Name != InterpolatableProperty);
        public IEnumerable<string> Interfaces => Mixins.Select(schema => $"ICesium{schema.Name}Writer");

        /// <summary>
        /// All properties to be generated, including those properties defined by mixins.
        /// </summary>
        public List<Property> AllProperties => Properties.Concat(Mixins.SelectMany(schema => schema.Properties)).ToList();

        private const string InterpolatableProperty = "InterpolatableProperty";
        public static readonly string SchemaFromTypeName = "<Schema from Type>";
    }
}