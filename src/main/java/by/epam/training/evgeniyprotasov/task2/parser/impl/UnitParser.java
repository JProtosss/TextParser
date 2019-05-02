package by.epam.training.evgeniyprotasov.task2.parser.impl;

import by.epam.training.evgeniyprotasov.task2.entity.CharacterType;
import by.epam.training.evgeniyprotasov.task2.entity.ComponentType;
import by.epam.training.evgeniyprotasov.task2.entity.TextComponent;
import by.epam.training.evgeniyprotasov.task2.entity.impl.Symbol;
import by.epam.training.evgeniyprotasov.task2.entity.impl.TextComposite;
import by.epam.training.evgeniyprotasov.task2.parser.MainParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;


public class UnitParser implements MainParser {
    private WordParser wordParser;
    private SymbolParser symbolParser;

    public UnitParser(){
        wordParser = new WordParser();
        symbolParser = new SymbolParser();
    }


    @Override
    public TextComponent parseTextElement(String unit) {
        var lexicalUnit = new TextComposite(ComponentType.UNIT);

        if (unit.matches(WORD_REGEX) || unit.matches(COMPLICATED_WORD)){
            var word = wordParser.parseTextElement(unit);
            lexicalUnit.add(word);
        }
        else if(unit.matches(NUMERIC_REGEX))
        {
            var digit = symbolParser.parseTextElement(unit);
            lexicalUnit.add(digit);
        }
        else if (unit.matches(WORD_WITH_PUNCT_ENDS)){
            var word = wordParser.parseTextElement(unit.substring(0, unit.length() - 1));
            var character = symbolParser.parseTextElement(String.valueOf(unit.charAt(unit.length() - 1)), CharacterType.PUNCTUATION);

            lexicalUnit.add(word);
            lexicalUnit.add(character);
        }else if (unit.matches(BRACKET_REGEX)){
            var character = symbolParser.parseTextElement(String.valueOf(unit.charAt(0)), CharacterType.BRACKET);
            var word = wordParser.parseTextElement(unit.substring(1, unit.length()-1));
            var character2 = symbolParser.parseTextElement(String.valueOf(unit.charAt(0)), CharacterType.BRACKET);

            lexicalUnit.add(character);
            lexicalUnit.add(word);
            lexicalUnit.add(character2);
        }

        else if (unit.matches(WORD_WITH_PUNCT_BEGINS)){
            var character = symbolParser.parseTextElement(String.valueOf(unit.charAt(0)), CharacterType.PUNCTUATION);
            var word = wordParser.parseTextElement(unit.substring(1, unit.length()));

            lexicalUnit.add(character);
            lexicalUnit.add(word);
        }
        else if (unit.matches(WORD_WITH_PUNCT_BEGINS_ENDS)){
            var character1 = symbolParser.parseTextElement(String.valueOf(unit.charAt(0)), CharacterType.PUNCTUATION);
            var word = wordParser.parseTextElement(unit.substring(1, unit.length() - 1));
            var character2 = symbolParser.parseTextElement(String.valueOf(unit.charAt(unit.length() - 1)), CharacterType.PUNCTUATION);

            lexicalUnit.add(character1);
            lexicalUnit.add(word);
            lexicalUnit.add(character2);
        }
        else for (int i=0;i<unit.length();i++)
            {
                var character=symbolParser.parseTextElement(unit.substring(i,i+1));
                lexicalUnit.add(character);
            }
        return lexicalUnit;
    }

}
