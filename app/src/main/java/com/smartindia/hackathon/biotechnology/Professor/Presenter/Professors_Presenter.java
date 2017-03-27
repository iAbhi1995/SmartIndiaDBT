package com.smartindia.hackathon.biotechnology.Professor.Presenter;

/**
 * Created by ayush on 27-03-2017.
 */

public class Professors_Presenter {
    private static final Professors_Presenter ourInstance = new Professors_Presenter();

    public static Professors_Presenter getInstance() {
        return ourInstance;
    }

    private Professors_Presenter() {
    }
}
