package com.aoben.qproj.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.aoben.qproj.R;
import com.aoben.qproj.ui.BankPFragment;
import com.aoben.qproj.ui.DrawerBaseActivity;
import com.aoben.qproj.ui.MainActivity;
import com.aoben.qproj.ui.ReedomPFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kenway on 18/3/12 10:22
 * Email : xiaokai090704@126.com
 */

public class HomeActivity extends DrawerBaseActivity {


    private List<Fragment> list;

    private Fragment current;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        list = new ArrayList<>();
        HomeFragment homeFragment = new HomeFragment();
        AllProductFragment allProductFragment = new AllProductFragment();
        list.add(homeFragment);
        list.add(allProductFragment);

    }

    @Override
    public void initData() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.acty_home_fraglayout, list.get(0));
        transaction.commit();
        current = list.get(0);
        if (current instanceof HomeFragment) {
            getToolBar().getBackIv().setVisibility(View.GONE);
        }
    }

    @Override
    protected void initListener() {

    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
    }
}
