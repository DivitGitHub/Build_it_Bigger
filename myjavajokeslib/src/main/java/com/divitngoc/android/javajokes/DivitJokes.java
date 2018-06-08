package com.divitngoc.android.javajokes;

public class DivitJokes {

    private final static String[] jokes = {
            "What's the best thing about Switzerland?\nI don't know, but the flag is a big plus.",
            "Why did the invisible man turned down the job offer?\nCause he couldn't see himself doing it.",
            "Wife: How do I look?\nHusband: With your eyes.",
            "You heard of that new band 1023MB?\nThey're good but they haven't got a gig yet.",
            "I invited my girlfriend to the gym with me and then didn't show up...\nI hope she gets the message that we're not working out."};

    private DivitJokes() {
    }

    public static String[] getJokes() {
        return jokes;
    }

    public static String tellRandomJoke() {
        return jokes[((int) (Math.random() * jokes.length))];
    }

}
