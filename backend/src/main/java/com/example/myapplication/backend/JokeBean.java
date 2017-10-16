package com.example.myapplication.backend;

import com.example.JokeProvider;

/**
 * The object model for the data we are sending through endpoints
 */
public class JokeBean {

    private JokeProvider mJokeProvider;

    public  JokeBean(){
        mJokeProvider = new JokeProvider();
    }
    public String getJoke(){
        return mJokeProvider.getRandomJoke().getJoke();
    }
}