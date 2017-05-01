var fs = require('fs');
var glob = require('glob');
var Ajv = require('ajv');

function requireJSON(path) {
    return JSON.parse(fs.readFileSync(path, 'utf8'));
}

var schemas = glob.sync('*.json').concat(glob.sync('Extensions/**/*.json')).map(function (filename) {
    return requireJSON(filename);
});

var ajv = new Ajv({
    allErrors: true,
    verbose: true,
    schemas: schemas
});

var schema = requireJSON('./Packet.json');

var validate = ajv.compile(schema);

function test(path) {
    var packet = requireJSON(path);
    var valid = validate(packet);
    if (!valid) {
        console.log('File ' + path + ' Invalid: ' + ajv.errorsText(validate.errors));
    }
}

[
    'Examples/Packet.json',
    'Examples/DeletePacket.json',
    'Examples/DocumentPacket.json',
    'Examples/Billboard.json',
    'Examples/ModelNodeTransformations.json',
    'Examples/Orientation.json',
    'Examples/OrientationSampled.json',
    'Examples/PositionCartographicDegrees.json',
    'Examples/PositionCartographicRadians.json',
    'Examples/SimplePosition.json',
    'Examples/TimeVaryingPosition.json',
    'Examples/ViewFrom.json'
].forEach(function (f) {
    console.log('Validating ' + f);
    test(f);
});
