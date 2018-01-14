package app;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by wll on 2018/1/14.
 * 统一管理的类
 */

public final class Latter {
    /**
     * 初始化
     *
     * @param context
     * @return
     */
    public static Configurator init(Context context) {
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    private static HashMap<String, Object> getConfigurations() {
        return Configurator.getInstance().getConfigsMap();
    }
}
