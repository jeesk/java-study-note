package com.shanjiancaofu.java9;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ResourceEnhance {
    // 支持更加进件的try with resource
    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fos1 = new FileOutputStream("1");
        FileOutputStream fos2 = new FileOutputStream("2");
        try (fos1; fos2) {

        } catch (Exception e) {

        }
    }
}
