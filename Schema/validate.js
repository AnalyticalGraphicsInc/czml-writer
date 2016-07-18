var fs = require('fs');
var glob = require('glob');
var Ajv = require('ajv');

function requireJSON(path) {
	return JSON.parse(fs.readFileSync(path, 'utf8'));
}

var schemas = glob.sync('*.json').concat(glob.sync('Extensions/**/*.json')).map(function(filename) {
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

test('Examples/Packet.json');