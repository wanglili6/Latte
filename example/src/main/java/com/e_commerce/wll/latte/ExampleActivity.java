package com.e_commerce.wll.latte;


import com.Latter.latter_core.activitys.ProxyActivity;
import com.Latter.latter_core.delegates.LatterDelegate;


public class ExampleActivity extends ProxyActivity {

    @Override
    public LatterDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}
