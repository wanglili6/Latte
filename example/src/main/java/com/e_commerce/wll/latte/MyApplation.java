package com.e_commerce.wll.latte;

import android.app.Application;

import com.Latter.latter_core.app.Latter;
import com.example.latter.ec.icon.FontEcMode;
import com.joanzapata.iconify.fonts.FontAwesomeModule;


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
