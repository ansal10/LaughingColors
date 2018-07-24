package com.lolmenow.laughingcolors.adapters;


import android.app.Activity;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.lolmenow.laughingcolors.R;
import com.lolmenow.laughingcolors.models.Content;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainContentAdapter extends RecyclerView.Adapter {
    private final Activity activity;
    public List<Content> contentList ;
    Picasso.Builder picassoBuilder;
    Picasso picasso;


    public MainContentAdapter(List<Content> contentList, Activity activity){
        this.contentList = contentList;
        this.activity = activity;
        picassoBuilder = new Picasso.Builder(activity);
        picasso = picassoBuilder.listener(new Picasso.Listener() {
            @Override
            public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                exception.printStackTrace();
            }
        }).build();

    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        if (contentList.get(i).contentType == Content.ContentType.IMAGE){
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.image_content_cell, viewGroup, false);
            return new ImageTypeViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        final Content content = contentList.get(i);

        switch (viewHolder.getItemViewType()) {
            case 0:  // image
                ((ImageTypeViewHolder)(viewHolder)).bind(content);
        }

    }

    @Override
    public int getItemCount() {
        return contentList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return contentList.get(position).contentType.getValue();
    }


    public class ImageTypeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.image_content_cell_imageview_id) public ImageView imageView;
        @BindView(R.id.image_content_cell_share_imageview_id)public ImageView shareImageView;
        @BindView(R.id.image_content_cell_download_imageview_id)public ImageView downloadImageView;
        @BindView(R.id.image_content_cell_whatsapp_imageview_id)public ImageView whatsappImageView;
        @BindView(R.id.image_content_cell_like_imageview_id)public ImageView likeImageView;
        @BindView(R.id.image_content_cell_dislike_imageview_id)public ImageView dislikeImageView;
        @BindView(R.id.image_content_cell_comment_imageview_id)public ImageView commentImageView;
        @BindView(R.id.image_content_cell_fav_imageview_id)public ImageView favImageView;


        public ImageTypeViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final Content content) {
            picasso.load(content.imageUrl)
                    .error(R.drawable.ic_launcher_background)
                    .placeholder(R.drawable.progress_animation)
                    .into(imageView);

            favImageView.setOnClickListener(this);
            likeImageView.setOnClickListener(this);
            dislikeImageView.setOnClickListener(this);
            commentImageView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == favImageView.getId()){
                Picasso.get().load(R.drawable.favorite_filled).into(favImageView);
            }
        }
    }
}
