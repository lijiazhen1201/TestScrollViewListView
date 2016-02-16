package com.zhenmei.testscrollviewlistview.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.zhenmei.testscrollviewlistview.R;
import com.zhenmei.testscrollviewlistview.adapter.GridViewAdapter;


/**
 * Created by zhenmei on 16/2/16.
 */
public class ViewPagerFragmentLeft extends Fragment {

    private View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.item_viewpager, null);
        initView();
        return v;
    }

    private GridView gvIcon;
    private ImageView ivIconLeft;
    private ImageView ivIconRight;

    private void initView() {
        gvIcon = (GridView) v.findViewById(R.id.gv_icon);
        gvIcon.setFocusable(false);
        GridViewAdapter adapter = new GridViewAdapter(intImgs, iconTexts, getContext());
        gvIcon.setAdapter(adapter);
    }

    private int[] intImgs = {R.mipmap.ic_category_0, R.mipmap.ic_category_1, R.mipmap.ic_category_2, R.mipmap.ic_category_3, R.mipmap.ic_category_4, R.mipmap.ic_category_5, R.mipmap.ic_category_6, R.mipmap.ic_category_7, R.mipmap.ic_category_8, R.mipmap.ic_category_9};
    private String[] iconTexts={"美食","电影","酒店","KTV","今日新单","现金","周边游","小吃快餐","甜点饮品","生活",};

}
