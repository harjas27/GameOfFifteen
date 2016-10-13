package com.example.dellpc.gameoffifteen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
/**
 * Created by dell pc on 06-08-2016.
 */
public class Entry extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    public static int hscore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        LoadInt();
        Button play = (Button) findViewById(R.id.playgame);
        Button highscore = (Button) findViewById(R.id.highscore);
        Button quit = (Button) findViewById(R.id.quit);
        play.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(Entry.this, MainActivity.class);
                        startActivity(i);
                        Toast toast = Toast.makeText(Entry.this, "message", Toast.LENGTH_SHORT);
                        toast.setText("BEST OF LUCK");
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        //other setters
                        toast.show();
                    }
                });
        quit.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        //System.exit(0);
                        Toast toast = Toast.makeText(Entry.this, "message", Toast.LENGTH_SHORT);
                        toast.setText("THANKS FOR PLAYING");
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        //other setters
                        toast.show();
                        finish();
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
        highscore.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(Entry.this, HighScore.class);
                        startActivity(i);
                    }
                });

    }
    public void SaveInt(String key, int value){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }
    public void LoadInt(){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        hscore = sharedPreferences.getInt("key", 0);
    }
}