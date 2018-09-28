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

    describe('translateToMorseCodes()', () => {

        it('should return empty array for undefined', () => {
            const result = translator.translateToMorseCodes(undefined);
            expect(result).to.deep.equals([]);
        });

        it('should return empty array for null', () => {
            const result = translator.translateToMorseCodes(null);
            expect(result).to.deep.equals([]);
        });

        it('should return empty array for empty string', () => {
            const result = translator.translateToMorseCodes('');
            expect(result).to.deep.equals([]);
        });

        it('should translate text to morse', () => {
            const result = translator.translateToMorseCodes('ABC');
            expect(result).to.deep.equals(['.-', '-...', '-.-.']);
        });

        it('should skip whitespaces', () => {
            const result = translator.translateToMorseCodes('\r\nA B\t\n\rC');
            expect(result).to.deep.equals(['.-', '-...', '-.-.']);
        });

        it('should throw error for illegal character', () => {
            expect(() => translator.translateToMorseCodes('ABC.')).to.throw;
        });

    });


});