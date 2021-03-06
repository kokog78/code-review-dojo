const expect  = require('chai').expect;
const MorseTranslator = require('../../main/javascript/morse-translator');

describe('MorseTranslator', () => {

    const translator = new MorseTranslator();

    describe('translateToMorseString()', () => {

        it('should return empty string for undefined', () => {
            const result = translator.translateToMorseString();
            expect(result).to.equals('');
        });

        it('should return empty string for null', () => {
            const result = translator.translateToMorseString(null);
            expect(result).to.equals('');
        });

        it('should return empty string for empty string', () => {
            const result = translator.translateToMorseString('');
            expect(result).to.equals('');
        });

        it('should translate text to morse', () => {
            const result = translator.translateToMorseString('ABC');
            expect(result).to.equals('.- -... -.-.');
        });

        it('should skip whitespaces', () => {
            const result = translator.translateToMorseString('\r\nA B\t\n\rC');
            expect(result).to.equals('.- -... -.-.');
        });

        it('should throw error for illegal character', () => {
            expect(() => translator.translateToMorseString('ABC.')).to.throw;
        });

    });

    describe('isValidMorseString()', () => {

        it('should return false for null', () => {
            const result = translator.isValidMorseString(null);
            expect(result).to.be.false;
        });

        it('should return false for undefined', () => {
            const result = translator.isValidMorseString();
            expect(result).to.be.false;
        });

        it('should return true for empty string', () => {
            const result = translator.isValidMorseString('');
            expect(result).to.be.true;
        });

        it('should return true for valid morse code', () => {
            const result = translator.isValidMorseString('.- -... -.-.');
            expect(result).to.be.true;
        });

        it('should return false for invalid morse code', () => {
            const result = translator.isValidMorseString('......');
            expect(result).to.be.false;
        });

    });

    describe('canBeTranslatedToMorse()', () => {
        
                it('should return true for characters', () => {
                    const result = translator.canBeTranslatedToMorse('asdf');
                    expect(result).to.be.true;
                });

                it('should return true for space', () => {
                    const result = translator.canBeTranslatedToMorse(' ');
                    expect(result).to.be.true;
                });
                
                it('should return false for invalid morse code', () => {
                    const result = translator.canBeTranslatedToMorse('......');
                    expect(result).to.be.false;
                });

                it('should return true for tab', () => {
                    const result = translator.canBeTranslatedToMorse('   ');
                    expect(result).to.be.true;
                });

                it('should return true for numbers', () => {
                    const result = translator.canBeTranslatedToMorse('058');
                    expect(result).to.be.true;
                });

        
            });

});