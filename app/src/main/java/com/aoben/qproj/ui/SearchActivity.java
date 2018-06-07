package com.aoben.qproj.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.aoben.qproj.R;
import com.aoben.qproj.model.ProductData;
import com.aoben.qproj.model.SearchData;
import com.aoben.qproj.net.QpPostMap;
import com.aoben.qproj.net.QpRetrofitManager;
import com.aoben.qproj.util.DataUtil;
import com.aoben.qproj.util.KeyBoardUtils;
import com.aoben.qproj.util.LogUtils;
import com.aoben.qproj.util.Util;
import com.aoben.qproj.widget.QprojSearchToolBar;
import com.aoben.qproj.widget.SalerItemUI;
import com.aoben.qproj.widget.SearchHintUI;
import com.aoben.qproj.widget.SearchItemUI;

import me.everything.android.ui.overscroll.OverScrollDecoratorHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kenway on 18/4/20 14:38
 * Email : xiaokai090704@126.com
 * 搜索信息展示页面
 */

public class SearchActivity extends BaseActivity {
    private static final String DATA = "data";
    private static final String KEYWORD = "keyword";
    private QprojSearchToolBar bar;
    private ScrollView layout_sv;
    private LinearLayout layout_content;
    private SearchData data;
    private String keyword;
    private SearchHintUI searchHintUI;

    @Override
    protected int getLayoutId() {
        data = (SearchData) getIntent().getSerializableExtra(DATA);
        keyword = getIntent().getStringExtra(KEYWORD);
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {
        bar = (QprojSearchToolBar) findViewById(R.id.acty_search_toolbar);
        searchHintUI = (SearchHintUI) findViewById(R.id.acty_search_layout_shui);

        layout_sv = (ScrollView) findViewById(R.id.acty_search_layout_sv);
        layout_content = (LinearLayout) findViewById(R.id.acty_search_layout_content);

        bar.getEditText().setText(keyword);

    }

    @Override
    public void initData() {
        LogUtils.e("data===" + data.toString());
        boolean isNoData = true;
        if (Util.isNull(data.getBankProduct()) || data.getBankProduct().size() == 0) {

        } else {

            for (int i = 0; i < data.getBankProduct().size(); i++) {

                SearchItemUI searchItemUI = new SearchItemUI(this);
                searchItemUI.setData(data.getBankProduct().get(i));
                layout_content.addView(searchItemUI);
            }


            isNoData = false;
        }
        if (Util.isNull(data.getRedemption()) || data.getRedemption().size() == 0) {

        } else {

            for (int i = 0; i < data.getRedemption().size(); i++) {

                SearchItemUI searchItemUI = new SearchItemUI(this);
                searchItemUI.setData(data.getRedemption().get(i));
                layout_content.addView(searchItemUI);
            }

            isNoData = false;
        }
        if (Util.isNull(data.getSalesman()) || data.getSalesman().size() == 0) {

        } else {


            LogUtils.e("搜索业务返回的数据=="+data.getSalesman().get(0).toString());
            for (int i = 0; i < data.getSalesman().size(); i++) {

                SalerItemUI salerItemUI = new SalerItemUI(this);
                salerItemUI.setData(data.getSalesman().get(i));
                layout_content.addView(salerItemUI);
            }

            isNoData = false;
        }

        if (isNoData) {
            searchHintUI.setVisibility(View.VISIBLE);
        } else {
            searchHintUI.setVisibility(View.GONE);
        }

    }

    @Override
    protected void initListener() {


        bar.getTextView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!keyword.equals(bar.getEditText().getText().toString())) {
                    layout_content.removeAllViews();
                    //进行搜索内容
                    searchHintUI.setVisibility(View.GONE);
                    KeyBoardUtils.closeKeybord(bar.getEditText(), bar.getContext());
                    search(bar.getEditText().getText().toString());
                }


            }
        });
    }

    public static void actionStart(Context context, SearchData data, String keyword) {
        Intent intent = new Intent(context, SearchActivity.class);
        intent.putExtra(DATA, data);
        intent.putExtra(KEYWORD, keyword);
        context.startActivity(intent);
    }

    private void search(final String searchkey) {
        //搜索需要一个Map.

        QpRetrofitManager.getInstance().getSearchData(searchkey, new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {


                data = DataUtil.getSearchData(response.body().toString());

                initData();

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

}
