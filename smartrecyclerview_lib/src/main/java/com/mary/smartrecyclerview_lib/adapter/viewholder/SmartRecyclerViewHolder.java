package com.mary.smartrecyclerview_lib.adapter.viewholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.util.Linkify;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * File Name:   SmartRecyclerViewHolder
 * Author:      Mary
 * Write Dates: 16/8/7
 * Description: RecyclerView的适配ViewHolder
 * Change log:
 * 16/8/7-22-14---[公司]---[姓名]
 * ......Added|Changed|Delete......
 * --------------------------------
 */
public class SmartRecyclerViewHolder extends RecyclerView.ViewHolder {

    // SparseArray这个类，和Map类似，但是比Map效率，但是键只能为Integer.
    private SparseArray<View> mViews;
    private View mConvertView;
    private Context mContext;
    private int mPosition;
    private int mLayoutId;

    /**
     * 添加 Header 和 Footer 会执行该方法
     * @param itemView  视图
     */
    public SmartRecyclerViewHolder(View itemView) {
        super(itemView);
    }

    /**
     * 生成普通 Item 时执行该方法(非Header 和 Footer)
     * @param context   当前上下文
     * @param itemView  视图
     * @param layoutId  布局ID
     */
    public SmartRecyclerViewHolder(Context context, View itemView, int layoutId) {
        super(itemView);
        this.mViews        = new SparseArray<View>();
        this.mContext      = context;
        this.mLayoutId     = layoutId;
        this.mConvertView  = itemView;
        mConvertView.setTag(this);
    }

    /**
     * 拿到一个RecyclerViewHolder对象
     * @param context      上下文对象
     * @param convertView  视图
     * @param layoutId     布局ID
     * @return
     */
    public static SmartRecyclerViewHolder get(Context context, View convertView, int layoutId) {
        if (null == convertView) {
            return new SmartRecyclerViewHolder(context, convertView, layoutId);
        } else {
            SmartRecyclerViewHolder recyclerViewHolder = (SmartRecyclerViewHolder) convertView.getTag();
            return recyclerViewHolder;
        }
    }

    /**
     * 获取下标
     * @return 下标
     */
    public int getIndex() {
        return mPosition;
    }

    /**
     * 设置下标
     */
    public void setIndex(int index) {
        this.mPosition = index;
    }

    /**
     * 获取布局ID
     * @return 布局ID
     */
    public int getLayoutId() {
        return mLayoutId;
    }

    /**
     * Item布局
     * @return Item布局
     */
    public View getConvertView() {
        return mConvertView;
    }

    /**
     * 通过控件的Id获取对于的控件，如果没有则加入views
     * @param viewId 控件ID
     * @param <T> 泛型
     * @return recyclerViewHolder
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (null == view) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 为TextView设置字符串
     * @param viewId
     * @param text
     * @return SmartRecyclerViewHolder
     */
    public SmartRecyclerViewHolder setText(int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    /**
     * 为ImageView设置图片
     * @param viewId
     * @param drawableId
     * @return SmartRecyclerViewHolder
     */
    public SmartRecyclerViewHolder setImageResource(int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);
        return this;
    }

