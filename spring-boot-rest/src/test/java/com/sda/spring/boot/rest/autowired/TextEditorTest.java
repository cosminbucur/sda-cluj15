package com.sda.spring.boot.rest.autowired;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TextEditorTest {

    @Mock
    private ISpellChecker spellChecker;

    @Mock
    private ITextFormatter textFormatter;

    @Mock
    private IImageConverter imageConverter;

    @Test
    void spellCheck() {
        // given
        TextEditor textEditor = new TextEditor(spellChecker, textFormatter, imageConverter);
        when(spellChecker.checkSpelling())
                .thenReturn("test");

        // when
        String actual = textEditor.spellCheck();

        // then
        assertThat(actual).isEqualTo("ok");
    }

    @Test
    void formatText() {
    }

    @Test
    void convertImage() {
    }
}