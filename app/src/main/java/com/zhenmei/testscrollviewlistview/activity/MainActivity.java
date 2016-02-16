package com.zhenmei.testscrollviewlistview.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;

import com.zhenmei.testscrollviewlistview.R;
import com.zhenmei.testscrollviewlistview.adapter.ViewPagerAdapter;
import com.zhenmei.testscrollviewlistview.fragment.ViewPagerFragmentLeft;
import com.zhenmei.testscrollviewlistview.fragment.ViewPagerFragmentRight;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private ScrollView myScrollView;
    private ViewPager vpIcon;
    private ListView lvList;
    private ImageView ivIconLeft;
    private ImageView ivIconRight;

    private void initView() {
        myScrollView=(ScrollView)findViewById(R.id.my_scroll_view);
        vpIcon = (ViewPager) findViewById(R.id.vp_icon);
        lvList = (ListView) findViewById(R.id.lv_list);
        ivIconLeft = (ImageView) findViewById(R.id.iv_icon_left);
        ivIconRight = (ImageView) findViewById(R.id.iv_icon_right);

        myScrollView.smoothScrollTo(0,0);

        ArrayList<String> items = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            items.add("item" + (i + 1));
        }
        ArrayAdapter<String> adapterList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        lvList.setAdapter(adapterList);

        FragmentManager fm = getSupportFragmentManager();
        List<Fragment> list = new ArrayList<>();
        ViewPagerFragmentLeft left = new ViewPagerFragmentLeft();
        ViewPagerFragmentRight right = new ViewPagerFragmentRight();
        list.add(left);
        list.add(right);
        ViewPagerAdapter adapter = new ViewPagerAdapter(fm, list);
        vpIcon.setAdapter(adapter);

        vpIcon.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                changePage(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        changePage(0);
    }

    private void changePage(int position){
        ivIconLeft.setImageResource(R.mipmap.mtadvert_indicator_normal);
        ivIconRight.setImageResource(R.mipmap.mtadvert_indicator_normal);
        switch (position){
            case 0:
                ivIconLeft.setImageResource(R.mipmap.mtadvert_indicator_selected);
                break;
            case 1:
                ivIconRight.setImageResource(R.mipmap.mtadvert_indicator_selected);
                break;
            default:
                break;
        }
    }

}
