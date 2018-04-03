package com.aoben.qproj.ui.hongyang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by kenway on 18/3/28 16:08
 * Email : xiaokai090704@126.com
 * <p>
 * 支持多类型Adapter
 */

public abstract class MultiItemCommonAdapter<T> extends CommonAdapter<T> {

    protected MultiItemSupport<T> multiItemSupport;

    public MultiItemCommonAdapter(Context context, List<T> mDatas, MultiItemSupport<T> multiItemSupport) {
        super(context, -1, mDatas);
        this.multiItemSupport = multiItemSupport;
    }

    @Override
    public int getItemViewType(int position) {
        return multiItemSupport.getItemViewType(position, mDatas.get(position));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId = multiItemSupport.getLayoutId(viewType);
        ViewHolder holder = ViewHolder.get(context, parent, layoutId);
        return holder;
    }
}
