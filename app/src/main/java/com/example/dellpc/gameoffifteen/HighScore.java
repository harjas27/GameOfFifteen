package com.example.dellpc.gameoffifteen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by dell pc on 06-08-2016.
 */
public class HighScore extends AppCompatActivity{
    public static TextView hscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);
        hscore=(TextView)findViewById(R.id.highscore);
        hscore.setText(Integer.toString(Entry.hscore));
    }
}
