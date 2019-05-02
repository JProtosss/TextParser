package by.epam.training.evgeniyprotasov.task2.entity.impl;

import by.epam.training.evgeniyprotasov.task2.entity.CharacterType;
import by.epam.training.evgeniyprotasov.task2.entity.ComponentType;
import by.epam.training.evgeniyprotasov.task2.entity.TextComponent;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Symbol implements TextComponent, Cloneable{

    private static final ComponentType TYPE = ComponentType.SYMBOL;
    private Character value;
    private CharacterType type;

    String SENTENCE_SPLIT_REGEX = "(?<=[.!?\\u2026])";
    String PUNCTUATION_REGEX = "[\\p{Punct}\\u2026]";

    public Symbol(char character, CharacterType type){
        this.value = character;
        this.type = type;
    }

    public String getString(){
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(value);
        return strBuilder.toString();
    }

    @Override
    public boolean add(TextComponent component) { throw new UnsupportedOperationException("Adding element to symbol is not supported."); }

    @Override
    public List<TextComponent> getComponents() { throw new UnsupportedOperationException("Symbol is a leaf element."); }

    @Override
    public ComponentType getComponentType() {
        return TYPE;
    }

    @Override
    public boolean remove(TextComponent component) { throw new UnsupportedOperationException("Removing element from symbol is not supported."); }

}
