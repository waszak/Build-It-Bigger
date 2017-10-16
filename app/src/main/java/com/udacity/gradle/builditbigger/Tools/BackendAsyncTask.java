package com.udacity.gradle.builditbigger.Tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.android.librarydisplayjoke.JokeDisplayActivity;
import com.example.myapplication.backend.jokeBackendApi.model.JokeBean;
import com.example.myapplication.backend.jokeBackendApi.JokeBackendApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;


/**
 * https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
 */

public class BackendAsyncTask extends AsyncTask<String, Void, String> {
    static final String ROOT_URL = "http://10.0.2.2:8080/_ah/api/";
    private static JokeBackendApi myApiService = null;
    private Context mContext;

    public BackendAsyncTask(Context context){
        mContext = context;
    }

    @Override
    protected String doInBackground(String... strings) {
        if(myApiService == null){
            JokeBackendApi.Builder builder = new JokeBackendApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl(ROOT_URL);
            myApiService = builder.build();
        }
        try {
            return  myApiService.getJoke().execute().getJoke();
        }catch (IOException e){
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(mContext, JokeDisplayActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra(JokeDisplayActivity.INTENT_JOKE, result);
        if(mContext instanceof Activity) {
            ((Activity) mContext).startActivityForResult(intent, 1, null);
        }else{
            mContext.startActivity(intent);
        }
    }
}