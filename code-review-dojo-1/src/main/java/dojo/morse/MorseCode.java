package dojo.morse;

public class MorseCode {

	private final char character;
	private final String code;
	
	public MorseCode(char character, String code) {
		this.character = character;
		this.code = code;
	}
	
	public char getCharacter() {
		return character;
	}
	
	public String getCode() {
		return code;
	}
	
	@Override
	public int hashCode() {
		return Character.hashCode(character) ^ code.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MorseCode) {
			MorseCode other = (MorseCode)obj;
			return character == other.character && code.equals(other.code);
		}
		return false;
	}
}
