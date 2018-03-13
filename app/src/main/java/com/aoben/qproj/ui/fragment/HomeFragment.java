package com.aoben.qproj.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.view.View;

import com.aoben.qproj.R;
import com.aoben.qproj.glide.NetworkImageHolderView;
import com.aoben.qproj.model.BannerBean;
import com.aoben.qproj.ui.BankPFragment;
import com.aoben.qproj.ui.BaseFragment;
import com.aoben.qproj.ui.ReedomPFragment;
import com.aoben.qproj.ui.adapter.BaseFragmentPageAdapter;
import com.aoben.qproj.util.ResourceUtil;
import com.aoben.qproj.util.Util;
import com.aoben.qproj.widget.WrapContentHeightViewPager;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kenway on 18/3/12 10:40
 * Email : xiaokai090704@126.com
 */

public class HomeFragment extends BaseFragment {
    private NestedScrollView scrollView;
    private ConvenientBanner cBanner;
    private TabLayout tab;
    private WrapContentHeightViewPager vp;
    private BaseFragmentPageAdapter adapter;
    private List<Fragment> fragments;

    @Override
    protected int getLayoutId() {
        return R.layout.frag_home;
    }

    @Override
    protected void initViews(View root) {
        scrollView = (NestedScrollView) root.findViewById(R.id.frag_home_scrollview);
        cBanner = (ConvenientBanner) root.findViewById(R.id.frag_home_cbanner);
        tab = (TabLayout) root.findViewById(R.id.frag_home_tab);
        tab.addTab(tab.newTab().setText(ResourceUtil.resToStr(R.string.bank_product)));
        tab.addTab(tab.newTab().setText(ResourceUtil.resToStr(R.string.reedom_product)));
        vp = (WrapContentHeightViewPager) root.findViewById(R.id.frag_home_vp);
    }

    @Override
    protected void initEnvent() {

    }

    @Override
    protected void initData() {

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
        }, banners).setPointViewVisible(true)
                .setPageIndicator(new int[]{R.drawable.ic_indicator_circle_n, R.drawable.ic_indicator_circle_s})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {

                    }
                });

        if (!cBanner.isTurning()) {
            cBanner.startTurning(2000);
        }

    }

    private void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(new BankPFragment());
        fragments.add(new ReedomPFragment());

        adapter = new BaseFragmentPageAdapter(getChildFragmentManager(), fragments);
        vp.setAdapter(adapter);

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
}
