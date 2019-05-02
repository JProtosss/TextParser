package by.epam.training.evgeniyprotasov.task2.parser.impl;

import by.epam.training.evgeniyprotasov.task2.entity.CharacterType;
import by.epam.training.evgeniyprotasov.task2.entity.ComponentType;
import by.epam.training.evgeniyprotasov.task2.entity.TextComponent;
import by.epam.training.evgeniyprotasov.task2.entity.impl.Symbol;
import by.epam.training.evgeniyprotasov.task2.entity.impl.TextComposite;
import by.epam.training.evgeniyprotasov.task2.parser.MainParser;


public class WordParser implements MainParser {
    private SymbolParser symbolParser;

    public WordParser(){
        symbolParser = new SymbolParser();
    }

    @Override
    public TextComponent parseTextElement(String word){
        TextComposite wordComposite = new TextComposite(ComponentType.WORD);

        char[] letters = word.toCharArray();
        for (char letter: letters) {
            Symbol wordComponent = symbolParser.parseTextElement(String.valueOf(letter),CharacterType.LETTER);
            wordComposite.add(wordComponent);
        }
        return wordComposite;
    }
}
