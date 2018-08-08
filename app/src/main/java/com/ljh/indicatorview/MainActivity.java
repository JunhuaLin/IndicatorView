package com.ljh.indicatorview;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.ljh.indicatorview.adapter.MyViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.junhua.android.view.IndicatorView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewpager = findViewById(R.id.viewpager);
        IndicatorView indicator_view = findViewById(R.id.indicator_view);
        IndicatorView indicator_view1 = findViewById(R.id.indicator_view1);
        IndicatorView indicator_view2 = findViewById(R.id.indicator_view2);
        IndicatorView indicator_view3 = findViewById(R.id.indicator_view3);
        IndicatorView indicator_view4 = findViewById(R.id.indicator_view4);
        IndicatorView indicator_view5 = findViewById(R.id.indicator_view5);

        List<Integer> resList = new ArrayList<>();
        resList.add(R.mipmap.images1);
        resList.add(R.mipmap.images2);
        resList.add(R.mipmap.images3);
        resList.add(R.mipmap.images4);
        resList.add(R.mipmap.images5);
        resList.add(R.mipmap.images6);

        List<ImageView> imageViewList = new ArrayList<>();
        ImageView imageView;
        for (int res : resList) {
            imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(res);
            imageViewList.add(imageView);
        }

        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(imageViewList);
        viewpager.setAdapter(myViewPagerAdapter);

        indicator_view.setCount(resList.size());
        indicator_view1.setCount(resList.size());
        indicator_view2.setCount(resList.size());
        indicator_view3.setCount(resList.size());
        indicator_view4.setCount(resList.size());
        indicator_view5.setCount(resList.size());

        indicator_view.setupWithViewPager(viewpager);
        indicator_view1.setupWithViewPager(viewpager);
        indicator_view2.setupWithViewPager(viewpager);
        indicator_view3.setupWithViewPager(viewpager);
        indicator_view4.setupWithViewPager(viewpager);
        indicator_view5.setupWithViewPager(viewpager);

        indicator_view.setIndicatorTransformer(new ScaleIndicatorTransformer());
        indicator_view4.setIndicatorTransformer(new ScaleIndicatorTransformer());
        indicator_view5.setIndicatorTransformer(new IndicatorView.TranslationIndicatorTransformer());
    }


    private class ScaleIndicatorTransformer extends IndicatorView.TranslationIndicatorTransformer {
        @Override
        public void transformPage(IndicatorView page, Canvas canvas, int position, float positionOffset) {
            super.transformPage(page, canvas, position, positionOffset);
            Log.d(TAG, "transformPage() called with: position = [" + position + "], positionOffset = [" + positionOffset + "]");
            Rect bounds = page.getUnitBounds();
            float pos = Math.abs(positionOffset - 0.5f) * 2;
            pos = pos < 0.4f ? 0.4f : pos;
            canvas.scale(pos, pos, bounds.centerX(), bounds.centerY());
        }
    }

}
