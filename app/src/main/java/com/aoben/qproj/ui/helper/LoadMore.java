package com.aoben.qproj.ui.helper;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.aoben.qproj.util.LogUtils;

/**
 * Created by kenway on 18/4/3 11:15
 * Email : xiaokai090704@126.com
 */

public class LoadMore {

    private LoadMore(){

    }


    public static  class  ForRecyclerView extends  RecyclerView.OnScrollListener{


        private  int mLastVisiblePostion=-1;

        private OnLoadMoreListener loadMoreListener;

        public ForRecyclerView(OnLoadMoreListener loadMoreListener) {
            this.loadMoreListener = loadMoreListener;
        }


        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);

            View firstView  =recyclerView.getChildAt(0);


            int top=firstView.getTop();
            int  topEdge=recyclerView.getPaddingTop();
            //判断RecyclerView 的itemView是否满屏,如果不满上啦不会触发加载更多

            boolean isFullScreen=top<topEdge;

            RecyclerView.LayoutManager manager=recyclerView.getLayoutManager();
            int itemCount=manager.getItemCount();


            if (newState==RecyclerView.SCROLL_STATE_IDLE&&mLastVisiblePostion==(itemCount-1)&&isFullScreen){
                //最后一个item的时候,显示加载更多,
                //添加LoadMore布局

                loadMoreListener.showLoadMore();

                loadMoreListener.onLoadMore();
            }


        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                mLastVisiblePostion = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
            } else if (layoutManager instanceof GridLayoutManager) {
                mLastVisiblePostion = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                int[] lastPositions = new int[staggeredGridLayoutManager.getSpanCount()];
                staggeredGridLayoutManager.findLastVisibleItemPositions(lastPositions);
                mLastVisiblePostion = findMax(lastPositions);
            }
        }
    }



    public interface OnLoadMoreListener {
        void showLoadMore();

        void onLoadMore();

        void hideLoadMore();
    }




    /**
     * 获取数组中的最大值
     *
     * @param lastPositions
     * @return
     */
    protected  static int findMax(int[] lastPositions) {
        int max = lastPositions[0];
        for (int value : lastPositions) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

}
