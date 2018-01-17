package com.example.tenma.walkapp3;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Tenma on 2017/12/15.
 */

public class AppMain_battle extends AppCompatActivity {

    //imageボタンの画像切り替えで使う変数
    ImageButton battle, magic, check, escape;
    //ボタンが二回押されたかの判定で使う変数
    int buttonFlag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_battle);
        ImageButton ib1 = (ImageButton) findViewById(R.id.main_hukidashi2);
        ib1.setImageResource(R.drawable.main_hukidasi);
        findViewById(R.id.main_hukidashi2).setVisibility(View.INVISIBLE);

    }

    public void StatusStart(View view) {
        Intent intent = new Intent(this, AppStatus.class);
        //遷移先の画面を起動
        startActivity(intent);
    }

    public void LogStart(View view) {
        Intent intent = new Intent(this, AppLog.class);
        //遷移先の画面を起動
        startActivity(intent);
    }



    public void change(View view) {


        switch (view.getId()) {

            case R.id.main_battle:

                //矢印がどれも選択していない場合
                if (buttonFlag == 0) {
                    battle = (ImageButton) findViewById(R.id.main_battle);
                    battle.setImageResource(R.drawable.main_battle2);
                    buttonFlag = 1;

                    //矢印がたたかう以外選択していた場合
                } else if (buttonFlag != 1) {
                    battle = (ImageButton) findViewById(R.id.main_battle);
                    battle.setImageResource(R.drawable.main_battle2);
                    magic = (ImageButton) findViewById(R.id.main_magic);
                    magic.setImageResource(R.drawable.main_magic1);
                    check = (ImageButton) findViewById(R.id.main_check);
                    check.setImageResource(R.drawable.main_check1);
                    escape = (ImageButton) findViewById(R.id.main_escape);
                    escape.setImageResource(R.drawable.main_escape1);
                    buttonFlag = 1;

                    //矢印がたたかうを選択していた場合
                } else if (buttonFlag == 1) {
                    TextView tv = (TextView) findViewById(R.id.main_text);
                    tv.setText("まおう のこうけ゛き Ａに１００のタ゛メーシ゛");
                    tv.setTypeface(Typeface.createFromAsset(getAssets(), "DragonQuestFCIntact.ttf"));
                    tv.setTextColor(Color.WHITE);
                    tv.setTextSize(10);
                    findViewById(R.id.main_hukidashi2).setVisibility(View.VISIBLE);
                    findViewById(R.id.main_text).setVisibility(View.VISIBLE);
                }


                break;


            case R.id.main_magic:

                //矢印がなにも選択していない場合
                if (buttonFlag == 0) {
                    //まほうが選ばれたらまほうに矢印
                    magic = (ImageButton) findViewById(R.id.main_magic);
                    magic.setImageResource(R.drawable.main_magic2);
                    buttonFlag = 2;
                    //矢印がまほう以外を選択していた場合
                } else if (buttonFlag != 2) {
                    magic = (ImageButton) findViewById(R.id.main_magic);
                    magic.setImageResource(R.drawable.main_magic2);
                    battle = (ImageButton) findViewById(R.id.main_battle);
                    battle.setImageResource(R.drawable.main_battle1);
                    check = (ImageButton) findViewById(R.id.main_check);
                    check.setImageResource(R.drawable.main_check1);
                    escape = (ImageButton) findViewById(R.id.main_escape);
                    escape.setImageResource(R.drawable.main_escape1);
                    buttonFlag = 2;
                    //矢印がまほうを選択していた場合
                } else if (buttonFlag == 2) {
                    TextView tv = (TextView) findViewById(R.id.main_text);
                    tv.setText("まおう は し゛ゅもん をはなった Ａに１００のタ゛メーシ゛");
                    tv.setTypeface(Typeface.createFromAsset(getAssets(), "DragonQuestFCIntact.ttf"));
                    tv.setTextColor(Color.WHITE);
                    tv.setTextSize(10);
                    findViewById(R.id.main_hukidashi2).setVisibility(View.VISIBLE);
                    findViewById(R.id.main_text).setVisibility(View.VISIBLE);

                }






                break;

            case R.id.main_check:

                //矢印がなにも選択していない場合
                if(buttonFlag == 0) {
                    //かくにんが選ばれたらかくにんに矢印
                    check = (ImageButton) findViewById(R.id.main_check);
                    check.setImageResource(R.drawable.main_check2);
                    buttonFlag = 3;

                    //矢印がかくにん以外を選択していた場合
                }else if(buttonFlag != 3){
                    check = (ImageButton) findViewById(R.id.main_check);
                    check.setImageResource(R.drawable.main_check2);
                    battle = (ImageButton) findViewById(R.id.main_battle);
                    battle.setImageResource(R.drawable.main_battle1);
                    magic = (ImageButton) findViewById(R.id.main_magic);
                    magic.setImageResource(R.drawable.main_magic1);
                    escape = (ImageButton) findViewById(R.id.main_escape);
                    escape.setImageResource(R.drawable.main_escape1);
                    buttonFlag = 3;

                    //矢印がかくにんを選んでいた場合
                }else if(buttonFlag == 3){
                    TextView tv = (TextView) findViewById(R.id.main_text);
                    tv.setText("いま の ホ゜イント は １００ ホ゜イント て゛す");
                    tv.setTypeface(Typeface.createFromAsset(getAssets(), "DragonQuestFCIntact.ttf"));
                    tv.setTextColor(Color.WHITE);
                    tv.setTextSize(10);
                    findViewById(R.id.main_hukidashi2).setVisibility(View.VISIBLE);
                    findViewById(R.id.main_text).setVisibility(View.VISIBLE);

                }
                break;

            case R.id.main_escape:

                //矢印がなにも選択していなかった場合
                if(buttonFlag == 0) {
                    //にげるが選ばれたらにげるに矢印
                    escape = (ImageButton) findViewById(R.id.main_escape);
                    escape.setImageResource(R.drawable.main_escape2);
                    buttonFlag = 4;
                    //矢印が逃げる以外を選択していた場合
                }else if(buttonFlag != 4){
                    escape = (ImageButton) findViewById(R.id.main_escape);
                    escape.setImageResource(R.drawable.main_escape2);
                    battle = (ImageButton) findViewById(R.id.main_battle);
                    battle.setImageResource(R.drawable.main_battle1);
                    magic = (ImageButton) findViewById(R.id.main_magic);
                    magic.setImageResource(R.drawable.main_magic1);
                    check = (ImageButton) findViewById(R.id.main_check);
                    check.setImageResource(R.drawable.main_check1);
                    buttonFlag = 4;

                    //矢印が逃げるを選択していた場合
                }else if(buttonFlag == 4){
                    TextView tv = (TextView) findViewById(R.id.main_text);
                    tv.setText("テ゛フ゛すき゛て にけ゛られない ！！");
                    tv.setTypeface(Typeface.createFromAsset(getAssets(), "DragonQuestFCIntact.ttf"));
                    tv.setTextColor(Color.WHITE);
                    tv.setTextSize(10);
                    findViewById(R.id.main_hukidashi2).setVisibility(View.VISIBLE);
                    findViewById(R.id.main_text).setVisibility(View.VISIBLE);
                }

                break;

            case R.id.main_hukidashi2:
                findViewById(R.id.main_hukidashi2).setVisibility(View.INVISIBLE);
                findViewById(R.id.main_text).setVisibility(View.INVISIBLE);

                //矢印の初期化
                battle = (ImageButton) findViewById(R.id.main_battle);
                battle.setImageResource(R.drawable.main_battle1);
                magic = (ImageButton) findViewById(R.id.main_magic);
                magic.setImageResource(R.drawable.main_magic1);
                check = (ImageButton) findViewById(R.id.main_check);
                check.setImageResource(R.drawable.main_check1);
                escape = (ImageButton) findViewById(R.id.main_escape);
                escape.setImageResource(R.drawable.main_escape1);
                buttonFlag = 0;
                break;

        }
    }
}