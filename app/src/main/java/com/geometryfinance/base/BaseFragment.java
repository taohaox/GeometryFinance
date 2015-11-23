package com.geometryfinance.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xutils.x;

/**
 * Created by Gyb on 2015/11/23.
 */
public abstract class BaseFragment extends Fragment {
    private boolean injected = false;
    /**
     * 初始数据
     * @param view
     * @param savedInstanceState
     */
    public abstract void initData(View view, Bundle savedInstanceState);
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //可以在类的头部直接注入视图
        injected = true;
        return x.view().inject(this, inflater, container);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //使用xutils的视图注入
        if(!injected){
            x.view().inject(this, this.getView());
        }
        //填充数据
        initData(view, savedInstanceState);
    }
}
