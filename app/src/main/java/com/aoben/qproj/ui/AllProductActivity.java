package com.aoben.qproj.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.aoben.qproj.R;
import com.aoben.qproj.model.ProductBean;
import com.aoben.qproj.model.ProductConfig;
import com.aoben.qproj.model.ProductData;
import com.aoben.qproj.model.SalerBean;
import com.aoben.qproj.net.BaseObServer;
import com.aoben.qproj.net.QpRetrofitManager;
import com.aoben.qproj.ui.adapter.AllProductAdapter;
import com.aoben.qproj.ui.helper.LoadMore;
import com.aoben.qproj.util.DataUtil;
import com.aoben.qproj.util.DisplayUtils;
import com.aoben.qproj.util.LogUtils;
import com.aoben.qproj.util.SwToast;
import com.aoben.qproj.util.Util;
import com.aoben.qproj.widget.NoMoreUI;
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

public class AllProductActivity extends DrawerBaseActivity implements LoadMore.OnLoadMoreListener {

    private static final String PRODUCTSTYLE = "productsytle";

    private int product_style;
    private HeaderAndFooterRecyclerView rv;

    private List<ProductBean> list;

    private List<ProductBean> listTotal;


    private AllProductAdapter adapter;


    private static int PAGECOUNT = 5;//每次加载的数据

    private View load_more;

    private boolean loadMore = true;

    private boolean loadMoreFinish = true;

    @Override
    protected int getLayoutId() {
        product_style = getIntent().getIntExtra(PRODUCTSTYLE, -1);
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

                if (Util.isNull(productData) || Util.isNull(productData.getBankProduct()) || productData.getBankProduct().size() == 0) {
                    SwToast.show(AllProductActivity.this, "无法获取数据");
                } else {

                    listTotal = new ArrayList<>();
                    if (product_style== ProductConfig.BANKPRODUCT){
                        listTotal.addAll(productData.getBankProduct());
                    }else {
                        listTotal.addAll(productData.getRedemption());
                    }

                    list.addAll(DataUtil.getShowData(listTotal, PAGECOUNT));
                    adapter = new AllProductAdapter(AllProductActivity.this, list);
                    rv.setAdapter(adapter);

                    rv.addOnScrollListener(new LoadMore.ForRecyclerView(AllProductActivity.this));


                    //如果列表内容小于屏幕那么将rv,设置为屏幕大小
                    rv.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if ((rv.getHeight() + getToolBar().getHeight()) < DisplayUtils.getScreenHeightPixels(AllProductActivity.this)) {
                                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) rv.getLayoutParams();
                                params.height = DisplayUtils.getScreenHeightPixels(AllProductActivity.this);
                                rv.setLayoutParams(params);
                            }
                        }
                    }, 500);
                }
            }
        });


    }

    @Override
    protected void initListener() {
        //让RecyclerView  有弹性效果
//        OverScrollDecoratorHelper.setUpOverScroll(rv, OverScrollDecoratorHelper.ORIENTATION_VERTICAL);
    }


    public static void actionStart(Context context, int productStyle) {
        Intent intent = new Intent(context, AllProductActivity.class);
        intent.putExtra(PRODUCTSTYLE, productStyle);
        context.startActivity(intent);
    }

    @Override
    public void showLoadMore() {
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
        if (!isLoadMore()) {
            //不显示加载更多
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

            } else if (listTotal.size() < 10) {
                rv.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        hideLoadMore();
                        //上拉加载添加评论
                        adapter.addReplyListAndNotify(DataUtil.getShowData(listTotal, PAGECOUNT));
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
                        adapter.addReplyListAndNotify(DataUtil.getShowData(listTotal, PAGECOUNT));
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

    public boolean isLoadMore() {
        return loadMore;
    }
}
