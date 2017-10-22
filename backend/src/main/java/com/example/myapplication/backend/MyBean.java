package com.example.myapplication.backend;

import com.example.JokeProvider;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {

    private JokeProvider mJokeProvider;

    public MyBean() {
        mJokeProvider = new JokeProvider();
    }

    public String getJoke() {
        return mJokeProvider.getRandomJoke().getJoke();
    }
}