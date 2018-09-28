package dojo.morse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;

public class MorseTranslatorTest {

	private final MorseTranslator translator = new MorseTranslator();
	
	@Test
	public void translateToMorseString_should_return_empty_string_for_null() throws Exception {
		String result = translator.translateToMorseString(null);
		assertThat(result).isEqualTo("");
	}

	@Test
	public void translateToMorseString_should_return_empty_string_for_empty_string() throws Exception {
		String result = translator.translateToMorseString("");
		assertThat(result).isEqualTo("");
	}

	@Test
	public void translateToMorseString_should_translate_text_to_morse() throws Exception {
		String result = translator.translateToMorseString("ABC");
		assertThat(result).isEqualTo(".- -... -.-.");
	}

	@Test
	public void translateToMorseString_should_skip_whitespaces() throws Exception {
		String result = translator.translateToMorseString("\r\nA B\t\n\rC");
		assertThat(result).isEqualTo(".- -... -.-.");
	}

	@Test
	public void translateToMorseString_should_throw_exception_for_illegal_character() throws Exception {
		assertThatThrownBy(() -> translator.translateToMorseString("ABC."))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(".");
	}
	
	@Test
	public void isValidMorseString_should_return_false_for_null() throws Exception {
		boolean result = translator.isValidMorseString(null);
		assertThat(result).isFalse();
	}
	
	@Test
	public void isValidMorseString_should_return_true_for_empty_string() throws Exception {
		boolean result = translator.isValidMorseString("");
		assertThat(result).isTrue();
	}
	
	@Test
	public void isValidMorseString_should_return_true_for_valid_morse_code() throws Exception {
		boolean result = translator.isValidMorseString(".- -... -.-.");
		assertThat(result).isTrue();
	}
	
	@Test
	public void isValidMorseString_should_return_false_for_invalid_morse_code() throws Exception {
		boolean result = translator.isValidMorseString("......");
		assertThat(result).isFalse();
	}

	@Test
	public void canBeTranslatedToMorse() throws Exception {
		String textToCheck = "ABC.||^";
		boolean result = translator.canBeTranslatedToMorse(textToCheck);
		System.out.println("az alabbi szoveg >>>" + textToCheck + "<<< lefordithatosaga: " + result);
		assertThat(result).isFalse();
	}
}
