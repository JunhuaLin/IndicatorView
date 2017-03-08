package com.ljh.indicatorview.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by junhua on 17-3-8.
 */

public class MyViewPagerAdapter extends PagerAdapter {

    private List<ImageView> imageViewList;

    public MyViewPagerAdapter(List<ImageView> imageViewList) {
        this.imageViewList = imageViewList;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = imageViewList.get(position);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(imageViewList.get(position));
    }

    @Override
    public int getCount() {
        return imageViewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
