package com.geometryfinance.base;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.geometryfinance.R;
import com.geometryfinance.util.LogUtils;
import org.xutils.x;
/**
 * Created by Administrator on 2015/11/23.
 */
public abstract  class BaseActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    public abstract void initData(Bundle savedInstanceState);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setToolbar();
        initData(savedInstanceState);
    }

    private void setToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar==null){
            LogUtils.e("请在布局中使用Toolbar,并将Toolbar的id设置为toolbar");
        }else{
            setSupportActionBar(toolbar);
        }


    }

    /**
     * 开启侧滑动画  不设置则不打开
     */
    public void openSlideAnimation() {
        //动态侧滑菜单
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        if(mDrawerLayout==null||toolbar==null){
            LogUtils.d("你没有使用DrawerLayout 或 Toolbar 不能开启侧滑动画");
            return;
        }
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,toolbar,R.string.draw_open,R.string.draw_close){
            public void onDrawerClosed(View view){
                invalidateOptionsMenu(); // creates call to                                                    // onPrepareOptionsMenu()            }
                /** Called when a drawer has settled in a completely open state. */
            }
            public void onDrawerOpened(View drawerView){
                invalidateOptionsMenu(); // creates call to                                                    // onPrepareOptionsMenu()            }
            }
        };
        mDrawerToggle.syncState(); //初始化状态
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    public void setTitle(String title){
        getSupportActionBar().setTitle(title);
    }
    @Override
    public void invalidateOptionsMenu() {
        super.invalidateOptionsMenu();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.action_settings:
                Toast.makeText(this, "you clicked settings button", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
