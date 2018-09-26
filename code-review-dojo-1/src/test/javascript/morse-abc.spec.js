const expect  = require('chai').expect;
const MorseAbc = require('../../main/javascript/morse-abc');

describe('MorseAbc', () => {

    const abc = new MorseAbc();

    describe('getMorseCodeByCharacter()', () => {

        it('should return null for non-existing character', () => {
            const result = abc.getMorseCodeByCharacter('.');
            expect(result).to.be.null;
        });

        it('should return morse code for existing character', () => {
            const result = abc.getMorseCodeByCharacter('A');
            expect(result).to.equal('.-');
        });

        it('should return morse code for lowercase character', () => {
            const result = abc.getMorseCodeByCharacter('a');
            expect(result).to.equal('.-');
        });

    });

    describe('getCharacterByMorseCode()', () => {

        it('should return null for invalid code', () => {
            const result = abc.getCharacterByMorseCode('......')
            expect(result).to.be.null;
        });

        it('should return character for valid code', () => {
            const result = abc.getCharacterByMorseCode('--.')
            expect(result).to.equals('G');
        });

    });

});