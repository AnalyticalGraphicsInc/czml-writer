const fs = require('fs');
const util = require('util');
const Ajv = require('ajv');
const readFileAsync = util.promisify(fs.readFile);

function requireJSON(path) {
    return JSON.parse(fs.readFileSync(path, 'utf8'));
}

function loadSchema(uri) {
    uri = uri.replace('https://analyticalgraphicsinc.github.io/czml-writer/Schema/', '');
    return readFileAsync(uri, 'utf8').then(JSON.parse);
}

var ajv = new Ajv({
    allErrors: true,
    verbose: true,
    loadSchema: loadSchema
});

var schema = requireJSON('./Packet.json');

var filesToValidate = [
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
    'Examples/ViewFrom.json',
    'Examples/Clock.json'
];

ajv.compileAsync(schema).then(validate => {

    filesToValidate.forEach(path => {
        console.log(`Validating ${path}...`);

        const packet = requireJSON(path);
        const valid = validate(packet);
        if (valid) {
            console.log(`...Valid!`);
        } else {
            console.log(`...Invalid: ${ajv.errorsText(validate.errors)}`);
        }
    });

});
