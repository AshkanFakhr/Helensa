package com.etehadepaitakhtperfume.helensa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity
        implements BaseSliderView.OnSliderClickListener,
        ViewPagerEx.OnPageChangeListener{

    SliderLayout sliderLayout;
    HashMap<String, String> HashMapForURL ;
    HashMap<String, Integer> HashMapForLocalRes ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderLayout = (SliderLayout)findViewById(R.id.slider);

        //Call this method if you want to add images from URL .
/*
        AddImagesUrlOnline();
*/

        //Call this method to add images from local drawable folder .
        AddImageUrlFormLocalRes();

        //Call this method to stop automatic sliding.
        //sliderLayout.stopAutoCycle();

        for(String name : HashMapForLocalRes.keySet()){

            TextSliderView textSliderView = new TextSliderView(MainActivity.this);

            textSliderView
                    .description(name)
                    .image(HashMapForLocalRes.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterInside)
                    .setOnSliderClickListener(this);

            textSliderView.bundle(new Bundle());

            textSliderView.getBundle()
                    .putString("extra",name);

            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.DepthPage);

        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);

        sliderLayout.setCustomAnimation(new DescriptionAnimation());

        sliderLayout.setDuration(4000);

        sliderLayout.addOnPageChangeListener(MainActivity.this);
    }

    /*@Override
    protected void onStop() {
        sliderLayout.stopAutoCycle();
        super.onStop();
    }*/

    @Override
    public void onSliderClick(BaseSliderView slider) {

        Toast.makeText(this,slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

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

    public void AddImageUrlFormLocalRes(){

        HashMapForLocalRes = new HashMap<String, Integer>();

        HashMapForLocalRes.put("Helensa", R.drawable.helensa_splash);
        HashMapForLocalRes.put("Perfume", R.mipmap.ic_launcher);
        HashMapForLocalRes.put("Test", R.drawable.helensa_splash);
        HashMapForLocalRes.put("Android", R.mipmap.ic_launcher);
        HashMapForLocalRes.put("Ic Launcher", R.drawable.helensa_splash);

    }
}