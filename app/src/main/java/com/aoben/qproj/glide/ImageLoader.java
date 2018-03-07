package com.aoben.qproj.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.aoben.qproj.R;
import com.aoben.qproj.glide.CircleTransform;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;


public class ImageLoader {
    public static void load(Context context, String url, ImageView iv) {
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)//让Glide既缓存全尺寸图片，下次在任何ImageView中加载图片的时候，全尺寸的图片将从缓存中取出，重新调整大小，然后缓存
                .crossFade()
                .into(iv);
    }

    /**
     * 加载表情图片
     *
     * @param context
     * @param url
     * @param iv
     */
    public static void loadGif(Context context, String url, ImageView iv) {
        //判断是否在本地,如果在,则加载本地图片
//        if (new File(url).exists()) {
//            Glide.with(context).load(url).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).crossFade().into(iv);
//        } else {
            Glide.with(context).load(url).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).crossFade().into(iv);
//        }


    }

    public static void loadCircle(Context context, String url, ImageView iv) {
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)//让Glide既缓存全尺寸图片，下次在任何ImageView中加载图片的时候，全尺寸的图片将从缓存中取出，重新调整大小，然后缓存
                .crossFade()
                .placeholder(R.drawable.nav_logo)
                .bitmapTransform(new CircleTransform(context))
                .into(iv);
    }

    public static void load(Context context, String url, ImageView iv, int placeholder) {
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)//让Glide既缓存全尺寸图片，下次在任何ImageView中加载图片的时候，全尺寸的图片将从缓存中取出，重新调整大小，然后缓存
                .crossFade()
                .placeholder(placeholder)
                .into(iv);
    }

    public static void load(Context context, int resId, ImageView iv) {
        Glide.with(context)
                .load(resId)
                .crossFade()
                .into(iv);
    }

    /**
     * 得到Bitmap
     * 需要在子线程执行
     *
     * @param context
     * @param url
     * @return
     */
    public static Bitmap getBitmap(Context context, String url) {
        try {
            return Glide.with(context)
                    .load(url)
                    .asBitmap()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                    .get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void loadCircle(Context context, int resId, ImageView iv) {
        Glide.with(context)
                .load(resId)
                .crossFade()
                .transform(new CircleTransform(context))
                .into(iv);

    }


}
