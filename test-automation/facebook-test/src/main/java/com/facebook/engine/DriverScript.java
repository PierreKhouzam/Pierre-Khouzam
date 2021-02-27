package com.facebook.engine;


import com.facebook.utilities.constants.impConstants;

import java.io.FileInputStream;
import java.util.Properties;

public class DriverScript {

    public static Properties objectRepo;
    public static String path;

    public static void objectRepoLoad() {
        try {
            path = impConstants.objectRepoPath;
            FileInputStream fs = new FileInputStream(path);
            objectRepo = new Properties(System.getProperties());
            objectRepo.load(fs);

        } catch (Exception e) {
            System.out.println("Couldn't load object Repo " + e.getMessage());
        }
    }


}

