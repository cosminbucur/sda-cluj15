package com.sda.spring.boot.rest.autowired;

public class DemoAutowired {

    public static void main(String[] args) {
        ISpellChecker spellChecker = new SpellChecker();
        ITextFormatter textFormatter = new TextFormatter();
        IImageConverter imageConverter = new ImageConverter();
        TextEditor textEditor = new TextEditor(spellChecker, textFormatter, imageConverter);

        textEditor.spellCheck();
        textEditor.formatText();
        textEditor.convertImage();
    }
}
