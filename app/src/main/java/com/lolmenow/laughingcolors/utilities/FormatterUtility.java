package com.lolmenow.laughingcolors.utilities;

import android.annotation.SuppressLint;

public class FormatterUtility {

    @SuppressLint("DefaultLocale")
    public static String readableNumberFormat(int t){
        if (t < 1000)
            return String.format("%s", t);
        else if (t > 1000 && t < 1000000)
            return String.format("%.2fK", t/1000.0);
        else return String.format("%.2fM", t/1000000.0);
    }
}
