package com.Latter.latter_core.activitys;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;

import com.Latter.latter_core.R;
import com.Latter.latter_core.delegates.LatterDelegate;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * 主activity
 */
public abstract class ProxyActivity extends SupportActivity {
    /**
     * 返回跟delegate
     * @return
     */
    public abstract LatterDelegate setRootDelegate();

    /**
     * 创建的时候调用
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContatiner(savedInstanceState);
    }

    /**
     * 加载布局
     * @param savedInstanceState
     */
    private void initContatiner(@Nullable Bundle savedInstanceState){
        ContentFrameLayout container = new ContentFrameLayout(this);
        //设置ID
        container.setId(R.id.delegate_container);
        setContentView(container);
        //判断第几次加载
        if (savedInstanceState==null){
            loadRootFragment(R.id.delegate_container,setRootDelegate());
        }
    }

    /**
     * 回收资源
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
        System.runFinalization();
    }
}
