package by.epam.training.evgeniyprotasov.task2.parser.impl;

import by.epam.training.evgeniyprotasov.task2.entity.CharacterType;
import by.epam.training.evgeniyprotasov.task2.entity.impl.Symbol;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SymbolParserTest {

    private SymbolParser symbolParser;

    @DataProvider(name = "dataSymbolParser")
    public static Object[][] symbolParserTestData(){
        return new Object[][]{
                {'6', CharacterType.NUMBER, new Symbol('6', CharacterType.NUMBER)},
                {'!', CharacterType.PUNCTUATION, new Symbol('!', CharacterType.PUNCTUATION)},
                {'a', CharacterType.LETTER, new Symbol('a', CharacterType.LETTER)}
        };
    }

    @BeforeClass
    public void setUp(){
        symbolParser = new SymbolParser();
    }

    @Test(dataProvider = "dataSymbolParser")
    public void testParseTextPart(Character character, CharacterType type, Symbol symbol) {
        Assert.assertEquals(new Symbol(character, type).getString(), symbol.getString());
    }

    @AfterClass
    public void tearDown(){
        symbolParser = null;
    }

}