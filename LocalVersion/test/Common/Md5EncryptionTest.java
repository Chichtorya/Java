/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Common;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chich
 */
public class Md5EncryptionTest {
    
    public Md5EncryptionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getMd5 method, of class Md5Encryption.
     */
    @Test
    public void testGetMd5() {
      
         String input = "Duy Anh is so fucking handsome";
        String expectedOutput = "4fdd6744811a1a90e2bfcc915a7578b7";

        String actualOutput = Md5Encryption.getMd5(input);

        assertEquals(expectedOutput, actualOutput);
     
   

        // TODO review the generated test code and remove the default call to fail.
   //     fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Md5Encryption.
     */
    @Test
    public void testMain() throws Exception {
    }

    /**
     * Test of main method, of class Md5Encryption.
     */
   
}
