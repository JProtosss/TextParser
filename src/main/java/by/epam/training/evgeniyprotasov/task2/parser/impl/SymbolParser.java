package by.epam.training.evgeniyprotasov.task2.parser.impl;

import by.epam.training.evgeniyprotasov.task2.entity.CharacterType;
import by.epam.training.evgeniyprotasov.task2.entity.impl.Symbol;
import by.epam.training.evgeniyprotasov.task2.parser.MainParser;

public class SymbolParser implements MainParser {
    public Symbol parseTextElement(String value, CharacterType type) {
        return new Symbol(value.charAt(0), type);
    }

    @Override
    public Symbol parseTextElement(String value) {
        CharacterType type;
        char charValue = value.charAt(0);
        if (Character.isLetter(charValue)) {
            type = CharacterType.LETTER;
        } else if (Character.isDigit(charValue)) {
            type = CharacterType.NUMBER;
        } else if (charValue == '(' || charValue == ')') {
            type = CharacterType.BRACKET;
        } else {
            type = CharacterType.PUNCTUATION;
        }

        return parseTextElement(value, type);
    }
}
