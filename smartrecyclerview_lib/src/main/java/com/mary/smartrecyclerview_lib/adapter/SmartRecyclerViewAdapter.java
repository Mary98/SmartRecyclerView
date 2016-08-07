package com.mary.smartrecyclerview_lib.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.mary.smartrecyclerview_lib.adapter.viewholder.SmartRecyclerViewHolder;
import com.mary.smartrecyclerview_lib.widget.ArrowRefreshHeader;

import java.util.ArrayList;
import java.util.List;

/**
 * File Name:
 * Author:      Mary
 * Write Dates: 16/8/7
 * Description:
 * Change log:
 * 16/8/7-22-13---[公司]---[姓名]
 * ......Added|Changed|Delete......
 * --------------------------------
 */
public abstract class SmartRecyclerViewAdapter<T> extends RecyclerView.Adapter<SmartRecyclerViewHolder> {
    /**数据*/
    protected List<T> mDatas;
    /**上下文对象*/
    protected Context mContext;
    /**Item的主布局视图*/
    protected View mConvertView;
    /**布局打气筒*/
    protected LayoutInflater mInflater;
    /**布局ID*/
    protected int mItemLayoutId;
    /** 下拉刷新 */
    private ArrowRefreshHeader mRefreshHeader = null;

    private static final int TYPE_REFRESH_HEADER = 10000;
    private static final int TYPE_FOOTER_VIEW = 10001;
    private static final int HEADER_INIT_INDEX = 10002;
    private static final int TYPE_NORMAL = 0;
    private static List<Integer> mHeaderTypes = new ArrayList<Integer>();
    private ArrayList<View> mHeaderViews = new ArrayList<View>();
    private ArrayList<View> mFooterViews = new ArrayList<View>();

}
