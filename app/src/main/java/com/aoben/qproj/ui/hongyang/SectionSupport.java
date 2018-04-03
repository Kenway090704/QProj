package com.aoben.qproj.ui.hongyang;

/**
 * Created by kenway on 18/3/28 16:19
 * Email : xiaokai090704@126.com
 * <p>
 * 添加头部的Type,时的接口
 */

public interface SectionSupport<T> {

    public int sectionHeaderLayoutId();

    public int  sectionTitleTextViewId();

    public  String getTitle(T t);

}
