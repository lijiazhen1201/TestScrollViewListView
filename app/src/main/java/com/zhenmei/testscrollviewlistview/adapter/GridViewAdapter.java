package com.zhenmei.testscrollviewlistview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhenmei.testscrollviewlistview.R;


/**
 * Created by zhenmei on 16/2/16.
 */
public class GridViewAdapter extends BaseAdapter {

    private int[] iconImgs;
    private String[] iconTexts;
    private Context mContext;

    public GridViewAdapter(int[] iconImgs, String[] iconTexts, Context mContext) {
        this.iconImgs = iconImgs;
        this.iconTexts = iconTexts;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return iconImgs.length;
    }

    @Override
    public Object getItem(int position) {
        return iconImgs[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder {
        private ImageView ivIcon;
        private TextView tvIcon;
    }

    private ViewHolder holder;

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        if (v == null) {
            v = LayoutInflater.from(mContext).inflate(R.layout.item_girdview, null);
            holder = new ViewHolder();
            holder.ivIcon = (ImageView) v.findViewById(R.id.iv_icon);
            holder.tvIcon = (TextView) v.findViewById(R.id.tv_icon);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        holder.ivIcon.setImageResource(iconImgs[position]);
        holder.tvIcon.setText(iconTexts[position]);
        return v;
    }
}
