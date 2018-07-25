package com.lolmenow.laughingcolors;

import android.app.Application;
import android.content.Context;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

/**
 * Created by shubhamagrawal on 04/04/17.
 */

public class MyApplication extends Application {

    private static MyApplication instance;
    private static final String TAG = MyApplication.class.getSimpleName();
//    private DatabaseReference mUserDatabase;
//    private FirebaseAuth mAuth;

    @Override
    public void onCreate() {
//        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
//        Log.d(TAG, "fcm token: " + refreshedToken);
//        FirebaseMessaging.getInstance().subscribeToTopic(Constants.TOPIC);
//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

         /* Picasso */

        Picasso.Builder builder = new Picasso.Builder(this);
        builder.downloader(new OkHttp3Downloader(this, Integer.MAX_VALUE));
        Picasso built = builder.build();
        built.setLoggingEnabled(true);
        Picasso.setSingletonInstance(built);

//        mAuth = FirebaseAuth.getInstance();
//
//        if(mAuth.getCurrentUser() != null) {
//
//            mUserDatabase = FirebaseDatabase.getInstance()
//                    .getReference().child("users").child(mAuth.getCurrentUser().getUid());
//
//            mUserDatabase.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                    if (dataSnapshot != null) {
//                        mUserDatabase.child("online").onDisconnect().setValue(ServerValue.TIMESTAMP);
//                    }
//                }
//
//                @Override
//                public void onCancelled(DatabaseError databaseError) {
//
//                }
//            });
//        }
        super.onCreate();
        instance = this;
    }

    public static MyApplication getInstance() {
        return instance;
    }

    public static Context getAppContext() {
        Context context = instance.getApplicationContext();
        return context;
    }
}
