package by.epam.training.evgeniyprotasov.task2;

import by.epam.training.evgeniyprotasov.task2.action.TextAction;
import by.epam.training.evgeniyprotasov.task2.entity.TextComponent;
import by.epam.training.evgeniyprotasov.task2.entity.impl.TextComposite;
import by.epam.training.evgeniyprotasov.task2.parser.impl.TextParser;
import by.epam.training.evgeniyprotasov.task2.reader.TextReader;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        TextReader reader=new TextReader();
        String text=reader.fileToString(new File("data/input.txt"));
        TextParser parser=new TextParser();
        TextComposite composite=parser.parseTextElement(text);
        TextAction action=new TextAction();
        List<TextComponent> words=action.sortWords(composite);
        List<TextComponent> sentences=action.sortSentences(composite);

        action.buildText(composite,new File("data/output.txt"));
    }
}
