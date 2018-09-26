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
	public void getMorseSignByCharacter_should_return_null_without_initialization() throws Exception {
		String morseSign = abc.getMorseSignByCharacter('A');
		assertThat(morseSign).isNull();
	}

	@Test
	public void getMorseSignByCharacter_should_return_null_for_non_existing_character() throws Exception {
		abc.init();
		String morseSign = abc.getMorseSignByCharacter('.');
		assertThat(morseSign).isNull();
	}

	@Test
	public void getMorseSignByCharacter_should_return_morse_sign_for_existing_character() throws Exception {
		abc.init();
		String morseSign = abc.getMorseSignByCharacter('A');
		assertThat(morseSign).isEqualTo("01");
	}

	@Test
	public void getMorseSignByCharacter_should_return_morse_sign_for_lower_case_character() throws Exception {
		abc.init();
		String morseSign = abc.getMorseSignByCharacter('a');
		assertThat(morseSign).isEqualTo("01");
	}

	@Test
	public void getCharacterByMorseSign_should_return_null_without_initialization() throws Exception {
		Character morseSign = abc.getCharacterByMorseSign("110");
		assertThat(morseSign).isNull();
	}

	@Test
	public void getCharacterByMorseSign_should_return_null_for_invalid_sign() throws Exception {
		abc.init();
		Character morseSign = abc.getCharacterByMorseSign("000000");
		assertThat(morseSign).isNull();
	}

	@Test
	public void getCharacterByMorseSign_should_return_character_valid_sign() throws Exception {
		abc.init();
		Character morseSign = abc.getCharacterByMorseSign("110");
		assertThat(morseSign).isEqualTo('G');
	}

}