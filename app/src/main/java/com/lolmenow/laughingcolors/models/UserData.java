package com.lolmenow.laughingcolors.models;

import com.lolmenow.laughingcolors.utilities.SharedPreferenceUtility;

import java.util.Set;

public class UserData {

    public static UserData instance;
    public Set<String> likesSet;
    public Set<String> dislikesSet;
    public Set<String> favoriteSet;

    private UserData(){

    }

    private void reLoad(){
        likesSet = SharedPreferenceUtility.getLikesSet();
        dislikesSet = SharedPreferenceUtility.getDisLikesSet();
        favoriteSet = SharedPreferenceUtility.getFavSet();
    }

    public void saveData(){
        SharedPreferenceUtility.save(likesSet, dislikesSet, favoriteSet);
    }

    public static UserData getInstance(){
        if (instance == null)
            instance = new UserData();
        instance.reLoad();
        return instance;
    }
}
