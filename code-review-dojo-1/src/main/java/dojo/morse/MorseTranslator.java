package dojo.morse;

import java.util.List;

public class MorseTranslator {

	private final MorseAbc abc;
	
	public MorseTranslator() {
		abc = new MorseAbc();
		abc.init();
	}
	
	public String translateToMorseString(String text) {
		StringBuilder result = new StringBuilder();
		if (text != null) {
			for (int i=0; i<text.length(); i++) {
				char c = text.charAt(i);
				switch (c) {
				case ' ':
				case '\t':
				case '\r':
				case '\n':
					// a szóközt kihagyjuk
					break;
				default:
					String morse = abc.getMorseCodeByCharacter(c);
					if (morse == null) {
						throw new IllegalArgumentException(String.format("Cannot find morse sign for: %s", c));
					}
					if (result.length() > 0) {
						result.append(' ');
					}
					result.append(morse);
					break;
				}
			}
		}
		return result.toString();
	}
	
	/**
	 * Ellenőrzi, hogy a megadott morze sztring érvényes kódokat tartalmaz-e.
	 * A bemenetben a rövid jelek "."-tal, a hosszú jelek "-"-sal szerepelnek.
	 * Az egyes betűk között egy vagy több szóköz, tabulátor vagy sortörés van.
	 * A metódus akkor tér vissza <code>true</code> értékkel, ha a bemenet csak érvényes
	 * morze jeleket, szóközöket, tabulátorokat és sortöréseket tartalmaz.
	 * @param morse a morze jeleket tartalmazó sztring
	 * @return a bemenet érvényes morze kódot tartalmaz?
	 */
	public boolean isValidMorseString(String morse) {
		if (morse == null) {
			return false;
		}
		String[] codes = morse.split("\\s");
		for (String code : codes) {
			if (!code.isEmpty()) {
				Character c = abc.getCharacterByMorseCode(code);
				if (c == null) {
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
	public boolean canBeTranslatedToMorse(String text) {
		return false;
	}
	
	/**
	 * Visszaadja a morzejeleket tartalmazó listát, amit a bemenet alapján fordított.
	 * Ha a bemenet <code>null</code> vagy üres sztring, üres listát ad.
	 * A bemenetben levő szóközt, tabulátort és sortörés karaktereket figyelmen kívül hagyja.
	 * Ha a bemenet ismeretlen karaktereket tartalmaz, akkor {@link IllegalArgumentException}-t dob.
	 * @param text a lefordítandó karaktereket tartalmazó sztring
	 * @return a lefordított morzejelek
	 */
	public List<MorseCode> translateToMorseCodes(String text) {
		return null;
	}
	
	/**
	 * Visszaadja a morzejelekhez tartozó betűket.
	 * A bemenetben a rövid jelek "."-tal, a hosszú jelek "-"-sal szerepelnek.
	 * Az egyes betűk között egy vagy több szóköz, tabulátor vagy sortörés van.
	 * @param morse a morze jeleket tartalmazó sztring
	 * @return a lefordított karaktereket tartalmazó sztring
	 */
	public String translateToLetters(String morse) {
		return null;
	}
	
	/**
	 * Visszaadja a morzejelekhez tartozó betűket.
	 * Sosem ad vissza <code>null</code> értéket.
	 * @param morse a morze jeleket tartalmazó tömb
	 * @return a lefordított karaktereket tartalmazó sztring
	 */
	public String translateToLetters(MorseCode ... codes) {
		return null;
	}
	
}
