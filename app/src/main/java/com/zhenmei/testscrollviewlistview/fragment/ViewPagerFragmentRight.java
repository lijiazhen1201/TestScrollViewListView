package com.zhenmei.testscrollviewlistview.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.zhenmei.testscrollviewlistview.R;
import com.zhenmei.testscrollviewlistview.adapter.GridViewAdapter;


/**
 * Created by zhenmei on 16/2/16.
 */
public class ViewPagerFragmentRight extends Fragment {

    private View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.item_viewpager, null);
        initView();
        return v;
    }

    private GridView gvIcon;

    private void initView() {
        gvIcon = (GridView) v.findViewById(R.id.gv_icon);
        gvIcon.setFocusable(false);
        GridViewAdapter adapter = new GridViewAdapter(intImgs, iconTexts, getContext());
        gvIcon.setAdapter(adapter);
    }

    private int[] intImgs = {R.mipmap.ic_category_10, R.mipmap.ic_category_11, R.mipmap.ic_category_12, R.mipmap.ic_category_13, R.mipmap.ic_category_14, R.mipmap.ic_category_15, R.mipmap.ic_category_16, R.mipmap.ic_category_17, R.mipmap.ic_category_18, R.mipmap.ic_category_19};
    private String[] iconTexts={"休闲娱乐","丽人","足疗按摩","旅游","购物","全部分类","拍照","婴儿","男装","女装",};


}
