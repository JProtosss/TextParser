package by.epam.training.evgeniyprotasov.task2.action;

import by.epam.training.evgeniyprotasov.task2.entity.TextComponent;
import by.epam.training.evgeniyprotasov.task2.entity.impl.TextComposite;
import by.epam.training.evgeniyprotasov.task2.parser.impl.ParagraphParser;
import by.epam.training.evgeniyprotasov.task2.parser.impl.SentenceParser;
import by.epam.training.evgeniyprotasov.task2.parser.impl.TextParser;
import by.epam.training.evgeniyprotasov.task2.parser.impl.WordParser;
import by.epam.training.evgeniyprotasov.task2.reader.TextReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class TextActionTest {

    TextAction action;
    private static TextParser parser;
    private static TextReader reader;

    @BeforeClass
    public void setUp(){
        action = new TextAction();
        parser=new TextParser();
        reader=new TextReader();
    }


    @DataProvider(name = "textWriterData")
    public static Object[][] textReaderData(){
        return new Object[][]{{"data/output.txt", "data/input.txt"}};
    }

    @Test
    public void testSortWords(){
        TextComposite textComposite = parser.parseTextElement(reader.fileToString("data/input.txt"));
        List<TextComponent> wordsActual=action.sortWords(textComposite);

        String text=reader.fileToString("data/sortWords.txt");
        SentenceParser wordParser=new SentenceParser();
        List<TextComponent> wordsExpected;
        wordsExpected=wordParser.parseTextElement(text).getComponents();

        Assert.assertEquals(wordsActual.size(),wordsExpected.size());
    }

    @Test
    public void testSortSentences(){
        TextComposite textComposite = parser.parseTextElement(reader.fileToString("data/input.txt"));
        List<TextComponent> sentencesActual=action.sortSentences(textComposite);

        String text=reader.fileToString("data/sortSentences.txt");
        String[] textt=text.split("\n");
        Assert.assertEquals(sentencesActual.get(0).getString(),textt[0]);

    }

    @Test(dataProvider = "textWriterData")
    public void buildTextTest(String pathActual,String pathExpected)
    {
        TextComposite textComposite = parser.parseTextElement(reader.fileToString(pathActual));
        textComposite.getString();
        String actual = reader.fileToString(pathActual);
        String expected=reader.fileToString(pathExpected);
        Assert.assertEquals(actual,expected);
    }
}