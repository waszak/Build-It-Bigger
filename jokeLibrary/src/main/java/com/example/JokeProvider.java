package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JokeProvider {
    private Random mRandom;
    private ArrayList<Joke> mJokes;

    public JokeProvider(){
        mRandom = new Random();
        mJokes = new ArrayList<>();
        mJokes.add(new Joke("Standing in the park, I was wondering why a Frisbee" +
                " gets larger the closer it gets. Then it hit me."));
        mJokes.add(new Joke("I needed a password eight characters long" +
                " so I picked Snow White and the Seven Dwarfs."));
        mJokes.add(new Joke("I met a painter who only paints using" +
                " Japanese rice wine, but it was just sake for art's sake."));
    }
    public List<Joke> getJokes(){
        return mJokes;
    }
    public Joke getRandomJoke(){
        if(mJokes.size()==0){
            return new Joke("");
        }
        return  mJokes.get(mRandom.nextInt(mJokes.size()));
    }
}
