package by.epam.training.evgeniyprotasov.task2.reader;

import org.testng.Assert;
import org.testng.TestException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class TextReaderTest {

    private TextReader textReader;

    @BeforeClass
    public void setUp(){
        textReader = new TextReader();
    }

    @DataProvider(name = "textReaderData")
    public static Object[][] textReaderData(){
        return new Object[][]{{"data/input.txt",  "    There are five types of schools in the US educational system. They are: kindergarten, elementary school, middle school, high school and private school.\r\n" +
                "    Children go to kindergarten when they are 5 years old. They go to elementary school from ages 6 through 11 (1-5 grades), middle school from ages 12 through 14 (6-8 grades) and high school from ages 15 through 19 (9-12 grades). About 90 percent of all children attend public school, which is free.\r\n" +
                "    The other 10 percent go in private schools, which often include religious education. They are similar to the public schools but parents must pay for their children to go to these schools. About half of all private schools are run by Catholics.\r\n" +
                "    That is all."}};
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testFileToStringNegative() {
        textReader.fileToString("data/fakeFile.txt");
    }

    @Test(dataProvider = "textReaderData")
    public void testFileToStringPositive(String path, String expected) {
        String actual = textReader.fileToString(path);
        Assert.assertEquals(actual, expected);
    }


    @AfterClass
    public void tearDown(){
        textReader = null;
    }


}