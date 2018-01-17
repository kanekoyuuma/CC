package com.example.tenma.walkapp3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Tenma and yuuma on 2017/12/15.
 */

public class AppMain_scenario extends AppCompatActivity {
    String result_str = "";
    TextView tv;

    static int number;
    SharedPreferences data;
    SharedPreferences.Editor editor;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autivity_main_scenario);
        findViewById(R.id.sankaku).startAnimation(AnimationUtils.loadAnimation(this, R.anim.start));

        //インスタンス

    }
    public void onResume(){
        super.onResume();
        data = getSharedPreferences("ZENKAIDATA",MODE_PRIVATE);
        editor = data.edit();
        // SharedPreferencesよりデータを読み込む
        number =data.getInt("ZenkaiData", 1);
    }
    public  void onClick(View view) {
        // SharedPreferencesよりデータを読み込む
        number =data.getInt("ZenkaiData", 1);

        //ディレクトリの文字列作成
        String dbStr = "data/data/" + getPackageName() + "/Sample.db";
        // 実際にDB作成
        //SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(dbStr,  null );
        Scenario s = new Scenario( getApplicationContext());
        SQLiteDatabase db = s.getReadableDatabase();


        String query_select ="SELECT name FROM menber WHERE id="+ number;

        Cursor cursor = db.rawQuery(query_select, null);

        while( cursor.moveToNext() ){
            int index_name  =   cursor.getColumnIndex("name");
            String name     =   cursor.getString(index_name);
            result_str      =  name + "\n";
        }
        if (number == 31){
            Intent intent = new Intent(this,AppMain_battle.class);
            //遷移先の画面を起動
            startActivity(intent);
        }
        else if (number==44 ) {
            Intent intent = new Intent(this,AppMain_battle.class);
            //遷移先の画面を起動
            startActivity(intent);
        }
        else if (number==75) {
            Intent intent = new Intent(this,AppMain_battle.class);
            //遷移先の画面を起動
            startActivity(intent);
        }
        else if (number==90) {
            Intent intent = new Intent(this,AppMain_battle.class);
            //遷移先の画面を起動
            startActivity(intent);
        }
        else if (number==106) {
            Intent intent = new Intent(this,AppMain_battle.class);
            //遷移先の画面を起動
            startActivity(intent);
        }
        else if ( number==140) {
            Intent intent = new Intent(this,AppMain_battle.class);
            //遷移先の画面を起動
            startActivity(intent);
        }
        else if (number==176) {
            Intent intent = new Intent(this,AppMain_battle.class);
            //遷移先の画面を起動
            startActivity(intent);
        }
        else if ( number==251) {
            Intent intent = new Intent(this,AppMain_battle.class);
            //遷移先の画面を起動
            startActivity(intent);
        }
        else if (number==309 ) {
            Intent intent = new Intent(this,AppMain_battle.class);
            //遷移先の画面を起動
            startActivity(intent);
        }
        else if (number==352 ) {
            Intent intent = new Intent(this,AppMain_battle.class);
            //遷移先の画面を起動
            startActivity(intent);
        }
        else if (number==357)  {
            Intent intent = new Intent(this,AppMain_battle.class);
            //遷移先の画面を起動
            startActivity(intent);
        }
        else if (number==360) {
            Intent intent = new Intent(this,AppMain_battle.class);
            //遷移先の画面を起動
            startActivity(intent);
        }
        else if (number==363) {
            Intent intent = new Intent(this,AppMain_battle.class);
            //遷移先の画面を起動
            startActivity(intent);
        }

        else {

            tv = (TextView) findViewById(R.id.textView3);
            tv.setTextColor(Color.WHITE);
            findViewById(R.id.textView3).startAnimation(AnimationUtils.loadAnimation(this, R.anim.storry));
            tv.setText("    " + result_str + "\n");
            tv.setTextSize(16.0f);
        }
        // tv.setText(String.valueOf(g));
        number++;
//        保存
        editor.putInt("ZenkaiData",number);
        editor.commit();

        cursor.close();
        db.close();

    }

    public void onStop(){
        super.onStop();

        Log.v("testtt", "number " + number);

        editor.putInt("ZenkaiData",number);
        editor.commit();
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
}
