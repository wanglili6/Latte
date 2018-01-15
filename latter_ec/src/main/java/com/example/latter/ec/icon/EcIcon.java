package com.example.latter.ec.icon;

import com.joanzapata.iconify.Icon;

/**
 * Created by wll on 2018/1/15.
 * 枚举类
 * 添加自定义的字体
 */

public enum EcIcon implements Icon {

    icon_shoucan('\ue627'),
    icon_zuowei('\ue63a');
    private char character;

    EcIcon(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return  name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
