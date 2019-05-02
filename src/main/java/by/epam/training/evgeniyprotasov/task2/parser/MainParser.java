package by.epam.training.evgeniyprotasov.task2.parser;

import by.epam.training.evgeniyprotasov.task2.entity.TextComponent;

public interface MainParser {

    String PARAGRAPH_SPLIT_REGEX = "\\t|\\r";
    String SENTENCE_SPLIT_REGEX = "(?<=[.!?])";
    String UNIT_SPLIT_REGEX = "\\p{Blank}+";

    String PUNCTUATION_REGEX = "[\\p{Punct}]";
    String LETTER_REGEX = "\\p{L}";
    String NUMERIC_REGEX = "\\d";
    String BRACKET_REGEX="\\(\\)";

    String WORD_REGEX = LETTER_REGEX + "+";
    String WORD_WITH_PUNCT_ENDS = WORD_REGEX + PUNCTUATION_REGEX;
    String WORD_WITH_PUNCT_BEGINS = PUNCTUATION_REGEX + WORD_REGEX;
    String WORD_WITH_PUNCT_BEGINS_ENDS = PUNCTUATION_REGEX + WORD_WITH_PUNCT_ENDS;
    String COMPLICATED_WORD = WORD_REGEX + "-" + WORD_REGEX + "(-" + WORD_REGEX + ")*";

    TextComponent parseTextElement(String text);

}
