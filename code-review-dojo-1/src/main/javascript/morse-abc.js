const fs = require('fs');
const MorseCode = require('./morse-code');

module.exports = class MorseAbc {

    constructor() {
        this.signsByCharacter = {};
        this.signsByMorse = {};
        fs.readFile(`${__dirname}/../resources/morse.txt`, 'utf8', (err, contets) => {
            const lines = contets.split('\n');
            for (let line of lines) {
                const char = line.charAt(0);
                const code = line.substr(1).trim();
                const morse = new MorseCode(char, code);
                this.signsByCharacter[char] = morse;
                this.signsByMorse[code] = morse;
            }
        });
    }

    getMorseCodeByCharacter(char) {
        let morse = this.signsByCharacter[char];
        if (!morse) {
            morse = this.signsByCharacter[char.toUpperCase()];
        }
        return morse && morse.code || null;
    }

    getCharacterByMorseCode(code) {
        const morse = this.signsByMorse[code];
        return morse && morse.character || null;
    }

};