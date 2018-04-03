package com.aoben.qproj.ui.hongyang;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.aoben.qproj.util.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kenway on 18/3/28 14:54
 * Email : xiaokai090704@126.com
 */

public abstract class CommonAdapter<T> extends RecyclerView.Adapter<ViewHolder> {

    protected Context context;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;

    public CommonAdapter(Context context, int mLayoutId, List<T> mDatas) {
        this.context = context;
        this.mLayoutId = mLayoutId;

        if (mDatas == null) {
            this.mDatas = new ArrayList<>();
        } else {
            this.mDatas = mDatas;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = ViewHolder.get(context, parent, mLayoutId);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        LogUtils.e("position==" + position);
        convert(holder, mDatas.get(position));
    }

    public abstract void convert(ViewHolder holder, T t);

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void addDatas(List<T> list) {
        if (list == null) {
            return;
        }
        int beginIndex = mDatas.size();
        mDatas.addAll(list);
        //这里需要注意一下,看更新的对不对
        notifyItemRangeChanged(beginIndex, mDatas.size() - beginIndex);
    }
}
