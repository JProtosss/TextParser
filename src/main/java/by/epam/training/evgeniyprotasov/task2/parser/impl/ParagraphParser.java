package by.epam.training.evgeniyprotasov.task2.parser.impl;

import by.epam.training.evgeniyprotasov.task2.entity.ComponentType;
import by.epam.training.evgeniyprotasov.task2.entity.TextComponent;
import by.epam.training.evgeniyprotasov.task2.entity.impl.TextComposite;
import by.epam.training.evgeniyprotasov.task2.parser.MainParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParagraphParser implements MainParser {
    private static final Logger logger = LogManager.getLogger();
    private SentenceParser sentenceParser;

    public ParagraphParser(){
        sentenceParser = new SentenceParser();
    }

    @Override
    public TextComponent parseTextElement(String paragraph){
        logger.info("Parsing text.");
        List<String> sentences = Arrays.stream(paragraph.split(SENTENCE_SPLIT_REGEX))
                .collect(Collectors.toList());

        TextComposite paragraphComposite = new TextComposite(ComponentType.PARAGRAPH);

        for (String sentence: sentences) {
            TextComponent sentenceComposite = sentenceParser.parseTextElement(sentence.trim());
            paragraphComposite.add(sentenceComposite);
        }
        logger.info("Text was parsed.");
        return paragraphComposite;
    }
}
