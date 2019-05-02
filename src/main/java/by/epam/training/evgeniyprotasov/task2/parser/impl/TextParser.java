package by.epam.training.evgeniyprotasov.task2.parser.impl;

import by.epam.training.evgeniyprotasov.task2.entity.ComponentType;
import by.epam.training.evgeniyprotasov.task2.entity.TextComponent;
import by.epam.training.evgeniyprotasov.task2.parser.MainParser;
import by.epam.training.evgeniyprotasov.task2.entity.impl.TextComposite;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextParser implements MainParser {


    private ParagraphParser paragraphParser;

    public TextParser(){
        paragraphParser = new ParagraphParser();
    }

    @Override
    public TextComposite parseTextElement(String text){
        List<String> paragraphs = Arrays.stream(text.split(PARAGRAPH_SPLIT_REGEX)).collect(Collectors.toList());

        TextComposite textComposite = new TextComposite(ComponentType.TEXT);

        for (String paragraph: paragraphs) {
            TextComponent paragraphComposite = paragraphParser.parseTextElement(paragraph.trim());
            textComposite.add(paragraphComposite);
        }

        return textComposite;
    }
}
