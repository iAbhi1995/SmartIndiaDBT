package com.smartindia.hackathon.biotechnology;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.view.View;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.Target;
import com.github.amlcurran.showcaseview.targets.ViewTarget;
import com.smartindia.hackathon.biotechnology.login.view.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextPaint paint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(getResources().getDimension(R.dimen.abc_text_size_body_1_material));
        paint.setStrikeThruText(true);
        paint.setColor(Color.RED);

        Target viewTarget = new ViewTarget(R.id.button, this);
        final ShowcaseView s = new ShowcaseView.Builder(this)
                .setTarget(viewTarget)
                .setContentTitle("Abhi").setContentTextPaint(paint)
                .setContentText("abhi")
                .build();
        //setShowcaseDrawer(new CustomShowcaseView(getResources()))

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                s.hide();
                Target viewTarget1 = new ViewTarget(R.id.button2, MainActivity.this);
                final ShowcaseView s1 = new ShowcaseView.Builder(MainActivity.this)
                        .setTarget(viewTarget1)
                        .setContentTitle("Search Professors")
                        .setContentText("Designation,Researches")
                        .build();
            }
        }, 2000);
    }

    public void callLogin(View v) {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

}