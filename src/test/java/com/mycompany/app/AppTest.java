package com.mycompany.app;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    public void testTrueConcatination() {
      String[] s = {"ab", "cd", "ef", "gh", "ij"};
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
      int[] arr = {0,1,3,4};
      int a = 1;
      assertEquals(new App().meaningfulOperation(array,arr,a,s),"cdefghijabcdghijcd");
    }

    public void testOutOfBoundsInt() {
      String[] s = {"ab", "cd", "ef", "gh", "ij"};
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
      int[] arr = {0,1,3,4};
      int a = 99;
      assertEquals(new App().meaningfulOperation(array,arr,a,s),"cdefghijabcdghij");
    }

    public void testNullArray() {
      String[] s = {"ab", "cd", "ef", "gh", "ij"};
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
      int[] arr = null;
      int a = 1;
      assertEquals(new App().meaningfulOperation(array,arr,a,s),"cdefghijcd");
    }

    public void testEmptyArrayList() {
      String[] s = {"ab", "cd", "ef", "gh", "ij"};
      ArrayList<Integer> array = new ArrayList<>();
      int[] arr = {0,1,3,4};
      int a = 1;
      assertEquals(new App().meaningfulOperation(array,arr,a,s),"abcdghijcd");
    }
    public void testEmptyStringSet() {
      String[] s = {""};
      ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
      int[] arr = {0,1,3,4};
      int a = 1;
      assertEquals(new App().meaningfulOperation(array,arr,a,s),"");
    }

}
