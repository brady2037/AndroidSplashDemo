package com.shijc.androidsplashdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

public class AdsActivity extends Activity {
    private Activity activity;
    private TextView tvAds;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads);
        activity = this;
        tvAds = (TextView) findViewById(R.id.tv_ads);

        countDownTimer = new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvAds.setText("跳过广告" + (millisUntilFinished / 1000) + "秒");
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(activity, MainActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fade, R.anim.hold);
            }
        }.start();

        /**
         * 跳过广告
         */
        tvAds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                Intent intent = new Intent(activity, MainActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.fade, R.anim.hold);
            }
        });
    }
}
