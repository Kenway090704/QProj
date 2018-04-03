package com.aoben.qproj.ui.hongyang;

/**
 * Created by kenway on 18/3/28 15:52
 * Email : xiaokai090704@126.com
 *
 * 支持多种ItemView
 */

public interface MultiItemSupport<T> {

    /**
     *
     * 根据不同的ItemType返回不同的Layout
     * @param itemType
     * @return
     */
    int  getLayoutId(int itemType);

    /**
     * 根据位置生成不同的
     * @param position
     * @param t
     * @return
     */
    int  getItemViewType(int position,T t);
}
