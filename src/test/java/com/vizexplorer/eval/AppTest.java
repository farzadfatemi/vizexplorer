package com.vizexplorer.eval;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
  @Test
  public void testMain() throws ParseException
  {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    try
    {
//      System.setOut(new PrintStream(outContent));

      String [] args = new String[]{"","get","667110fc-c375-4040-8abc-34db40d650e6", "", "", ""};
      App.main(args);

//      assertTrue(outContent.toString().startsWith("Person instance created: com.vizexplorer.eval.Person@"));

      args = new String[]{"","","", "", "", "bad date"};
      App.main(args);

    }
    finally
    {
      System.setOut(null);
    }
  }
}
