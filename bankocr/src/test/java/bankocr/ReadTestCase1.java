package bankocr;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ReadTestCase1
{

    @Test
    public void testShouldReturn1()
    {

        Scanner s = new Scanner("/PROYECTOS/bankocr/src/test/resources/input1.txt");

        String result = s.getText();

        assertTrue("Scanner must retrieve a 1", result.equals("1"));
    }

    @Test
    public void testShouldReturn11()
    {

        Scanner s = new Scanner("/PROYECTOS/bankocr/src/test/resources/input11.txt");

        String result = s.getText();

        assertTrue("Scanner must retrieve a 11", result.equals("11"));
    }

    @Test
    public void testShouldReturn2()
    {

        Scanner s = new Scanner("/PROYECTOS/bankocr/src/test/resources/input2.txt");

        String result = s.getText();

        assertTrue("Scanner must retrieve a 2", result.equals("2"));
    }

    @Test
    public void testShouldReturn12()
    {

        Scanner s = new Scanner("/PROYECTOS/bankocr/src/test/resources/input12.txt");

        String result = s.getText();

        assertTrue("Scanner must retrieve a 12", result.equals("12"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldCrashReading()
    {
        new Scanner("NO_EXISTE.txt");
    }

    @Test
    public void testShouldReturnTotal()
    {

        Scanner s = new Scanner("/PROYECTOS/bankocr/src/test/resources/inputTOTAL.txt");

        String result = s.getText();
        System.out.println(result);
        assertTrue("Scanner must retrieve a 123456789", result.equals("123456789"));
    }

}
