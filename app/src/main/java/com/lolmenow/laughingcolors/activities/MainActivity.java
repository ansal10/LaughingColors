package com.lolmenow.laughingcolors.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;
import android.widget.ImageView;

import com.lolmenow.laughingcolors.R;
import com.lolmenow.laughingcolors.adapters.MainContentAdapter;
import com.lolmenow.laughingcolors.models.Content;
import com.lolmenow.laughingcolors.models.UserData;
import com.lolmenow.laughingcolors.utilities.SharedPreferenceUtility;
import com.lolmenow.laughingcolors.utilities.SharingUtility;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContentAdapter.UserActionInterface {

    public UserData userData;

    public MainContentAdapter mainContentAdapter;
    @BindView(R.id.activity_main_recycler_view_id) public RecyclerView mainContentRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(mainContentRecyclerView);
        mainContentAdapter = new MainContentAdapter(Content.dummpyData(), this);
        mainContentRecyclerView.setHasFixedSize(true);
        mainContentRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainContentRecyclerView.setAdapter(mainContentAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        userData = UserData.getInstance();

    }

    @Override
    protected void onPause() {
        super.onPause();
        userData.saveData();
    }

    @Override
    public void like(Content content, View view) {
        if (userData.likesSet.contains(content.getId())){  // already a liked image
            userData.likesSet.remove(content.getId());
            ((ImageView)view).setImageResource(R.drawable.like_hollow);
        }else{
            userData.likesSet.add(content.getId());
            ((ImageView)view).setImageResource(R.drawable.like_filled);
        }
    }

    @Override
    public void dislike(Content content, View view) {
        if (userData.dislikesSet.contains(content.getId())){  // already a dislikes image
            userData.dislikesSet.remove(content.getId());
            ((ImageView)view).setImageResource(R.drawable.dislike_hollow);
        }else{
            userData.dislikesSet.add(content.getId());
            ((ImageView)view).setImageResource(R.drawable.dislike_filled);
        }
    }

    @Override
    public void fav(Content content, View view) {
        if (userData.favoriteSet.contains(content.getId())){  // already a fav image
            userData.favoriteSet.remove(content.getId());
            ((ImageView)view).setImageResource(R.drawable.favorite_hollow);
        }else{
            userData.favoriteSet.add(content.getId());
            ((ImageView)view).setImageResource(R.drawable.favorite_filled);
        }
    }

    @Override
    public void generalShare(Content content, View view) {
        SharingUtility.shareImage((ImageView)view, SharingUtility.DOWNLOAD_APP_MESSAGE);
    }

    @Override
    public void whatsappShare(Content content, View view) {
        SharingUtility.shareImage((ImageView)view, SharingUtility.DOWNLOAD_APP_MESSAGE, SharingUtility.WHATSAPP_PACKAGE_NAME);
    }
}
