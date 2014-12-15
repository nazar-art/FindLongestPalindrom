package com.epam.edu.view;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class);

    static {
        PropertyConfigurator.configure("./log4j.properties");
    }

    public static void main(String[] args) {
        try {
            new Application().start();
        } catch (Exception e) {
            LOG.error("error in main", e);
        }
    }

}
