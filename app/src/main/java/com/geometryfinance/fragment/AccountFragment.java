package com.geometryfinance.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.geometryfinance.R;
import com.geometryfinance.base.BaseFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.account_fragment)
public class AccountFragment extends BaseFragment{

    @ViewInject(R.id.text)
    private TextView textView;
    @Override
    public void initData(View view, Bundle savedInstanceState) {
        textView.setText("我是账户的测试界面");
    }
}
