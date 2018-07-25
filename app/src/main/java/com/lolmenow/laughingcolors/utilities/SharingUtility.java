package com.lolmenow.laughingcolors.utilities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.widget.ImageView;

import com.lolmenow.laughingcolors.MyApplication;

import java.io.File;
import java.io.FileOutputStream;

public class SharingUtility {


    public static final String WHATSAPP_PACKAGE_NAME = "com.whatsapp";
    public static final String DOWNLOAD_APP_MESSAGE = "For more memes download laughing colours app http://bitly.com";

    public static void shareImage(Bitmap bitmap, String text, String packageName){
        Context context = MyApplication.getInstance().getApplicationContext();
        try {
            File file = new File(context.getExternalCacheDir(),"laughingcolours.jpeg");
            FileOutputStream fOut = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
            fOut.flush();
            fOut.close();
            final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
            intent.putExtra(Intent.EXTRA_TEXT, text);
            intent.setType("image/jpeg");

            if (packageName != null && packageName.length() > 0)
                intent.setPackage(packageName);

            StartActivityUtility.startActivity(Intent.createChooser(intent, "Share image via"), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void shareImage(Bitmap bitmap, String text){
        shareImage(bitmap, text, null);
    }

    public static void shareImage(ImageView imageView, String text, String packageName){
        Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
        shareImage(bitmap, text, packageName);
    }
    public static void shareImage(ImageView imageView, String text){
        Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
        shareImage(bitmap, text, null);
    }

}
