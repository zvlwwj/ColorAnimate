package com.zou.coloranimate;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Button btn_start_animate;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_start_animate = (Button) findViewById(R.id.btn_start_animate);
        iv = (ImageView) findViewById(R.id.iv);
        btn_start_animate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn_start_animate.getText().equals("由彩色变黑白")) {
                    ValueAnimator showValueAnimator = ValueAnimator.ofFloat(1.0f,
                            0.0f);
                    showValueAnimator
                            .addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                private ColorMatrix cm = new ColorMatrix();

                                @Override
                                public void onAnimationUpdate(
                                        ValueAnimator animation) {
                                    float currentSaturation = (Float) animation
                                            .getAnimatedValue();
                                    cm.setSaturation(currentSaturation);
                                    iv.setColorFilter(new ColorMatrixColorFilter(
                                            cm));
                                }
                            });
                    showValueAnimator.addListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            btn_start_animate.setClickable(false);
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            btn_start_animate.setText("由黑白变彩色");
                            btn_start_animate.setClickable(true);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });
                    showValueAnimator.setDuration(2000);
                    showValueAnimator.start();
                }else if(btn_start_animate.getText().equals("由黑白变彩色")){
                    ValueAnimator showValueAnimator = ValueAnimator.ofFloat(0.0f,
                            1.0f);
                    showValueAnimator
                            .addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                private ColorMatrix cm = new ColorMatrix();

                                @Override
                                public void onAnimationUpdate(
                                        ValueAnimator animation) {
                                    float currentSaturation = (Float) animation
                                            .getAnimatedValue();
                                    cm.setSaturation(currentSaturation);
                                    iv.setColorFilter(new ColorMatrixColorFilter(
                                            cm));
                                }
                            });
                    showValueAnimator.addListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            btn_start_animate.setClickable(false);
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            btn_start_animate.setText("由彩色变黑白");
                            btn_start_animate.setClickable(true);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    });
                    showValueAnimator.setDuration(2000);
                    showValueAnimator.start();
                }
            }
        });
    }
}
