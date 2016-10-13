package com.example.dellpc.gameoffifteen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by dell pc on 09-08-2016.
 */
public class Score extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        String value="";
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
             value = extras.getString("keyy");
            //The key argument here must match that used in the other activity
        }
        TextView score=(TextView)findViewById(R.id.score);
        score.setText(value);
        Button playagain = (Button) findViewById(R.id.pagain);
        Button mmenu = (Button) findViewById(R.id.mainmenu);
        playagain.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(Score.this, MainActivity.class);
                        startActivity(i);

                    }
                });
        mmenu.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(Score.this, Entry.class);
                        startActivity(i);

                    }
                });
    }
}
