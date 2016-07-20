package com.example.hzg.gallery;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

/**
 * Created by hzg on 2016/7/20.
 */
public class ImageAdapter extends BaseAdapter {
    private int[] res;
    private Context context;

    public ImageAdapter(int[] res, Context context) {
        this.res=res;
        this.context=context;
    }
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Object getItem(int position) {
        return res[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i("Main", "position=" + position + "res的角标=" + position % res.length);
        ImageView imageView = new ImageView(context);
        imageView.setBackgroundResource(res[position % res.length]);
        //大小
        imageView.setLayoutParams(new Gallery.LayoutParams(200, 150));
        //缩放模式
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }
}
