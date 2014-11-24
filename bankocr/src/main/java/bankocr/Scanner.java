package bankocr;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scanner
{
    /*
     * 
     * _ _ _ _ _ _ _ | _| _||_||_ |_ ||_||_| ||_ _| | _||_| ||_| _|
     */
    String ONE = "   " + "  |" + "  |";
    String TWO = " _ " + " _|" + "|_ ";
    String THREE = " _ " + " _|" + " _|";
    String FOUR = "   " + "|_|" + "  |";
    String FIVE = " _ " + "|_ " + " _|";
    String SIX = " _ " + "|_ " + "|_|";
    String SEVEN = " _ " + "  |" + "  |";
    String EIGHT = " _ " + "|_|" + "|_|";
    String NINE = " _ " + "|_|" + " _|";

    int WIDTH = 3;
    String file;
    String text = "";
    Map<String, String> numbers;
    private List<String> lines;

    public Scanner(String string)
    {
        file = string;
        initNumbers();
        readFile();
    }

    private void initNumbers()
    {
        numbers = new HashMap<String, String>();
        numbers.put(ONE, "1");
        numbers.put(TWO, "2");
        numbers.put(THREE, "3");
        numbers.put(FOUR, "4");
        numbers.put(FIVE, "5");
        numbers.put(SIX, "6");
        numbers.put(SEVEN, "7");
        numbers.put(EIGHT, "8");
        numbers.put(NINE, "9");
    }

    private void readFile()
    {
        try
        {
            lines = read(file);
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("invalid File ", e);
        }
    }

    public String getText()
    {

        for (int i = 0; i < getLength(); i++)
        {
            text = text + getChar(i + 1, lines);

        }
        return text;
    }

    private int getLength()
    {
        return lines.get(0).length() / WIDTH;
    }

    private String getChar(int i,
                           List<String> lines)
    {
        String line1, line2, line3;
        line1 = lines.get(0);
        line2 = lines.get(1);
        line3 = lines.get(2);

        int startChar = (i * WIDTH) - WIDTH;
        int finalChar = (i * WIDTH);

        return getNumber(line1, line2, line3, startChar, finalChar);

    }

    private String getNumber(String line1,
                             String line2,
                             String line3,
                             int startChar,
                             int finalChar)
    {

        String toComapre = line1.substring(startChar, finalChar)
                + line2.substring(startChar, finalChar) + line3.substring(startChar, finalChar);

        return numbers.get(toComapre);
    }

    private List<String> read(String file) throws Exception
    {

        InputStream fis;
        BufferedReader br;
        List<String> lines = new ArrayList<String>();
        String line;

        fis = new FileInputStream(file);
        br = new BufferedReader(new InputStreamReader(fis, Charset.forName("UTF-8")));
        int i = 0;
        while ((line = br.readLine()) != null)
        {
            System.out.println(line);
            lines.add(i, line);
            i++;
        }

        br.close();

        return lines;
    }
}
