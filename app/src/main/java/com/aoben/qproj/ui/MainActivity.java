package com.aoben.qproj.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import com.aoben.qproj.R;
import com.aoben.qproj.glide.NetworkImageHolderView;
import com.aoben.qproj.model.BannerBean;
import com.aoben.qproj.ui.adapter.BaseFragmentPageAdapter;
import com.aoben.qproj.util.LogUtils;
import com.aoben.qproj.util.Util;
import com.aoben.qproj.widget.CirclePercentBar;
import com.aoben.qproj.widget.WrapContentHeightViewPager;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends DrawerBaseActivity {

    private NestedScrollView scrollview;
    private ConvenientBanner cBanner;
    private TabLayout tab;

    private WrapContentHeightViewPager vp;
    private BaseFragmentPageAdapter adapter;
    private List<Fragment> fragments;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        scrollview = (NestedScrollView) findViewById(R.id.acty_main_scrollview);
        cBanner = (ConvenientBanner) findViewById(R.id.acty_main_cbanner);
        tab = (TabLayout) findViewById(R.id.acty_main_tab);
        tab.addTab(tab.newTab().setText("银行产品"));
        tab.addTab(tab.newTab().setText("赎楼产品"));
        vp = (WrapContentHeightViewPager) findViewById(R.id.acty_main_vp);

    }

    @Override
    public void initData() {
        initCBanner();
        initFragments();

    }

    private void initCBanner() {

        List<BannerBean> banners = new ArrayList<>();
        banners.add(new BannerBean());
        banners.add(new BannerBean());
        banners.add(new BannerBean());
        banners.add(new BannerBean());
        cBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        }, banners)
                .setPointViewVisible(true)//设置指示器是否可见
                .setPageIndicator(new int[]{R.drawable.ic_indicator_circle_n, R.drawable.ic_indicator_circle_s})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        //跳转到帖子详情页
//判断是否有tid和fid
//                        if (!Util.isNullOrBlank(mData.get(position).getTid())) {
//                            doJoinTopicActivity(position, holder);
//                        } else {
//                            //如果没有tid ,调用默认的浏览器打开该链接
//                            Intent intent = new Intent();
//                            intent.setAction("android.intent.action.VIEW");
//                            Uri content_url = Uri.parse(mData.get(position).getUrl());
//                            intent.setData(content_url);
//                            holder.getItemView().getContext().startActivity(intent);
//                        }

                    }
                });//设置指示器的方向（左、中、右）
        if (!cBanner.isTurning()) {
            cBanner.startTurning(2000);
        }

    }

    private void initFragments() {


        fragments = new ArrayList<>();
        fragments.add(new BankPFragment());
        fragments.add(new ReedomPFragment());

        adapter = new BaseFragmentPageAdapter(getSupportFragmentManager(), fragments);
        vp.setAdapter(adapter);

    }

    @Override
    protected void initListener() {

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {


                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


                TabLayout.Tab tabLayout = tab.getTabAt(position % fragments.size());
                if (!Util.isNull(tabLayout)) {
                    tabLayout.select();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    @Override
    public void onDrawerClosed(View drawerView) {
        super.onDrawerClosed(drawerView);

    }

    @Override
    public void onDrawerOpened(View drawerView) {
        super.onDrawerOpened(drawerView);

    }

    public static void actionStartClearStack(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }


}
