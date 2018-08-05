package com.citystarstourseg.backend;

public class Configurations {

    private static Configurations single_instance = null;

    //Data members
    public String test;

    //Constructor
    private Configurations()
    {
        test = "Hello, this is string test";
    }

    public static Configurations getInstance()
    {
        if(single_instance == null)
            single_instance = new Configurations();
        return single_instance;
    }
}
