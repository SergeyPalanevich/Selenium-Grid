package com.epam.grid.core.runners;

import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;

import java.io.IOException;
import java.util.List;

public class RunnerTestNG {
    public static final String PATH_TO_XML = "src/main/resources/suite.xml";

    public static void main(String[] args) {

        TestNG testNG = new TestNG();
        try {
            List<XmlSuite> suite = (List<XmlSuite>) (new Parser(PATH_TO_XML)).parse();
            testNG.setXmlSuites(suite);
            testNG.run();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }
}