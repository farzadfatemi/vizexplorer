package com.vizexplorer.eval;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;

import static org.junit.Assert.assertTrue;

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
      System.setOut(new PrintStream(outContent));

      String [] args = new String[]{"", "Biff", "Male", "19950110"};
      App.main(args);

      assertTrue(outContent.toString().startsWith("Person instance created: com.vizexplorer.eval.Person@"));

      args = new String[]{"", "", "", "bad date"};
      App.main(args);

    }
    finally
    {
      System.setOut(null);
    }
  }
}
