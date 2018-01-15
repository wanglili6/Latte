package com.e_commerce.wll.latte;

import android.app.Application;

import com.example.latter.ec.icon.FontEcMode;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

import app.Latter;

/**
 * Created by wll on 2018/1/14.
 */

public class MyApplation extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latter.init(this)
                .withIcon(new FontAwesomeModule())//网上的字体
                .withIcon(new FontEcMode())//添加自定义字体
                .configuer();
    }
}
