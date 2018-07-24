package com.lolmenow.laughingcolors.models;

import java.util.ArrayList;
import java.util.List;

public class Content {

    public String id;
    public String title;
    public String imageUrl;
    public ContentType contentType;

    public Content(String id, String title, String imageUrl, ContentType contentType){
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.contentType = contentType;
    }


    public enum ContentType {
        IMAGE(0) ,
        VIDEO(1) ,
        TEXT(2);

        private final int value;

        ContentType(final int newValue) {
            value = newValue;
        }

        public int getValue() { return value; }
    }
    
    public static List<Content> dummpyData(){
        List<Content> contentList = new ArrayList<>();
        for (int i = 0 ; i < 25 ; i++){
            String url = String.format("http://104.236.43.23:3001/deepika/%s.jpeg",i);
            contentList.add(new Content("", "", url, ContentType.IMAGE));
        }
        return contentList;
    }
}
