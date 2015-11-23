package com.geometryfinance.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.geometryfinance.R;
import com.geometryfinance.adapter.MainViewPagerAdapter;
import com.geometryfinance.base.BaseActivity;
import com.geometryfinance.fragment.AccountFragment;
import com.geometryfinance.fragment.InvestFragment;
import com.geometryfinance.fragment.MainFragment;
import com.geometryfinance.fragment.MoreFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;
@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity{

    @ViewInject(R.id.vp_main_fragment)
    private ViewPager viewPager;
    private List<Fragment> fragments = new ArrayList<>();
    private MainFragment mMainFragment; //主页
    private InvestFragment mInvestFragment; //投资页
    private AccountFragment mAccountFragment; //账户页
    private MoreFragment mMoreFragment; //更多页
    @ViewInject(R.id.tv_main)
    private TextView tv_main;
    @ViewInject(R.id.tv_invest)
    private TextView tv_invest;
    @ViewInject(R.id.tv_account)
    private TextView tv_account;
    @ViewInject(R.id.tv_more)
    private TextView tv_more;

    @Override
    public void initData(Bundle savedInstanceState) {
        //开启侧滑动画
        openSlideAnimation();
        //设置标题
        setTitle("几何金融");
        mMainFragment = new MainFragment();
        mInvestFragment = new InvestFragment();
        mAccountFragment = new AccountFragment();
        mMoreFragment = new MoreFragment();
        fragments.add(mMainFragment);
        fragments.add(mInvestFragment);
        fragments.add(mAccountFragment);
        fragments.add(mMoreFragment);
        viewPager.setAdapter(new MainViewPagerAdapter(getSupportFragmentManager(), fragments));
        tv_main.setText("main");
    }

    /**
     * 显示菜单
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * 监听菜单点击
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home: //返回按钮
                onBackPressed();
                break;
            case R.id.action_settings:
                Toast.makeText(this, "you clicked settings button", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 注解点击事件
     * 1. 方法必须私有限定,方法必须私有限定,方法必须私有限定 重要的事说三遍
     * 2. 方法以Click或Event结尾, 方便配置混淆编译参数 :
     * -keepattributes *Annotation*
     * -keepclassmembers class * {
     * void *(android.view.View);
     * *** *Click(...);
     * *** *Event(...);
     * }
     * 3. 方法参数形式必须和type对应的Listener接口一致.
     * 4. 注解参数value支持数组: value={id1, id2, id3}
     **/
    @Event({R.id.tv_more,R.id.tv_invest,R.id.tv_main,R.id.tv_account})
    private void onFragmentImageClick(View v) {
        switch (v.getId()){
            case R.id.tv_main:
                viewPager.setCurrentItem(0);
                break;
            case R.id.tv_invest:
                viewPager.setCurrentItem(1);
                break;
            case R.id.tv_account:
                viewPager.setCurrentItem(2);
                break;
            case R.id.tv_more:
                viewPager.setCurrentItem(3);
                break;

        }
    }
}
