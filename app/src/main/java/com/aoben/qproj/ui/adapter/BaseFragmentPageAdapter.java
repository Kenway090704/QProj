package com.aoben.qproj.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;


import com.aoben.qproj.util.LogUtils;


import java.util.List;

/**
 * Created by kenway on 18/2/28 11:06
 * Email : xiaokai090704@126.com
 */

public class BaseFragmentPageAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;


    public BaseFragmentPageAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);


        if (fragments==null){
            throw  new NullPointerException("fragments can not be null");
        }
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
