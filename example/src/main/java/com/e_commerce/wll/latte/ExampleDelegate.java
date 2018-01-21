package com.e_commerce.wll.latte;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.Latter.latter_core.delegates.LatterDelegate;

/**
 * Created by wll on 2018/1/21.
 */

public class ExampleDelegate extends LatterDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    /**
     * 绑定View
     *
     * @param savedInstanceState
     * @param rootView
     */
    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
