package com.lolmenow.laughingcolors.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;

import com.lolmenow.laughingcolors.R;
import com.lolmenow.laughingcolors.adapters.MainContentAdapter;
import com.lolmenow.laughingcolors.models.Content;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

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
}
