package com.aoben.qproj.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.view.View;

import com.aoben.qproj.R;
import com.aoben.qproj.glide.ImageLoader;
import com.aoben.qproj.glide.NetworkImageHolderView;
import com.aoben.qproj.model.BannerData;
import com.aoben.qproj.model.BaseData;
import com.aoben.qproj.model.SearchData;
import com.aoben.qproj.net.BaseObServer;
import com.aoben.qproj.net.QpPostMap;
import com.aoben.qproj.net.QpRetrofitManager;
import com.aoben.qproj.ui.adapter.BaseFragmentPageAdapter;
import com.aoben.qproj.util.DataUtil;
import com.aoben.qproj.util.LogUtils;
import com.aoben.qproj.util.Util;
import com.aoben.qproj.widget.CustomTablayout;
import com.aoben.qproj.widget.IndictorView;
import com.aoben.qproj.widget.WrapContentHeightViewPager;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends DrawerBaseActivity {

    private NestedScrollView scrollview;
    private ConvenientBanner cBanner;
    private IndictorView indictorView;
    private CustomTablayout tab;

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
        indictorView = (IndictorView) findViewById(R.id.acty_main_indicator);
        tab = (CustomTablayout) findViewById(R.id.acty_main_tab);


        vp = (WrapContentHeightViewPager) findViewById(R.id.acty_main_vp);
        getToolBar().getBackIv().setVisibility(View.GONE);//首页去掉标题中的返回按钮

//        LogUtils.e("屏幕的分辨率:h-->"+ DisplayUtils.getScreenHeightPixels(this)+",w-->"+DisplayUtils.getScreenWidthPixels(this));
        LogUtils.e("字体大小:9-->" + (int) this.getResources().getDimension(R.dimen.comm_tv_9));

    }

    @Override
    public void initData() {
        initCBanner();
        initFragments();

        testNet();





    }

    private void testNet() {


        QpPostMap qpPostMap = new QpPostMap.Builder()
                .build();
        //
        //        QpRetrofitManager.getInstance().getBanners(qpPostMap.getMap(), new NetCallBack<BaseData<List<BannerBean>>>() {
        //            @Override
        //            public void onResponse(Call<BaseData<List<BannerBean>>> call, Response<BaseData<List<BannerBean>>> response) {
        //                LogUtils.e("onResponse==" + response.body().toString());
        //            }
        //        });
        //
        //        QpRetrofitManager.getInstance().getBanners(qpPostMap.getMap(), new Callback<BaseData<List<BannerBean>>>() {
        //            @Override
        //            public void onResponse(Call<BaseData<List<BannerBean>>> call, Response<BaseData<List<BannerBean>>> response) {
        //                LogUtils.e("onResponse==" + response.body().toString());
        //
        //            }
        //
        //            @Override
        //            public void onFailure(Call<BaseData<List<BannerBean>>> call, Throwable t) {
        //
        //            }
        //        });
        //
        //        QpRetrofitManager.getInstance().getBannersRx(qpPostMap.getMap()).subscribe(new BaseObServer<List<BannerBean>>() {
        //            @Override
        //            public void onHandleSuccess(List<BannerBean> o) {
        //                LogUtils.e("onHandleSuccess==" + o.toString());
        //            }
        //        });

    }

    private void initCBanner() {

        QpRetrofitManager.getInstance().getBannersRx().subscribe(new BaseObServer<BannerData>() {

            @Override
            public void onHandleSuccess(BannerData bannerData) {

                if (Util.isNull(bannerData) || Util.isNull(bannerData.getIndex()) || bannerData.getIndex().size() == 0) {

                    //判断返回的数据是否为空

                } else {

                    LogUtils.e("banner==" + bannerData.toString());

                    List<BannerData.StartBean> banners = bannerData.getIndex();
                    addBannerData(banners);
                }
            }
        });




    }

    private void addBannerData(final List<BannerData.StartBean> banners) {

        indictorView.setIndicatorsSize(banners.size());

        boolean isOnlyOne = banners.size() < 2;

        if (isOnlyOne) {
            indictorView.setVisibility(View.GONE);
        }
        cBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        }, banners)
                .setPointViewVisible(false)//设置指示器是否可见
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
                }).setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                //在这里面设置选中的Indicator

                indictorView.setSelectIndex(position % banners.size());

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });//设置指示器的方向（左、中、右）
        if (!cBanner.isTurning()) {

            if (isOnlyOne) {
                cBanner.stopTurning();
            } else {
                cBanner.startTurning(2000);
            }

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

        tab.setOnTabSelectedListener(new CustomTablayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int selectIndex) {
                vp.setCurrentItem(selectIndex);
            }
        });

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                tab.setSelect(position % fragments.size());

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
