package com.udacity.gradle.builditbigger.backend;

import com.divitngoc.android.javajokes.DivitJokes;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /** A simple endpoint method */
    @ApiMethod(name = "gceJokes")
    public MyJoke gceJokes() {
        MyJoke response = new MyJoke();
        String[] jokes = DivitJokes.getJokes();
        response.setJokes(jokes);
        return response;
    }
}
