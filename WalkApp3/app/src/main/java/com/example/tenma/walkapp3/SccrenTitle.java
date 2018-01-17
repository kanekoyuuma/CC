package com.example.tenma.walkapp3;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by yuuma on 2017/12/18.
 */

public class SccrenTitle extends ActivityAddToBGMandSE {
    Timer timer = null;
    Handler handle = new Handler();

    //BGM関係
    ////////////////////////////////
    @Override
    // 画面が表示される度に実行
    protected void onResume() {
        super.onResume();

        bgmStart();
    }
    @Override
    protected void onPause() {
        super.onPause();

        bgmPause();
    }
    /////////////////////////////////


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sccrentitle);
//        アニメーション
        findViewById(R.id.Start).startAnimation(AnimationUtils.loadAnimation(this, R.anim.start));
        findViewById(R.id.TitleName).startAnimation(AnimationUtils.loadAnimation(this, R.anim.title_name));

//        タイマーの時間
        if (timer == null) {
            timer = new Timer();
            timer.schedule(new MyTimer(), 5000); // ミリ秒でセット
        }
    }
    //    AppStratボタンのめそっど
    public void AppStart(View view){
        Intent intent = new Intent(this, AppMain_scenario.class);
        //遷移先の画面を起動
        startActivity(intent);
//        タイマーキャンセル
        timer.cancel();


    }
    //    douzyutuメソッド
    public void Start(View view){
//        遷移
        Intent intent = new Intent(SccrenTitle.this, AppMain_scenario.class);
        //遷移先の画面を起動
        startActivity(intent);
    }
    //    タイマーのメソッド
    class MyTimer extends TimerTask {
        @Override
        public void run() {
            handle.post(new Runnable() {
                @Override
//                実際にタイマーを起動したときに何をしたいか書くところ
                public void run() {


                    // アニメーションの設定
//                    overridePendingTransition(R.anim.senni5, R.anim.senni6);
                }
            });
        }
    }
}
