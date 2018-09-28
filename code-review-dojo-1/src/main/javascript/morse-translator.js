const MorseAbc = require('./morse-abc');

module.exports = class MorseTranslator {

    constructor() {
        this.abc = new MorseAbc();
    }

    translateToMorseString(text) {
        let result = '';
        if (text) {
            for (let i=0; i<text.length; i++) {
                const c = text.charAt(i);
                switch (c) {
                    case ' ':
                    case '\t':
                    case '\n':
                    case '\r':
                        // a szóközt kihagyjuk
                        break;
                    default:
                        const morse = this.abc.getMorseCodeByCharacter(c);
                        if (!morse) {
                            throw new Error(`Cannot find morse code for: ${c}`);
                        }
                        if (result.length > 0) {
                            result += ' ';
                        }
                        result += morse;
                        break;
                }
            }
        }
        return result;
    }

    /**
     * Ellenőrzi, hogy a megadott morze sztring érvényes kódokat tartalmaz-e.
     * A bemenetben a rövid jelek "."-tal, a hosszú jelek "-"-sal szerepelnek.
     * Az egyes betűk között egy vagy több szóköz, tabulátor vagy sortörés van.
     * A metódus akkor tér vissza true értékkel, ha a bemenet csak érvényes
     * morze jeleket, szóközöket, tabulátorokat és sortöréseket tartalmaz.
     * @param morse a morze jeleket tartalmazó sztring
     * @return a bemenet érvényes morze kódot tartalmaz?
     */
    isValidMorseString(morse) {
        if (morse === undefined || morse === null) {
            return false;
        }
        const codes = morse.split(/\s/);
        for (let code of codes) {
            if (code) {
                const c = this.abc.getCharacterByMorseCode(code);
                if (!c) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Ellenőrzi, hogy a megadott szöveg lefordítható-e morzejelekre.
     * Ez akkor igaz, ha csak lefordítható karaktereket, szóközöket, tabulátorokat és sortöréseket tartalmaz.
     * @param text a vizsgálandó szöveg
     * @return a bemenet lefordítható morze kódra?
     */
    canBeTranslatedToMorse(text) {

    }

    /**
     * Visszaadja a morzejeleket tartalmazó tömböt, amit a bemenet alapján fordított.
     * Ha a bemenet null, undefined vagy üres sztring, üres tömböt ad.
     * A bemenetben levő szóközt, tabulátort és sortörés karaktereket figyelmen kívül hagyja.
     * Ha a bemenet ismeretlen karaktereket tartalmaz, akkor hibát dob.
     * @param text a lefordítandó karaktereket tartalmazó sztring
     * @return a lefordított morzejelek
     */
    translateToMorseCodes(text) {
        return !text ? [] : this.translateToMorseString(text).split(' ');
    }

    /**
     * Visszaadja a morzejelekhez tartozó betűket.
     * A bemenetben a rövid jelek "."-tal, a hosszú jelek "-"-sal szerepelnek.
     * Az egyes betűk között egy vagy több szóköz, tabulátor vagy sortörés van.
     * @param morse a morze jeleket tartalmazó sztring
     * @return a lefordított karaktereket tartalmazó sztring
     */
    translateToLetters(morse) {

    }

    /**
     * Visszaadja a morzejelekhez tartozó betűket.
     * Sosem ad vissza null vagy undefined értéket.
     * @param morse a morze jeleket tartalmazó tömb
     * @return a lefordított karaktereket tartalmazó sztring
     */
    translateToLetters(...codes) {

    }
};