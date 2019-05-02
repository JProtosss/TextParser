package by.epam.training.evgeniyprotasov.task2.action;

import by.epam.training.evgeniyprotasov.task2.entity.ComponentType;
import by.epam.training.evgeniyprotasov.task2.entity.TextComponent;
import by.epam.training.evgeniyprotasov.task2.entity.impl.Symbol;
import by.epam.training.evgeniyprotasov.task2.entity.impl.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.w3c.dom.Text;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TextAction {
    private static final Logger logger = LogManager.getLogger();

    public  List<TextComponent> sortWords(TextComposite text)
    {
        TextComposite clone=text;
        List<TextComponent> words = new ArrayList<>();
        List<TextComponent> paragraphs = clone.getComponents();

        for (TextComponent paragraph : paragraphs) {
            for (TextComponent sentence : paragraph.getComponents()) {
                for (TextComponent unitComposite : sentence.getComponents()) {
                    for (TextComponent unitElement : unitComposite.getComponents()) {
                        if (unitElement.getComponentType() == ComponentType.WORD) {
                            words.add(unitElement);
                        }
                    }
                }
                words.sort(Comparator.comparingInt(s -> s.getComponents().size()));
            }
        }
        return words;
    }

    public List<TextComponent> sortSentences(TextComposite text) {

        List<TextComponent> sentences = new ArrayList<>();
        List<TextComponent> paragraphs = text.getComponents();
        for (TextComponent paragraph : paragraphs) {
            for (TextComponent sentence : paragraph.getComponents()) {
                sentences.add(sentence);
            }
        }
        sentences.sort(Comparator.comparingInt(s -> s.getComponents().size()));
        return sentences;
    }


    public void buildText(TextComposite text, File file) {
        try (BufferedWriter out = new BufferedWriter(
                new FileWriter(file.getAbsolutePath()))) {
            out.write(text.getString());
        } catch (IOException e) {
            logger.error("Cannot write text to file!");
        }
    }

}
