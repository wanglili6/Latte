package com.Latter.latter_core.delegates;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * Created by wll on 2018/1/21.
 * base容器
 */

public abstract class BaseDelegate extends SwipeBackFragment {
    /**
     * 同意使用butterfly--黄油刀
     */
    public Unbinder mUnbind = null;

    /**
     * 设置布局文件
     */
    public abstract Object setLayout();
    /**
     * 绑定view
     */
    public abstract void onBindView(@Nullable Bundle savedInstanceState,View rootView);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = null;
        if (setLayout() instanceof  Integer){
            rootView = inflater.inflate((Integer) setLayout(),container,false);
        }else {
            rootView = (View) setLayout();
        }
        if (rootView!=null){
            mUnbind = ButterKnife.bind(this,rootView);
            onBindView(savedInstanceState,rootView);
        }

        return rootView;
    }

    /**
     * 解除绑定
     */

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbind!=null){
            mUnbind.unbind();
        }
    }
}
