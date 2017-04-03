package com.etehadepaitakhtperfume.helensa.activities;

import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;

/*import uk.co.chrisjenx.calligraphy.CalligraphyTypefaceSpan;
import uk.co.chrisjenx.calligraphy.TypefaceUtils;*/

/**
 * Created by ${Ashkan} on ${12/9/2016}.
 */

public class BaseActivity extends AppCompatActivity {

    protected ProgressDialog progressDialog;
    protected Typeface tf;
    protected Typeface tfb;
    protected Typeface tfl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(this);

        tf = Typeface.createFromAsset(getAssets(), "fonts/theme.ttf");
        tfb = Typeface.createFromAsset(getAssets(), "fonts/theme_bold.ttf");
        tfl = Typeface.createFromAsset(getAssets(), "fonts/theme_light.ttf");

        String message = "لطفا صبر کنید ...";
        SpannableString spannableString = new SpannableString(message);

        /*CalligraphyTypefaceSpan typefaceSpan = new CalligraphyTypefaceSpan(TypefaceUtils.load(getAssets(), "fonts/theme.ttf"));
        spannableString.setSpan(typefaceSpan, 0, message.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);*/
        progressDialog.setMessage(spannableString);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);

    }
}
