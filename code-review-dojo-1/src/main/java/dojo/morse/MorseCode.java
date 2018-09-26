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
}
