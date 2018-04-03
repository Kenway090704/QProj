package com.aoben.qproj.glide;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.aoben.qproj.model.BannerData;
import com.bigkoo.convenientbanner.holder.Holder;

public  class NetworkImageHolderView implements Holder<BannerData.StartBean> {
        private ImageView imageView;

        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, BannerData.StartBean data) {
//            ImageLoader.load(context, R.drawable.banner, imageView);
            ImageLoader.load(context, data.getImgsrc(), imageView);
        }
    }