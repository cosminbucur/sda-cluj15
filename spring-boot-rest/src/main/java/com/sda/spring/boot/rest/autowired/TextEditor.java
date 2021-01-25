package com.sda.spring.boot.rest.autowired;

import org.springframework.beans.factory.annotation.Autowired;

//@Component
public class TextEditor {

    // HAS-A

    // field injection - not recommended
    @Autowired
    private ISpellChecker spellChecker;
    private ITextFormatter textFormatter;
    private IImageConverter imageConverter;

    // dependency injection

    // constructor injection - ok
    @Autowired
    public TextEditor(ISpellChecker spellChecker, ITextFormatter textFormatter, IImageConverter imageConverter) {
        this.spellChecker = spellChecker;
        this.textFormatter = textFormatter;
        this.imageConverter = imageConverter;
    }

    public String spellCheck() {
        spellChecker.checkSpelling();
        return "ok";
    }

    public void formatText() {
        textFormatter.formatText();
    }

    public void convertImage() {
        imageConverter.convertImage();
    }

    // setter injection
    @Autowired
    public void setImageConverter(IImageConverter imageConverter) {
        this.imageConverter = imageConverter;
    }
}
