package com.example.animationbetweenactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String ErrorTip = "Item Doesn't Exists!";
    private int Error = -1;
    private int selectId = Error;
    private int AnimationInId = Error;
    private int AnimationOutId = Error;
    private Spinner spinner;
    private Button button;
    private int AnimationInIds[] = {R.anim.fade_in,R.anim.shrink_fade_in,R.anim.magnify_fade_in,R.anim.magnify_left_top_in,
        R.anim.shrink_left_bottom_in,R.anim.push_up_in,R.anim.push_down_in,R.anim.push_left_in,R.anim.push_right_in,R.anim.rotate_fade_in};
    private int AnimationOutIds[] = {R.anim.fade_out,R.anim.shrink_fade_out,R.anim.magnify_fade_out,R.anim.magnify_right_top_in,
         R.anim.shrink_right_bottom_in,R.anim.push_up_out,R.anim.push_down_out,R.anim.push_left_out,R.anim.push_right_out,R.anim.rotate_fade_out};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        button = (Button) findViewById(R.id.button);
        spinner = (Spinner) findViewById(R.id.spinner);
        button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    selectId = (int) spinner.getSelectedItemId();
//              overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);
                    if (selectId < AnimationInIds.length && selectId > -1) {
                        setAnimation(selectId);
                    } else {
                        showTip();
                    }
                    startActivity(intent);
                    overridePendingTransition(AnimationInId, AnimationOutId);
                }
        });
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
//                startActivity(intent);
//                finish();
//                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
//            }
//        },1000);
    }
    private void showTip(){
        Toast.makeText(MainActivity.this, ErrorTip, Toast.LENGTH_SHORT).show();
    }
    private void setAnimation(int i){
        AnimationInId = AnimationInIds[i];
        AnimationOutId = AnimationOutIds[i];
    }
}
