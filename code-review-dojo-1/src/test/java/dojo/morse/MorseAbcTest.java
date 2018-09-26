package dojo.morse;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class MorseAbcTest {
	
	private MorseAbc abc;
	
	@Before
	public void createAbc() {
		abc = new MorseAbc();
	}

	@Test
	public void getMorseCodeByCharacter_should_return_null_without_initialization() throws Exception {
		String morseSign = abc.getMorseCodeByCharacter('A');
		assertThat(morseSign).isNull();
	}

	@Test
	public void getMorseCodeByCharacter_should_return_null_for_non_existing_character() throws Exception {
		abc.init();
		String morseSign = abc.getMorseCodeByCharacter('.');
		assertThat(morseSign).isNull();
	}

	@Test
	public void getMorseCodeByCharacter_should_return_morse_sign_for_existing_character() throws Exception {
		abc.init();
		String morseSign = abc.getMorseCodeByCharacter('A');
		assertThat(morseSign).isEqualTo(".-");
	}

	@Test
	public void getMorseCodeByCharacter_should_return_morse_sign_for_lower_case_character() throws Exception {
		abc.init();
		String morseSign = abc.getMorseCodeByCharacter('a');
		assertThat(morseSign).isEqualTo(".-");
	}

	@Test
	public void getCharacterByMorseCode_should_return_null_without_initialization() throws Exception {
		Character morseSign = abc.getCharacterByMorseCode("--.");
		assertThat(morseSign).isNull();
	}

	@Test
	public void getCharacterByMorseCode_should_return_null_for_invalid_sign() throws Exception {
		abc.init();
		Character morseSign = abc.getCharacterByMorseCode("......");
		assertThat(morseSign).isNull();
	}

	@Test
	public void getCharacterByMorseCode_should_return_character_valid_sign() throws Exception {
		abc.init();
		Character morseSign = abc.getCharacterByMorseCode("--.");
		assertThat(morseSign).isEqualTo('G');
	}

}