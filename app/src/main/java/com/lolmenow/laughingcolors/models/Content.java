package com.lolmenow.laughingcolors.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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
        for (int i = 1 ; i <= 2195 ; i++){
            String url = String.format("http://104.236.43.23:3001/laughingcolours/%s.jpg",i);
            contentList.add(new Content(i+"", "", url, ContentType.IMAGE));
        }
        Collections.shuffle(contentList);
        return contentList;
    }
}
