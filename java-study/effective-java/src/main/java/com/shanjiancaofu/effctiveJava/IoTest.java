package com.shanjiancaofu.effctiveJava;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class IoTest {

    @Test
    public void testFile() throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream("/home/iap/123.txt");
        System.out.println(fileOutputStream);
    }
}
