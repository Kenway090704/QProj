package com.aoben.qproj.ui;

import android.view.View;

import com.aoben.qproj.R;
import com.aoben.qproj.model.ProductBean;
import com.aoben.qproj.model.ProductConfig;
import com.aoben.qproj.model.ProductData;
import com.aoben.qproj.model.SalerBean;
import com.aoben.qproj.net.BaseObServer;
import com.aoben.qproj.net.QpRetrofitManager;
import com.aoben.qproj.util.Util;
import com.aoben.qproj.widget.ProductRecomentUI;
import com.aoben.qproj.widget.SalerRecomendUI;

import java.util.List;

/**
 * Created by kenway on 18/2/28 11:05
 * Email : xiaokai090704@126.com
 * 赎楼产品
 */

public class ReedomPFragment extends BaseFragment {

    private ProductRecomentUI reedomp_prui;
    private SalerRecomendUI reedomp_srui;

    @Override
    protected int getLayoutId() {
        return R.layout.frag_reedomp;
    }

    @Override
    protected void initViews(View root) {
        reedomp_prui = (ProductRecomentUI) root.findViewById(R.id.frag_reedomp_prui);
        reedomp_srui = (SalerRecomendUI) root.findViewById(R.id.frag_reedomp_srui);
    }

    @Override
    protected void initEnvent() {

    }

    @Override
    protected void initData() {

        QpRetrofitManager.getInstance().getProductAll().subscribe(new BaseObServer<ProductData>() {
            @Override
            public void onHandleSuccess(ProductData productData) {


                //获取银行产品

                if (Util.isNull(productData) || Util.isNull(productData.getRedemption()) || productData.getRedemption().size() == 0) {

                } else {
                    List<ProductBean> list = productData.getRedemption();


                    if (list.size() > 3) {
                        list.add(productData.getRedemption().get(0));
                        list.add(productData.getRedemption().get(1));
                        list.add(productData.getRedemption().get(2));
                    } else {
                        list.addAll(productData.getRedemption());
                    }
                    reedomp_prui.setData(list, ProductConfig.REEDOMPRODUCT);
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


                if (Util.isNull(salerBeens) || salerBeens.size() == 0) {
                    return;
                }
                if (salerBeens.size() > 3) {
                    salerBeens.add(salerBeens.get(0));
                    salerBeens.add(salerBeens.get(1));
                    salerBeens.add(salerBeens.get(2));
                } else {
                    salerBeens.addAll(salerBeens);
                }

                reedomp_srui.setData(salerBeens);
            }

        });
    }
}