    /**
     * 为ImageView设置图片
     * @param viewId
     * @param bitmap
     * @return SmartRecyclerViewHolder
     */
    public SmartRecyclerViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }

    /**
     * 为ImageView设置图片
     * @param viewId
     * @param drawable
     * @return SmartRecyclerViewHolder
     */
    public SmartRecyclerViewHolder setImageDrawable(int viewId, Drawable drawable) {
        ImageView view = getView(viewId);
        view.setImageDrawable(drawable);
        return this;
    }

    /**
     * 为控件设置背景颜色
     * @param viewId
     * @param color
     * @return SmartRecyclerViewHolder
     */
    public SmartRecyclerViewHolder setBackgroundColor(int viewId, int color) {
        View view = getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    /**
     * 为控件设置背景资源
     * @param viewId
     * @param backgroundResource
     * @return SmartRecyclerViewHolder
     */
    public SmartRecyclerViewHolder setBackgroundResource(int viewId, int backgroundResource) {
        View view = getView(viewId);
        view.setBackgroundResource(backgroundResource);
        return this;
    }

    /**
     * 设置TextView字体颜色
     * @param viewId 控件ID
     * @param color 例如：Color.red
     * @return SmartRecyclerViewHolder
     */
    public SmartRecyclerViewHolder setTextColor(int viewId, int color) {
        TextView view = getView(viewId);
        view.setTextColor(color);
        return this;
    }

    /**
     * 设置TextView字体的颜色资源
     * @param viewId 控件ID
     * @param colorRes 例如：R.color.red
     * @return SmartRecyclerViewHolder
     */
    public SmartRecyclerViewHolder setTextColorRes(int viewId, int colorRes) {
        TextView view = getView(viewId);
        view.setTextColor(mContext.getResources().getColor(colorRes));
        return this;
    }

    /**
     * 设置TextView字体大小
     * @param viewId 控件ID
     * @param value 数值
     * @return SmartRecyclerViewHolder
     */
    public SmartRecyclerViewHolder setTextSize(int viewId, float value) {
        TextView view = getView(viewId);
        view.setTextSize(value);
        return this;
    }

    /**
     * 为控件设置透明度
     * @param viewId 控件ID
     * @param value 透明度
     * @return SmartRecyclerViewHolder
     */
    public SmartRecyclerViewHolder setAlpha(int viewId, float value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getView(viewId).setAlpha(value);
        } else {
            // Pre-honeycomb hack to set Alpha value
            AlphaAnimation alphaAnimation = new AlphaAnimation(value, value);
            alphaAnimation.setDuration(0);
            alphaAnimation.setFillAfter(true);
            getView(viewId).startAnimation(alphaAnimation);
        }
        return this;
    }

    /**
     * 设置控件是否可见
     * @param viewId 控件ID
     * @param visible 是否可见
     * @return SmartRecyclerViewHolder
     */
    public SmartRecyclerViewHolder setVisible(int viewId, boolean visible) {
        View view = getView(viewId);
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
        return this;
    }

    public SmartRecyclerViewHolder linkify(int viewId) {
        TextView view = getView(viewId);
        Linkify.addLinks(view, Linkify.ALL);
        return this;
    }

    public SmartRecyclerViewHolder setTypeface(Typeface typeface, int... viewIds) {
        for (int viewId : viewIds) {
            TextView view = getView(viewId);
            view.setTypeface(typeface);
            view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        }
        return this;
    }

    /**
     * 为控件设置进度
     * @param viewId 控件ID
     * @param progress 进度
     * @return SmartRecyclerViewHolder
     */
    public SmartRecyclerViewHolder setProgress(int viewId, int progress) {
        ProgressBar view = getView(viewId);
        view.setProgress(progress);
        return this;
    }

    /**
     * 为控件设置进度
     * @param viewId 控件ID
     * @param progress 进度
     * @param max 最大进度
     * @return SmartRecyclerViewHolder
     */
    public SmartRecyclerViewHolder setProgress(int viewId, int progress, int max) {
        ProgressBar view = getView(viewId);
        view.setMax(max);
        view.setProgress(progress);
        return this;
    }

    /**
     *
     * @param viewId 控件ID
     * @param rating
     * @return SmartRecyclerViewHolder
     */
    public SmartRecyclerViewHolder setRating(int viewId, float rating) {
        RatingBar view = getView(viewId);
        view.setRating(rating);
        return this;
    }

    /**
     *
     * @param viewId 控件ID
     * @param rating
     * @param max 最大值
     * @return SmartRecyclerViewHolder
     */
    public SmartRecyclerViewHolder setRating(int viewId, float rating, int max) {
        RatingBar view = getView(viewId);
        view.setMax(max);
        view.setRating(rating);
        return this;
    }

    /**
     * 设置标签
     * @param viewId 控件ID
     * @param tag 标签
     * @return SmartRecyclerViewHolder
     */
    public SmartRecyclerViewHolder setTag(int viewId, Object tag) {
        View view = getView(viewId);
        view.setTag(tag);
        return this;
    }

    /**
     * 设置标签
     * @param viewId 控件ID
     * @param key 键值
     * @param tag 标签
     * @return SmartRecyclerViewHolder
     */
    public SmartRecyclerViewHolder setTag(int viewId, int key, Object tag) {
        View view = getView(viewId);
        view.setTag(key, tag);
        return this;
    }

    /**
     *
     * @param viewId 控件ID
     * @param checked 是否被选中
     * @return SmartRecyclerViewHolder
     */
    public SmartRecyclerViewHolder setChecked(int viewId, boolean checked) {
        View view = getView(viewId);
        ((Checkable) view).setChecked(checked);
        return this;
    }

    /**
     * 设置点击事件
     * @param viewId 控件ID
     * @param listener 监听
     * @return SmartRecyclerViewHolder
     */
    public SmartRecyclerViewHolder setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    /**
     * 设置触摸监听
     * @param viewId 控件ID
     * @param listener 监听
     * @return SmartRecyclerViewHolder
     */
    public SmartRecyclerViewHolder setOnTouchListener(int viewId, View.OnTouchListener listener) {
        View view = getView(viewId);
        view.setOnTouchListener(listener);
        return this;
    }

    /**
     * 设置长按事件
     * @param viewId 控件ID
     * @param listener 监听
     * @return SmartRecyclerViewHolder
     */
    public SmartRecyclerViewHolder setOnLongClickListener(int viewId, View.OnLongClickListener listener) {
        View view = getView(viewId);
        view.setOnLongClickListener(listener);
        return this;
    }


}
