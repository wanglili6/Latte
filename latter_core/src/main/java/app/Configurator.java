package app;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by wll on 2018/1/14.
 * 配置文件的存储和获取
 * 配置文件
 * 单例模式
 */

public class Configurator {
    private static final HashMap<String, Object> LATTER_CONFIGSMAP = new HashMap<>();
    private static final ArrayList<IconFontDescriptor> ICONSLIST = new ArrayList<>();

    /**
     * 配置文件,添加配置标识-----构造方法
     */
    private Configurator() {
        //记录是否初始化,
        LATTER_CONFIGSMAP.put(ConfigType.CONFIGG_READY.name(), false);

    }

    /**
     * 创建单例---初始化
     *
     * @return
     */
    public static Configurator getInstance() {
        //创建单例模式
        initIcons();
        return Holder.INSTANCE;
    }

    /**
     * 获取的配置的文件的map
     */
    public static final HashMap<String, Object> getConfigsMap() {
        return LATTER_CONFIGSMAP;

    }

    /**
     * 静态内部类的单利模式
     */
    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    /**
     * 使用单例模式---初始化配置文件完成
     */
    public final void configuer() {
        //初始化完成,配置完成
        LATTER_CONFIGSMAP.put(ConfigType.CONFIGG_READY.name(), true);
    }

    /**
     * 配置访问地址的域名---API_HOST
     */
    public Configurator withAPIHost(String apiHost) {
        LATTER_CONFIGSMAP.put(ConfigType.API_HOST.name(), apiHost);
        return this;
    }

    /**
     * 检查配置
     */
    private void checkConfigration() {
        final boolean isReady = (boolean) LATTER_CONFIGSMAP.get(ConfigType.CONFIGG_READY.name());
        if (!isReady) {
            throw new RuntimeException("Congfiguration is not ready,call configurate");
        }

    }

    /**
     * 没有被检测
     * 在获取配置文件的调用
     *
     * @param key 初始化的配置 key
     * @param <T>
     * @return
     */

    final <T> T getCongfiguration(Enum<ConfigType> key) {
        checkConfigration();
        return (T) LATTER_CONFIGSMAP.get(key.name());
    }

    /**
     * 初始化字体
     */
    private static void initIcons() {
        if (ICONSLIST.size() > 0) {
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONSLIST.get(0));
            for (int i = 1; i < ICONSLIST.size(); i++) {
                initializer.with(ICONSLIST.get(i));
            }
        }
    }

    /**
     * 添加自定义的字体
     */

    public Configurator withIcon(IconFontDescriptor icon) {
        ICONSLIST.add(icon);
        return this;
    }
}
