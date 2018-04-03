package com.aoben.qproj.ui.hongyang;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by kenway on 18/3/28 16:23
 * Email : xiaokai090704@126.com
 * 有头的adapter
 */

public abstract class SectionAdapter<T> extends MultiItemCommonAdapter<T> {

    private SectionSupport<T> sectionSupport;
    private static final int TYPE_SECTION = 0;
    private LinkedHashMap<String, Integer> mSections;

    private MultiItemSupport<T> headerItemTypeSupport = new MultiItemSupport<T>() {
        @Override
        public int getLayoutId(int itemType) {

            if (itemType == TYPE_SECTION)
                return sectionSupport.sectionHeaderLayoutId();
            else
                return mLayoutId;

        }

        @Override
        public int getItemViewType(int position, T t) {
            return mSections.values().contains(position) ? TYPE_SECTION : 1;
        }
    };

    @Override
    public int getItemViewType(int position) {
        return multiItemSupport.getItemViewType(position, null);
    }

    final RecyclerView.AdapterDataObserver observer = new RecyclerView.AdapterDataObserver() {
        @Override
        public void onChanged() {
            super.onChanged();

            findSections();
        }
    };


    public SectionAdapter(Context context, int layoutId, List<T> mDatas, SectionSupport<T> sectionSupport) {
        super(context, mDatas, null);
        mLayoutId = layoutId;
        multiItemSupport = headerItemTypeSupport;
        this.sectionSupport = sectionSupport;
        mSections = new LinkedHashMap<>();
        findSections();
        registerAdapterDataObserver(observer);
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        unregisterAdapterDataObserver(observer);
    }

    public   void findSections(){
        int n =mDatas.size();
        int nSections=0;
        mSections.clear();
        for (int i=0;i<n;i++){
            String sectionName=sectionSupport.getTitle(mDatas.get(i));

            if (!mSections.containsKey(sectionName)){
                mSections.put(sectionName,i+nSections);
                nSections++;
            }
        }
    }

    @Override
    public int getItemCount() {
        return super.getItemCount()+mSections.size();
    }


    public  int getIndexPosition(int position){
        int nSections=0;
        Set<Map.Entry<String,Integer>> entrySet=mSections.entrySet();

        for (Map.Entry<String,Integer> entry:entrySet){
            if (entry.getValue()<position){
                nSections++;
            }
        }
        return position-nSections;
    }




    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        position=getIndexPosition(position);
        if (holder.getItemViewType()==TYPE_SECTION){
            holder.setText(sectionSupport.sectionTitleTextViewId(),sectionSupport.getTitle(mDatas.get(position)));
            return;
        }
        super.onBindViewHolder(holder, position);
    }
}
