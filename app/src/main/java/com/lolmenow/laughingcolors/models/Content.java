package com.lolmenow.laughingcolors.models;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Content {

    private String id;
    private String title;
    private String imageUrl;
    private ContentType contentType;

    public static final Long dt = 1532534241000L;

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
            contentList.add(new Content(i+"", "", "", ContentType.IMAGE));
        }
        Collections.shuffle(contentList);
        return contentList;
    }

    public String getImageUrl(){
        return String.format("http://104.236.43.23:3001/laughingcolours/%s.jpg",id);
    }

    public Integer getLikesCount(){

        int t = (int)DateTime.now().minus(dt).getMillis()/(1000*60);  // per minute
        return Math.abs(this.getImageUrl().hashCode()) % 100000 + t;
    }
    public Integer getDislikesCount(){
        int t = (int)DateTime.now().minus(dt+100000000).getMillis()/(1000*60);  // per hour
        return Math.abs(this.id.hashCode()) %100 + t;
    }
}
