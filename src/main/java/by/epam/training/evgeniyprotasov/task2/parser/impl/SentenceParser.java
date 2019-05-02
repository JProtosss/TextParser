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

public class SentenceParser implements MainParser {
    private static final Logger logger = LogManager.getLogger();
    private UnitParser unitParser;

    public SentenceParser(){
        unitParser = new UnitParser();
    }

    @Override
    public TextComponent parseTextElement(String sentence){
        logger.info("Parsing Sentence.");
        List<String> units = Arrays.stream(sentence.split(UNIT_SPLIT_REGEX))
                .collect(Collectors.toList());

        TextComposite sentenceComposite = new TextComposite(ComponentType.SENTENCE);

        for (String unit: units) {
            TextComponent UnitComposite = unitParser.parseTextElement(unit.trim());
            sentenceComposite.add(UnitComposite);
        }
        logger.info("Sentence was parsed.");
        return sentenceComposite;
    }
}
