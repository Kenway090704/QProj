package com.aoben.qproj.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.aoben.qproj.R;
import com.aoben.qproj.model.SalerBean;
import com.aoben.qproj.net.BaseObServer;
import com.aoben.qproj.net.QpRetrofitManager;
import com.aoben.qproj.ui.adapter.SalesmanAdapter;
import com.aoben.qproj.ui.adapter.SalesmanDecoration;
import com.aoben.qproj.ui.helper.LoadMore;
import com.aoben.qproj.ui.hongyang.CommonAdapter;
import com.aoben.qproj.ui.hongyang.ViewHolder;
import com.aoben.qproj.util.DataUtil;
import com.aoben.qproj.util.DisplayUtils;
import com.aoben.qproj.util.LogUtils;
import com.aoben.qproj.util.SwToast;
import com.aoben.qproj.util.Util;
import com.aoben.qproj.widget.NoMoreUI;
import com.aoben.qproj.widget.SalerItemUI;
import com.takwolf.android.hfrecyclerview.HeaderAndFooterRecyclerView;


import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

/**
 * Created by kenway on 18/2/6 14:58
 * Email : xiaokai090704@126.com
 * <p>
 * 业务员页面
 */

public class SalesmanActivity extends DrawerBaseActivity implements LoadMore.OnLoadMoreListener {

    private HeaderAndFooterRecyclerView rv;

    private List<SalerBean> list;

    private List<SalerBean> listTotal;
    private CommonAdapter<SalerBean> adapter;

    private static  int PAGECOUNT=5;//每次加载的数据


    private View load_more;
    private boolean loadMore = true;
    private boolean loadMoreFinish = true;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_salesman;
    }

    @Override
    protected void initView() {


        rv = (HeaderAndFooterRecyclerView) findViewById(R.id.acty_salesman_rv);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        load_more = LayoutInflater.from(this).inflate(R.layout.load_more, null);
        //给控件设置弹性效果
        OverScrollDecoratorHelper.setUpOverScroll(rv, OverScrollDecoratorHelper.ORIENTATION_VERTICAL);

    }

    @Override
    public void initData() {
        list = new ArrayList<>();
        QpRetrofitManager.getInstance().getSalers().subscribe(new BaseObServer<List<SalerBean>>() {
            @Override
            public void onHandleSuccess(List<SalerBean> salerBeens) {
                if (Util.isNull(salerBeens) || salerBeens.size() == 0) {

                    SwToast.show(SalesmanActivity.this, "无法获取数据");
                } else {

                    listTotal = new ArrayList<>();
                    listTotal.addAll(salerBeens);
                    list.addAll(DataUtil.getShowData(listTotal, PAGECOUNT));

                    adapter = new CommonAdapter<SalerBean>(SalesmanActivity.this, R.layout.adapter_saler, list) {
                        @Override
                        public void convert(ViewHolder holder, SalerBean s) {
                            SalerItemUI siu = holder.getView(R.id.adapter_saler_siu);
                            siu.setData(s);
                        }
                    };
                    rv.setAdapter(adapter);

//                    //如果列表内容小于屏幕那么将rv,设置为屏幕大小
                    rv.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if ((rv.getHeight() + getToolBar().getHeight()) < DisplayUtils.getScreenHeightPixels(SalesmanActivity.this)) {
                                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) rv.getLayoutParams();
                                params.height = DisplayUtils.getScreenHeightPixels(SalesmanActivity.this);
                                rv.setLayoutParams(params);


                            }
                        }
                    }, 500);

                }

            }
        });
    }

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, SalesmanActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initListener() {

        rv.addOnScrollListener(new LoadMore.ForRecyclerView(this));
    }


    @Override
    public void showLoadMore() {

        LogUtils.e("显示加载更多");
        ViewGroup parent = (ViewGroup) load_more.getParent();
        if (parent != null) {
            parent.removeView(load_more);
        }
        rv.addFooterView(load_more);
        ViewGroup.LayoutParams params = load_more.getLayoutParams();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        load_more.setLayoutParams(params);
    }

    @Override
    public void onLoadMore() {


        if (!loadMoreFinish) return;

        if (!loadMore) {
            // 不显示加载更多
            hideLoadMore();
        } else {

            //判读是否剩下的为0
            if (Util.isNull(listTotal) || listTotal.size() == 0) {

                rv.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        hideLoadMore();
                        //没有更多了布局
                        setNoMoreView();
                        loadMore = false;
                        loadMoreFinish = true;
                    }
                }, 2000);

            } else if (listTotal.size() < PAGECOUNT) {
                rv.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        hideLoadMore();
                        //上拉加载添加评论
                        adapter.addDatas(DataUtil.getShowData(listTotal,PAGECOUNT));
                        //没有更多了布局
                        setNoMoreView();
                        loadMore = false;
                        loadMoreFinish = true;
                    }
                }, 2000);
            } else {
                rv.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        hideLoadMore();
                        //上拉加载添加评论
                        adapter.addDatas(DataUtil.getShowData(listTotal,PAGECOUNT));
                        loadMoreFinish = true;
                    }
                }, 2000);
            }


        }

    }

    private void setNoMoreView() {

        rv.removeFooterView(load_more);
        rv.addFooterView(new NoMoreUI(this));
    }

    @Override
    public void hideLoadMore() {
        rv.removeFooterView(load_more);
    }
}
