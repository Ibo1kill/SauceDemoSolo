package com.saucedemo.tests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.DataProvider;

public class TestData {

   
    public static Object[][] read(String name) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/test/resources/testdata.csv"));
        List<String[]> rows = new ArrayList<>();

        for (String line : lines) {
            String[] values = line.split(",", -1);
            if (values[0].equals(name)) {
                rows.add(Arrays.copyOfRange(values, 1, values.length));
            }
        }
        return rows.toArray(new Object[0][]);
    }

    @DataProvider(name = "wrongLoginData")
    public static Object[][] wrongLoginData() throws IOException {
        return read("wrongLogin");
    }

    @DataProvider(name = "validLoginData")
    public static Object[][] validLoginData() throws IOException {
        return read("validLogin");
    }

    @DataProvider(name = "wrongCheckoutData")
    public static Object[][] wrongCheckoutData() throws IOException {
        return read("wrongCheckout");
    }

    @DataProvider(name = "validCheckoutData")
    public static Object[][] validCheckoutData() throws IOException {
        return read("validCheckout");
    }
}