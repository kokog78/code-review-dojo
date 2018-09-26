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
	public void translateToMorseString_should_tanslate_text_to_morse() throws Exception {
		String result = translator.translateToMorseString("ABC");
		assertThat(result).isEqualTo("01 1000 1010");
	}

	@Test
	public void translateToMorseString_should_skip_whitespaces() throws Exception {
		String result = translator.translateToMorseString("\r\nA B\t\n\rC");
		assertThat(result).isEqualTo("01 1000 1010");
	}

	@Test
	public void translateToMorseString_should_throw_exception_for_illegal_character() throws Exception {
		assertThatThrownBy(() -> translator.translateToMorseString("ABC."))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(".");
	}
}
