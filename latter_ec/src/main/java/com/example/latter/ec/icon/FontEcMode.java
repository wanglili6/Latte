package com.example.latter.ec.icon;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

/**
 * Created by wll on 2018/1/15.
 */

public class FontEcMode implements IconFontDescriptor {


    @Override
    public String ttfFileName() {
        return "iconfont.ttf";
    }

    @Override
    public Icon[] characters() {
        return EcIcon.values();
    }
}
