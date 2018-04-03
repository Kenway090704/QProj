package com.aoben.qproj.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.aoben.qproj.R;
import com.aoben.qproj.model.ProductData;
import com.aoben.qproj.model.SalerBean;
import com.aoben.qproj.net.BaseObServer;
import com.aoben.qproj.net.QpRetrofitManager;
import com.aoben.qproj.ui.adapter.BankPAdapter;
import com.aoben.qproj.ui.adapter.CustomLinerLayoutManager;
import com.aoben.qproj.util.LogUtils;
import com.aoben.qproj.util.Util;
import com.aoben.qproj.widget.ProductRecomentUI;
import com.aoben.qproj.widget.SalerRecomendUI;

import java.util.List;

/**
 * Created by kenway on 18/2/28 11:04
 * Email : xiaokai090704@126.com
 * 银行产品
 */

public class BankPFragment extends BaseFragment {


    private ProductRecomentUI bankp_prui;
    private SalerRecomendUI bankp_srui;


    @Override
    protected int getLayoutId() {
        return R.layout.frag_bankp;
    }

    @Override
    protected void initViews(View root) {
//        rv = (RecyclerView) root.findViewById(R.id.frag_bankp_rv);
        bankp_prui = (ProductRecomentUI) root.findViewById(R.id.acty_bankp_prui);
        bankp_srui = (SalerRecomendUI) root.findViewById(R.id.acty_bankp_srui);
    }

    @Override
    protected void initEnvent() {

    }

    @Override
    protected void initData() {

//
//        adapter = new BankPAdapter(getContext());
//
//        CustomLinerLayoutManager linerLayoutManager=new CustomLinerLayoutManager(getContext());
//        linerLayoutManager.setScrollEnabled(false);
//        rv.setLayoutManager(linerLayoutManager);
////        rv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
//        rv.setNestedScrollingEnabled(false);
//        rv.setAdapter(adapter);

        QpRetrofitManager.getInstance().getProductAll().subscribe(new BaseObServer<ProductData>() {
            @Override
            public void onHandleSuccess(ProductData productData) {
                //获取银行产品


                if (Util.isNull(productData)||Util.isNull(productData.getBankProduct())||productData.getBankProduct().size()==0){

                }else {
                    List<ProductData.BankProductBean> list = productData.getBankProduct();
                    list.add(productData.getBankProduct().get(0));
                    list.add(productData.getBankProduct().get(0));
                    bankp_prui.setData(list);

                    addSalers();
                }

            }
        });
    }


    /**
     * 添加明星业务员
     */
    private void addSalers() {

        QpRetrofitManager.getInstance().getSalers().subscribe(new BaseObServer<List<SalerBean>>() {

            @Override
            public void onHandleSuccess(List<SalerBean> salerBeens) {

                if (Util.isNull(salerBeens)||salerBeens.size()==0){

                }else {
                    salerBeens.add(salerBeens.get(0));
                    salerBeens.add(salerBeens.get(0));
                    bankp_srui.setData(salerBeens);
                }
            }

        });
    }
}
