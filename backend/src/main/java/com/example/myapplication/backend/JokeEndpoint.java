/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;


/**
 * An endpoint class we are exposing
 */
@Api(
        name = "jokeBackendApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.example.com",
                ownerName = "backend.myapplication.example.com",
                packagePath = ""
        )
)
public class JokeEndpoint {

    /**
     * A simple endpoint method that takes a joke and returns joke
     */
    @ApiMethod(name = "getJoke")
    public JokeBean getJoke(JokeBean jokeBean) {
        return jokeBean;
    }

}
