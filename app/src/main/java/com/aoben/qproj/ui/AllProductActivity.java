package com.aoben.qproj.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aoben.qproj.R;
import com.aoben.qproj.model.ProductData;
import com.aoben.qproj.net.BaseObServer;
import com.aoben.qproj.net.QpRetrofitManager;
import com.aoben.qproj.ui.adapter.AllProductAdapter;
import com.aoben.qproj.ui.helper.LoadMore;
import com.aoben.qproj.util.LogUtils;
import com.aoben.qproj.util.Util;
import com.takwolf.android.hfrecyclerview.HeaderAndFooterRecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;
import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;

/**
 * Created by kenway on 18/3/6 10:44
 * Email : xiaokai090704@126.com
 * <p>
 * 全部产品页
 */

public class AllProductActivity extends DrawerBaseActivity  implements LoadMore.OnLoadMoreListener {

    private HeaderAndFooterRecyclerView rv;

    private List<ProductData.BankProductBean> list;


    private AllProductAdapter adapter;

    private View load_more;

    private boolean loadMore=false;

    private boolean loadMoreFinish=true;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_allproduct;
    }

    @Override
    protected void initView() {

        rv = (HeaderAndFooterRecyclerView) findViewById(R.id.acty_allproduct_rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        load_more = LayoutInflater.from(this).inflate(R.layout.load_more, null);

        //给控件设置弹性效果
        OverScrollDecoratorHelper.setUpOverScroll(rv, OverScrollDecoratorHelper.ORIENTATION_VERTICAL);

    }

    @Override
    public void initData() {


        list = new ArrayList<>();
        QpRetrofitManager.getInstance().getProductAll().subscribe(new BaseObServer<ProductData>() {
            @Override
            public void onHandleSuccess(ProductData productData) {


                if (Util.isNull(productData)||Util.isNull(productData.getBankProduct())||productData.getBankProduct().size()==0){

                }else {
                    list.addAll(productData.getBankProduct());
                    list.addAll(productData.getBankProduct());
                    list.addAll(productData.getBankProduct());
                    list.addAll(productData.getBankProduct());
                    list.addAll(productData.getBankProduct());
                    list.addAll(productData.getBankProduct());
                    list.addAll(productData.getBankProduct());
                    list.addAll(productData.getBankProduct());
                    list.addAll(productData.getBankProduct());
                    list.addAll(productData.getBankProduct());
                    list.addAll(productData.getBankProduct());
                    list.addAll(productData.getBankProduct());
                    list.addAll(productData.getBankProduct());
                    list.addAll(productData.getBankProduct());
                    list.addAll(productData.getBankProduct());

                    adapter = new AllProductAdapter(AllProductActivity.this, list);
                    rv.setAdapter(adapter);

                    rv.addOnScrollListener(new LoadMore.ForRecyclerView(AllProductActivity.this));
                }
            }
        });


    }

    @Override
    protected void initListener() {
        //让RecyclerView  有弹性效果

//        OverScrollDecoratorHelper.setUpOverScroll(rv, OverScrollDecoratorHelper.ORIENTATION_VERTICAL);

    }


    public static void actionStart(Context context) {
        Intent intent = new Intent(context, AllProductActivity.class);

        context.startActivity(intent);
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

        LogUtils.e("加载更多");
        if (!loadMoreFinish) return;
        if (isLoadMore()){
            //不显示加载更多
            hideLoadMore();
        }else {

            //判读是否剩下的为0
            if (Util.isNull(list) || list.size() == 0) {

                rv.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        hideLoadMore();
                        //没有更多了布局
//                        setNoMoreView();
                        loadMore = false;
                        loadMoreFinish = true;
                    }
                }, 2000);

            } else if (list.size() < 10) {
                rv.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        hideLoadMore();
                        //上拉加载添加评论
                        adapter.addReplyListAndNotify(list);
                        //没有更多了布局
//                        setNoMoreView();
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
                        adapter.addReplyListAndNotify(list);
                        loadMoreFinish = true;
                    }
                }, 2000);
            }

        }

    }

    @Override
    public void hideLoadMore() {
        rv.removeFooterView(load_more);
    }

    public boolean isLoadMore() {
        return loadMore;
    }
}
