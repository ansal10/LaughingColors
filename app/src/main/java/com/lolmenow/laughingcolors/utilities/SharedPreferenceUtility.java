package com.lolmenow.laughingcolors.utilities;

import android.content.Context;
import android.content.SharedPreferences;

import com.lolmenow.laughingcolors.MyApplication;

import java.util.HashSet;
import java.util.Set;

public class SharedPreferenceUtility {

    private static final String SHARED_PREF_NAME = "LAUGHING_COLOURS";
    private static final String LIKES_SHARED_PREF_NAME = "LAUGHING_COLOURS_LIKES";
    private static final String DISKILES_SHARED_PREF_NAME = "LAUGHING_COLOURS_DISLIKES";
    private static final String FAV_SHARED_PREF_NAME = "LAUGHING_COLOURS_FAV";
    private static final SharedPreferences preferences =  MyApplication.getAppContext().getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

    public static Set<String> getLikesSet(){
       Set<String> set = preferences.getStringSet(LIKES_SHARED_PREF_NAME, null);
       if (set == null){
           SharedPreferences.Editor editor = preferences.edit();
           set = new HashSet<>();
           preferences.getStringSet(LIKES_SHARED_PREF_NAME, set);
           editor.apply();
           return set;
       }else
           return set;
    }

    public static Set<String> getDisLikesSet(){
        Set<String> set = preferences.getStringSet(DISKILES_SHARED_PREF_NAME, null);
        if (set == null){
            SharedPreferences.Editor editor = preferences.edit();
            set = new HashSet<>();
            preferences.getStringSet(DISKILES_SHARED_PREF_NAME, set);
            editor.apply();
            return set;
        }else
            return set;
    }

    public static Set<String> getFavSet(){
        Set<String> set = preferences.getStringSet(FAV_SHARED_PREF_NAME, null);
        if (set == null){
            SharedPreferences.Editor editor = preferences.edit();
            set = new HashSet<>();
            preferences.getStringSet(FAV_SHARED_PREF_NAME, set);
            editor.apply();
            return set;
        }else
            return set;
    }



    public static void save(Set<String> likeSet, Set<String> dislikesSet, Set<String> favSet){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putStringSet(LIKES_SHARED_PREF_NAME, likeSet);
        editor.putStringSet(DISKILES_SHARED_PREF_NAME, dislikesSet);
        editor.putStringSet(FAV_SHARED_PREF_NAME, favSet);
        editor.apply();
    }

}
