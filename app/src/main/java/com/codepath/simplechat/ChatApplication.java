package com.codepath.simplechat;

import android.app.Application;

import com.codepath.simplechat.models.Message;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.interceptors.ParseLogInterceptor;

/**
 * Created by evanwild on 6/28/16.
 */
public class ChatApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models here
        ParseObject.registerSubclass(Message.class);
        // Existing initialization happens after all classes are registered


        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(ChatActivity.APPLICATION_ID) // should correspond to APP_ID env variable
                .addNetworkInterceptor(new ParseLogInterceptor())
                .server(ChatActivity.SERVER_URL).build());
    }
}
