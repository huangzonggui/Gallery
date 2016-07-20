package com.example.hzg.gallery;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener,ViewSwitcher.ViewFactory{
    private int[] res={R.drawable.item1,R.drawable.item2,R.drawable.item3,
            R.drawable.item4,R.drawable.item5,R.drawable.item6,
            R.drawable.item7, R.drawable.item8, R.drawable.item9,
            R.drawable.item10, R.drawable.item11, R.drawable.item12 };
    private Gallery gallery;
    private ImageAdapter imageAdapter;
    private ImageSwitcher is;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        gallery = (Gallery) findViewById(R.id.gallery);
        is = (ImageSwitcher) findViewById(R.id.is);
        // gallery加载适配器
        imageAdapter = new ImageAdapter(res,this);
        gallery.setAdapter(imageAdapter);
        gallery.setOnItemSelectedListener(this);

        is.setFactory(this);
        //加载系统自带的淡入淡出的效果
        is.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        is.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        imageSwitch加载选择的资源
        is.setBackgroundResource(res[position%res.length]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public View makeView() {
        ImageView image = new ImageView(this);
        //按等比例缩放，并且居中显示
        image.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return image;
    }
}
