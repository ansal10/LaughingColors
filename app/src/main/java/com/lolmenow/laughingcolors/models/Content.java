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
        String []urls = new String[]{"https://scontent.fdel6-1.fna.fbcdn.net/v/t1.0-9/36824595_1175378052854101_5333373985969143808_o.jpg?_nc_cat=0&oh=123454fd2e247ae4f04c2072a9f0b925&oe=5BCAFCDE","https://scontent.fdel6-1.fna.fbcdn.net/v/t1.0-9/36772317_1175377819520791_3187563833321324544_o.jpg?_nc_cat=0&oh=a230eac265d705aadba81ede5bf3d79f&oe=5C0CA108","https://scontent.fdel6-1.fna.fbcdn.net/v/t1.0-9/36750445_1175377299520843_6664715209510223872_o.jpg?_nc_cat=0&oh=54a842e8996f5402a814e39477ab1f6b&oe=5BD2FAF0","https://scontent.fdel6-1.fna.fbcdn.net/v/t1.0-9/36792544_1175376322854274_8113214838714400768_o.jpg?_nc_cat=0&oh=943951c0010396c60d7ad87ac4baf7e1&oe=5C13B8E3","https://scontent.fdel6-1.fna.fbcdn.net/v/t1.0-9/36811479_1175367172855189_3286617225254928384_o.jpg?_nc_cat=0&oh=a96ed06aa174c071d1342111bb953796&oe=5BE26929","https://scontent.fdel6-1.fna.fbcdn.net/v/t1.0-9/36856435_1175305992861307_1520636847640805376_o.jpg?_nc_cat=0&oh=f0dffbbe878b9c0aec77db3e20d96878&oe=5BC90711","https://scontent.fdel6-1.fna.fbcdn.net/v/t1.0-9/36795917_1175221222869784_8746427424851361792_o.jpg?_nc_cat=0&oh=b5736e2e73ba02e4fea0944c7f0b4e8c&oe=5BC6BF16","https://scontent.fdel6-1.fna.fbcdn.net/v/t1.0-9/36847991_1175056159552957_8832574139412774912_o.jpg?_nc_cat=0&oh=fbb39cc7c93e2096387fb899316f4c75&oe=5BD38723","https://scontent.fdel6-1.fna.fbcdn.net/v/t1.0-9/36689267_1175027306222509_5087826986215145472_o.jpg?_nc_cat=0&oh=b438e417e60684922da020ef96f49720&oe=5C123F00","https://scontent.fdel6-1.fna.fbcdn.net/v/t1.0-9/36856082_1174911122900794_2316636592741023744_o.png?_nc_cat=0&oh=74a97c7922296d9dcd70ea0518418e4d&oe=5BD655C4","https://scontent.fdel6-1.fna.fbcdn.net/v/t1.0-9/36709313_1174910726234167_5505510227878871040_o.png?_nc_cat=0&oh=cdb6a013ab10230f3fbaab6b9a9bd0b4&oe=5C0CE59F","https://scontent.fdel6-1.fna.fbcdn.net/v/t1.0-9/36868142_1174910232900883_5173877583703441408_n.png?_nc_cat=0&oh=91df5d37f4ac6a7d61a55d32b3a8ae7e&oe=5BDD1D38"};
        List<Content> contentList = new ArrayList<>();
        for (String url: urls){
            contentList.add(new Content("", "", url, ContentType.IMAGE));
        }
        return contentList;
    }
}
