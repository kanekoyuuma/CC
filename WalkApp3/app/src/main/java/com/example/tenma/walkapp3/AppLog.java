package com.example.tenma.walkapp3;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

/**
 * Created by Tenma and yuuma on 2017/12/15.
 */

public class AppLog extends AppCompatActivity{
    CalendarView calendarView;
    TextView dateDisplay;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        calendarView = (CalendarView) findViewById(R.id.calendarView);

        dateDisplay = (TextView) findViewById(R.id.date_display);
        dateDisplay.setText("日付をタップしてください");
//        dateDisplay.setTextSize(20.0f);
        // ～～～～～～～～～～～～～カレンダー～～～～～～～～～～～～～～～～～～～～～～～～～～
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {

                // ～～～～～～～データベース～～～～～～～～

                // 作成したDataクラスに読み取り専用でアクセス
                HosuukirokuTest hkData = new HosuukirokuTest( getApplicationContext() );
                SQLiteDatabase db = hkData.getReadableDatabase();

                // タップされた年月日
                int kakunoubanngou = (i*10000) + ((i1 + 1) * 100) + i2;

                // SELECT（取得したい列） FROM（対象テーブル）WHERE（条件）※変数を使う場合「 + 変数」文字列結合
                String sql = "SELECT hizuke , hosuu , karori FROM hosuukirokuTable WHERE hizuke=" + kakunoubanngou;

                Log.v("testt","日付:" + String.valueOf( kakunoubanngou ) );

                // SQL文を実行してデータを取得
                try {
                    c = db.rawQuery(sql, null);
                    c.moveToFirst();

                    // データベースから取ってきただけのデータを、使えるように変数へセット
                    String hizukeVal = c.getString(c.getColumnIndex("hizuke"));
                    String hosuuVal = c.getString(c.getColumnIndex("hosuu"));
                    String karoriVal = c.getString(c.getColumnIndex("karori"));

                    dateDisplay.setText((i1 + 1) + " 月 " + i2 + "日の歩数は" + hosuuVal + "歩です。\n\n\n\n" + "カロリーは" + karoriVal + "㌔カロリーです");
                    dateDisplay.setTextSize(16.0f);

                } catch ( Exception e){
                    dateDisplay.setText("\n\n"+(i1 + 1) + " 月 " + i2 + "日のデータがありません。\n\n");
                    dateDisplay.setTextSize(16.0f);
                } finally {
                    // クローズ処理
                    c.close();
                    db.close();
                }
            }
        });
    }
    public void MainBack(View view){
        Intent intent = new Intent(this, AppMain_battle.class);
        //遷移先の画面を起動
        startActivity(intent);
    }
}
