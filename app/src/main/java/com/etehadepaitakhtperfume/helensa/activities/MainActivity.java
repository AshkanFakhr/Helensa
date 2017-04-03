package com.etehadepaitakhtperfume.helensa.activities;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.etehadepaitakhtperfume.helensa.R;

import java.util.HashMap;

public class MainActivity extends NavigationDrawerActivity
        implements BaseSliderView.OnSliderClickListener,
        ViewPagerEx.OnPageChangeListener {

    SliderLayout sliderLayout;
    HashMap<String, String> HashMapForURL;
    HashMap<String, Integer> HashMapForLocalRes;
    private Toolbar toolbar;
    private LinearLayoutCompat imgGalleryLay, branchesLay, productsLay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        TextView textView = (TextView) findViewById(R.id.toolbarTitle);
//        textView.setTypeface(tf);
//        textView.setText("");

        sliderLayout = (SliderLayout) findViewById(R.id.slider);

        /*//Call this method if you want to add slider images from URL .
        AddImagesUrlOnline();*/

        //Call this method to add slider images from local drawable folder .
        AddImageUrlFormLocalRes();

        //Call this method to stop automatic sliding.
        //sliderLayout.stopAutoCycle();

        for (String name : HashMapForLocalRes.keySet()) {

            TextSliderView textSliderView = new TextSliderView(MainActivity.this);

            textSliderView
                    .description(name)
                    .image(HashMapForLocalRes.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterInside)
                    .setOnSliderClickListener(this);

            textSliderView.bundle(new Bundle());

            textSliderView.getBundle()
                    .putString("extra", name);

            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.DepthPage);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(4000);
        sliderLayout.addOnPageChangeListener(MainActivity.this);

        imgGalleryLay = (LinearLayoutCompat) findViewById(R.id.imgGalleryLay);
        branchesLay = (LinearLayoutCompat) findViewById(R.id.branchesLay);
        productsLay = (LinearLayoutCompat) findViewById(R.id.productsLay);

        imgGalleryLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgGalleryLayClick();
            }
        });
        branchesLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                branchesLayClick();
            }
        });
        productsLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productsLayClick();
            }
        });
    }

    private void imgGalleryLayClick() {

    }

    private void branchesLayClick() {

    }

    private void productsLayClick() {

    }

    /*@Override
    protected void onStop() {
        sliderLayout.stopAutoCycle();
        super.onStop();
    }*/

    @Override
    public void onSliderClick(BaseSliderView slider) {

        Toast.makeText(this, slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {

        Log.d("Slider Demo", "Page Changed: " + position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /*public void AddImagesUrlOnline(){

        HashMapForURL = new HashMap<String, String>();

        HashMapForURL.put("CupCake", "http://androidblog.esy.es/images/cupcake-1.png");
        HashMapForURL.put("Donut", "http://androidblog.esy.es/images/donut-2.png");
        HashMapForURL.put("Eclair", "http://androidblog.esy.es/images/eclair-3.png");
        HashMapForURL.put("Froyo", "http://androidblog.esy.es/images/froyo-4.png");
        HashMapForURL.put("GingerBread", "http://androidblog.esy.es/images/gingerbread-5.png");
    }*/

    public void AddImageUrlFormLocalRes() {

        HashMapForLocalRes = new HashMap<String, Integer>();

        HashMapForLocalRes.put("Helensa", R.mipmap.ic_buy_history);
        HashMapForLocalRes.put("Perfume", R.mipmap.ic_user_info);
        HashMapForLocalRes.put("Test", R.mipmap.ic_introduced_users);
        HashMapForLocalRes.put("Android", R.mipmap.ic_launcher);
        HashMapForLocalRes.put("Ic Launcher", R.drawable.helensa_splash);

    }
}