package dojo.morse;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class MorseAbc {

	private final Map<Character, MorseCode> signsByCharacter = new HashMap<>();
	private final Map<String, MorseCode> signsByMorse = new HashMap<>();
	
	public void init() {
		signsByCharacter.clear();
		signsByMorse.clear();
		String content = loadResource();
		String[] lines = content.split("\\n");
		for (String line : lines) {
			line = line.trim();
			if (!line.isEmpty()) {
				MorseCode morse = parseMorse(line);
				register(morse);
			}
		}
	}
	
	public String getMorseSignByCharacter(char c) {
		MorseCode morse = signsByCharacter.get(c);
		if (morse == null) {
			morse = signsByCharacter.get(Character.toUpperCase(c));
		}
		return (morse == null ? null : morse.getCode());
	}
	
	public Character getCharacterByMorseCode(String sign) {
		MorseCode morse = signsByMorse.get(sign);
		return (morse == null ? null : morse.getCharacter());
	}
	
	private String loadResource() {
		try (Scanner scanner = new Scanner(getClass().getResourceAsStream("/morse.txt"))) {
			scanner.useDelimiter("\\A");
			return scanner.next();
		}
	}
	
	private MorseCode parseMorse(String line) {
		return new MorseCode(line.charAt(0), line.substring(1).trim());
	}
	
	private void register(MorseCode morse) {
		signsByCharacter.put(morse.getCharacter(), morse);
		signsByMorse.put(morse.getCode(), morse);
	}
	
}
