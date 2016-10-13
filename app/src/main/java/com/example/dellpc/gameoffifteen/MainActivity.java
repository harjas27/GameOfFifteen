package com.example.dellpc.gameoffifteen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    String s;
    int count=0;
    String s2=Integer.toString(count);
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button mybutton9 =(Button)findViewById(R.id.button9);
        final Button mybutton8 =(Button)findViewById(R.id.button8);
        final Button mybutton7 =(Button)findViewById(R.id.button7);
        final Button mybutton6 =(Button)findViewById(R.id.button6);
        final Button mybutton5 =(Button)findViewById(R.id.button5);
        final Button mybutton4 =(Button)findViewById(R.id.button4);
        final Button mybutton3 =(Button)findViewById(R.id.button3);
        final Button mybutton2 =(Button)findViewById(R.id.button2);
        final Button mybutton1 =(Button)findViewById(R.id.button1);
        //final TextView text =(TextView)findViewById(R.id.text);
        final int[][] board = new int[3][3];

        final TextView text =(TextView)findViewById(R.id.text);
        text.setText(s2);

        board[0][0]=Integer.parseInt(mybutton9.getText().toString());
        board[0][1]=Integer.parseInt(mybutton8.getText().toString());
        board[0][2]=Integer.parseInt(mybutton7.getText().toString());
        board[1][0]=Integer.parseInt(mybutton6.getText().toString());
        board[1][1]=Integer.parseInt(mybutton5.getText().toString());
        board[1][2]=Integer.parseInt(mybutton4.getText().toString());
        board[2][0]=Integer.parseInt(mybutton3.getText().toString());
        board[2][1]=Integer.parseInt(mybutton2.getText().toString());
        board[2][2]=0;


        mybutton9.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        int x1=0,y1=0;
                        int x2=0,y2=0;
                        int tile=0;
                        if(mybutton9.getText().toString() == "_")
                        {
                            tile=0;
                        }
                        else
                        {
                            tile = Integer.parseInt(mybutton9.getText().toString());
                        }
                        for(int i=0;i<3;i++)
                        {
                            for(int j=0;j<3;j++)
                            {
                                if(board[i][j]==tile)
                                {
                                    x1=i;
                                    y1=j;
                                }
                                if(board[i][j]==0)
                                {
                                    x2=i;
                                    y2=j;
                                }
                            }
                        }
                        if(((y1==y2)&&((x1==x2+1)||(x1==x2-1)))|| ((x1==x2)&&((y1==y2+1)||(y1==y2-1))))
                        {
                            s=Integer.toString(tile);
                            mybutton9.setText("_");
                            count++;
                            s2=Integer.toString(count);
                            text.setText(s2);
                            if(x2==0)
                            {
                                if(y2==0)
                                    mybutton9.setText(s);
                                else if(y2==1)
                                    mybutton8.setText(s);
                                else
                                    mybutton7.setText(s);
                            }
                            else if(x2==1)
                            {
                                if(y2==0)
                                    mybutton6.setText(s);
                                else if(y2==1)
                                    mybutton5.setText(s);
                                else
                                    mybutton4.setText(s);
                            }
                            else
                            {
                                if(y2==0)
                                    mybutton3.setText(s);
                                else if(y2==1)
                                    mybutton2.setText(s);
                                else
                                    mybutton1.setText(s);
                            }
                            board[0][0]=0;
                            board[0][1]=Integer.parseInt(mybutton8.getText().toString());
                            board[0][2]=Integer.parseInt(mybutton7.getText().toString());
                            board[1][0]=Integer.parseInt(mybutton6.getText().toString());
                            board[1][1]=Integer.parseInt(mybutton5.getText().toString());
                            board[1][2]=Integer.parseInt(mybutton4.getText().toString());
                            board[2][0]=Integer.parseInt(mybutton3.getText().toString());
                            board[2][1]=Integer.parseInt(mybutton2.getText().toString());
                            board[2][2]=Integer.parseInt(mybutton1.getText().toString());
                        }
                        else
                        {
                            Toast toast = Toast.makeText(MainActivity.this, "message", Toast.LENGTH_SHORT);
                            toast.setText("Invalid Move");
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            //other setters
                            toast.show();
                        }


                        int k=0,f=0;
                        for(int i=0;i<3;i++)
                        {
                            for(int j=0;j<3;j++)
                            {
                                k+=1;
                                if(i==2 && j==2)
                                {
                                    if(board[i][j]!=0)
                                    {
                                        f=1;
                                    }
                                }
                                else
                                {
                                    if(board[i][j]!=k)
                                    {
                                        f=1;
                                    }
                                }
                            }
                        }
                        // check for win
                        if (f==0)
                        {
                            Toast toast = Toast.makeText(MainActivity.this, "message", Toast.LENGTH_SHORT);
                            toast.setText("WIN");
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            //other setters
                            toast.show();
                            Save(count);
                            count=0;
                            text.setText("0");
                        }
                        // prompt for move
                        else
                        {
                            //text.setText("next move...");
                        }


                    }
                });

            mybutton8.setOnClickListener(
                    new Button.OnClickListener() {
                        public void onClick(View v) {
                            int x1=0,y1=0;
                            int x2=0,y2=0;
                            int tile;
                            if(mybutton8.getText().toString() == "_")
                            {
                                tile=0;
                            }
                            else
                            {
                                tile = Integer.parseInt(mybutton8.getText().toString());
                            }
                            for(int i=0;i<3;i++)
                            {
                                for(int j=0;j<3;j++)
                                {
                                    if(board[i][j]==tile)
                                    {
                                        x1=i;
                                        y1=j;
                                    }
                                    if(board[i][j]==0)
                                    {
                                        x2=i;
                                        y2=j;
                                    }
                                }
                            }
                            if(((y1==y2)&&((x1==x2+1)||(x1==x2-1)))|| ((x1==x2)&&((y1==y2+1)||(y1==y2-1))))
                            {
                                s=Integer.toString(tile);
                                mybutton8.setText("_");
                                count++;
                                s2=Integer.toString(count);
                                text.setText(s2);
                                if(x2==0)
                                {
                                    if(y2==0)
                                        mybutton9.setText(s);
                                    else if(y2==1)
                                        mybutton8.setText(s);
                                    else
                                        mybutton7.setText(s);
                                }
                                else if(x2==1)
                                {
                                    if(y2==0)
                                        mybutton6.setText(s);
                                    else if(y2==1)
                                        mybutton5.setText(s);
                                    else
                                        mybutton4.setText(s);
                                }
                                else
                                {
                                    if(y2==0)
                                        mybutton3.setText(s);
                                    else if(y2==1)
                                        mybutton2.setText(s);
                                    else
                                        mybutton1.setText(s);
                                }
                                board[0][0]=Integer.parseInt(mybutton9.getText().toString());
                                board[0][1]=0;
                                board[0][2]=Integer.parseInt(mybutton7.getText().toString());
                                board[1][0]=Integer.parseInt(mybutton6.getText().toString());
                                board[1][1]=Integer.parseInt(mybutton5.getText().toString());
                                board[1][2]=Integer.parseInt(mybutton4.getText().toString());
                                board[2][0]=Integer.parseInt(mybutton3.getText().toString());
                                board[2][1]=Integer.parseInt(mybutton2.getText().toString());
                                board[2][2]=Integer.parseInt(mybutton1.getText().toString());
                            }
                            else
                            {
                                Toast toast = Toast.makeText(MainActivity.this, "message", Toast.LENGTH_SHORT);
                                toast.setText("Invalid Move");
                                toast.setGravity(Gravity.CENTER, 0, 0);
                                //other setters
                                toast.show();
                            }



                            int k=0,f=0;
                            for(int i=0;i<3;i++)
                            {
                                for(int j=0;j<3;j++)
                                {
                                    k+=1;
                                    if(i==2 && j==2)
                                    {
                                        if(board[i][j]!=0)
                                        {
                                            f=1;
                                        }
                                    }
                                    else
                                    {
                                        if(board[i][j]!=k)
                                        {
                                            f=1;
                                        }
                                    }
                                }
                            }
                            // check for win
                            if (f==0)
                            {
                                //text.setText("won!!");
                                Save(count);
                                count=0;
                                Toast toast = Toast.makeText(MainActivity.this, "message", Toast.LENGTH_SHORT);
                                toast.setText("WIN");
                                toast.setGravity(Gravity.CENTER, 0, 0);
                                //other setters
                                toast.show();
                                text.setText("0");
                            }
                            // prompt for move
                            else
                            {
                                //text.setText("next move...");
                            }


                        }
                    });

        mybutton7.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        int x1=0,y1=0;
                        int x2=0,y2=0;
                        int tile;
                        if(mybutton7.getText().toString() == "_")
                        {
                            tile=0;
                        }
                        else
                        {
                            tile = Integer.parseInt(mybutton7.getText().toString());
                        }
                        for(int i=0;i<3;i++)
                        {
                            for(int j=0;j<3;j++)
                            {
                                if(board[i][j]==tile)
                                {
                                    x1=i;
                                    y1=j;
                                }
                                if(board[i][j]==0)
                                {
                                    x2=i;
                                    y2=j;
                                }
                            }
                        }
                        if(((y1==y2)&&((x1==x2+1)||(x1==x2-1)))|| ((x1==x2)&&((y1==y2+1)||(y1==y2-1))))
                        {
                            s=Integer.toString(tile);
                            mybutton7.setText("_");
                            count++;
                            s2=Integer.toString(count);
                            text.setText(s2);
                            if(x2==0)
                            {
                                if(y2==0)
                                    mybutton9.setText(s);
                                else if(y2==1)
                                    mybutton8.setText(s);
                                else
                                    mybutton7.setText(s);
                            }
                            else if(x2==1)
                            {
                                if(y2==0)
                                    mybutton6.setText(s);
                                else if(y2==1)
                                    mybutton5.setText(s);
                                else
                                    mybutton4.setText(s);
                            }
                            else
                            {
                                if(y2==0)
                                    mybutton3.setText(s);
                                else if(y2==1)
                                    mybutton2.setText(s);
                                else
                                    mybutton1.setText(s);
                            }
                            board[0][0]=Integer.parseInt(mybutton9.getText().toString());
                            board[0][1]=Integer.parseInt(mybutton8.getText().toString());
                            board[0][2]=0;
                            board[1][0]=Integer.parseInt(mybutton6.getText().toString());
                            board[1][1]=Integer.parseInt(mybutton5.getText().toString());
                            board[1][2]=Integer.parseInt(mybutton4.getText().toString());
                            board[2][0]=Integer.parseInt(mybutton3.getText().toString());
                            board[2][1]=Integer.parseInt(mybutton2.getText().toString());
                            board[2][2]=Integer.parseInt(mybutton1.getText().toString());
                        }
                        else
                        {
                            Toast toast = Toast.makeText(MainActivity.this, "message", Toast.LENGTH_SHORT);
                            toast.setText("Invalid Move");
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            //other setters
                            toast.show();
                        }



                        int k=0,f=0;
                        for(int i=0;i<3;i++)
                        {
                            for(int j=0;j<3;j++)
                            {
                                k+=1;
                                if(i==2 && j==2)
                                {
                                    if(board[i][j]!=0)
                                    {
                                        f=1;
                                    }
                                }
                                else
                                {
                                    if(board[i][j]!=k)
                                    {
                                        f=1;
                                    }
                                }
                            }
                        }
                        // check for win
                        if (f==0)
                        {
                            //text.setText("won!!");
                            Save(count);
                            count =0;
                            Toast toast = Toast.makeText(MainActivity.this, "message", Toast.LENGTH_SHORT);
                            toast.setText("WIN");
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            //other setters
                            toast.show();
                            text.setText("0");
                        }
                        // prompt for move
                        else
                        {
                            //text.setText("next move...");
                        }


                    }
                });

        mybutton6.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        int x1=0,y1=0;
                        int x2=0,y2=0;
                        int tile;
                        if(mybutton6.getText().toString() == "_")
                        {
                            tile=0;
                        }
                        else
                        {
                            tile = Integer.parseInt(mybutton6.getText().toString());
                        }
                        for(int i=0;i<3;i++)
                        {
                            for(int j=0;j<3;j++)
                            {
                                if(board[i][j]==tile)
                                {
                                    x1=i;
                                    y1=j;
                                }
                                if(board[i][j]==0)
                                {
                                    x2=i;
                                    y2=j;
                                }
                            }
                        }
                        if(((y1==y2)&&((x1==x2+1)||(x1==x2-1)))|| ((x1==x2)&&((y1==y2+1)||(y1==y2-1))))
                        {
                            s=Integer.toString(tile);
                            mybutton6.setText("_");
                            count++;
                            s2=Integer.toString(count);
                            text.setText(s2);
                            if(x2==0)
                            {
                                if(y2==0)
                                    mybutton9.setText(s);
                                else if(y2==1)
                                    mybutton8.setText(s);
                                else
                                    mybutton7.setText(s);
                            }
                            else if(x2==1)
                            {
                                if(y2==0)
                                    mybutton6.setText(s);
                                else if(y2==1)
                                    mybutton5.setText(s);
                                else
                                    mybutton4.setText(s);
                            }
                            else
                            {
                                if(y2==0)
                                    mybutton3.setText(s);
                                else if(y2==1)
                                    mybutton2.setText(s);
                                else
                                    mybutton1.setText(s);
                            }
                            board[0][0]=Integer.parseInt(mybutton9.getText().toString());
                            board[0][1]=Integer.parseInt(mybutton8.getText().toString());
                            board[0][2]=Integer.parseInt(mybutton7.getText().toString());
                            board[1][0]=0;
                            board[1][1]=Integer.parseInt(mybutton5.getText().toString());
                            board[1][2]=Integer.parseInt(mybutton4.getText().toString());
                            board[2][0]=Integer.parseInt(mybutton3.getText().toString());
                            board[2][1]=Integer.parseInt(mybutton2.getText().toString());
                            board[2][2]=Integer.parseInt(mybutton1.getText().toString());
                        }
                        else
                        {
                            Toast toast = Toast.makeText(MainActivity.this, "message", Toast.LENGTH_SHORT);
                            toast.setText("Invalid Move");
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            //other setters
                            toast.show();
                        }



                        int k=0,f=0;
                        for(int i=0;i<3;i++)
                        {
                            for(int j=0;j<3;j++)
                            {
                                k+=1;
                                if(i==2 && j==2)
                                {
                                    if(board[i][j]!=0)
                                    {
                                        f=1;
                                    }
                                }
                                else
                                {
                                    if(board[i][j]!=k)
                                    {
                                        f=1;
                                    }
                                }
                            }
                        }
                        // check for win
                        if (f==0)
                        {
                            Toast toast = Toast.makeText(MainActivity.this, "message", Toast.LENGTH_SHORT);
                            toast.setText("WON");
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            //other setters
                            toast.show();
                            Save(count);
                            count=0;
                            text.setText("0");
                        }
                        // prompt for move
                        else
                        {
                            //text.setText("next move...");
                        }


                    }
                });
        mybutton5.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        int x1=0,y1=0;
                        int x2=0,y2=0;
                        int tile;
                        if(mybutton5.getText().toString() == "_")
                        {
                            tile=0;
                        }
                        else
                        {
                            tile = Integer.parseInt(mybutton5.getText().toString());
                        }
                        for(int i=0;i<3;i++)
                        {
                            for(int j=0;j<3;j++)
                            {
                                if(board[i][j]==tile)
                                {
                                    x1=i;
                                    y1=j;
                                }
                                if(board[i][j]==0)
                                {
                                    x2=i;
                                    y2=j;
                                }
                            }
                        }
                        if(((y1==y2)&&((x1==x2+1)||(x1==x2-1)))|| ((x1==x2)&&((y1==y2+1)||(y1==y2-1))))
                        {
                            s=Integer.toString(tile);
                            mybutton5.setText("_");
                            count++;
                            s2=Integer.toString(count);
                            text.setText(s2);
                            if(x2==0)
                            {
                                if(y2==0)
                                    mybutton9.setText(s);
                                else if(y2==1)
                                    mybutton8.setText(s);
                                else
                                    mybutton7.setText(s);
                            }
                            else if(x2==1)
                            {
                                if(y2==0)
                                    mybutton6.setText(s);
                                else if(y2==1)
                                    mybutton5.setText(s);
                                else
                                    mybutton4.setText(s);
                            }
                            else
                            {
                                if(y2==0)
                                    mybutton3.setText(s);
                                else if(y2==1)
                                    mybutton2.setText(s);
                                else
                                    mybutton1.setText(s);
                            }
                            board[0][0]=Integer.parseInt(mybutton9.getText().toString());
                            board[0][1]=Integer.parseInt(mybutton8.getText().toString());
                            board[0][2]=Integer.parseInt(mybutton7.getText().toString());
                            board[1][0]=Integer.parseInt(mybutton6.getText().toString());
                            board[1][1]=0;
                            board[1][2]=Integer.parseInt(mybutton4.getText().toString());
                            board[2][0]=Integer.parseInt(mybutton3.getText().toString());
                            board[2][1]=Integer.parseInt(mybutton2.getText().toString());
                            board[2][2]=Integer.parseInt(mybutton1.getText().toString());
                        }
                        else
                        {
                            Toast toast = Toast.makeText(MainActivity.this, "message", Toast.LENGTH_SHORT);
                            toast.setText("Invalid Move");
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            //other setters
                            toast.show();
                        }



                        int k=0,f=0;
                        for(int i=0;i<3;i++)
                        {
                            for(int j=0;j<3;j++)
                            {
                                k+=1;
                                if(i==2 && j==2)
                                {
                                    if(board[i][j]!=0)
                                    {
                                        f=1;
                                    }
                                }
                                else
                                {
                                    if(board[i][j]!=k)
                                    {
                                        f=1;
                                    }
                                }
                            }
                        }
                        // check for win
                        if (f==0)
                        {
                            Toast toast = Toast.makeText(MainActivity.this, "message", Toast.LENGTH_SHORT);
                            toast.setText("WON");
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            //other setters
                            toast.show();
                            Save(count);
                            count=0;
                            text.setText("0");
                        }
                        // prompt for move
                        else
                        {
                            //text.setText("next move...");
                        }


                    }
                });

        mybutton4.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        int x1=0,y1=0;
                        int x2=0,y2=0;
                        int tile;
                        if(mybutton4.getText().toString() == "_")
                        {
                            tile=0;
                        }
                        else
                        {
                            tile = Integer.parseInt(mybutton4.getText().toString());
                        }
                        for(int i=0;i<3;i++)
                        {
                            for(int j=0;j<3;j++)
                            {
                                if(board[i][j]==tile)
                                {
                                    x1=i;
                                    y1=j;
                                }
                                if(board[i][j]==0)
                                {
                                    x2=i;
                                    y2=j;
                                }
                            }
                        }
                        if(((y1==y2)&&((x1==x2+1)||(x1==x2-1))) || ((x1==x2)&&((y1==y2+1)||(y1==y2-1))))
                        {
                            s=Integer.toString(tile);
                            mybutton4.setText("_");
                            count++;
                            s2=Integer.toString(count);
                            text.setText(s2);
                            if(x2==0)
                            {
                                if(y2==0)
                                    mybutton9.setText(s);
                                else if(y2==1)
                                    mybutton8.setText(s);
                                else
                                    mybutton7.setText(s);
                            }
                            else if(x2==1)
                            {
                                if(y2==0)
                                    mybutton6.setText(s);
                                else if(y2==1)
                                    mybutton5.setText(s);
                                else
                                    mybutton4.setText(s);
                            }
                            else
                            {
                                if(y2==0)
                                    mybutton3.setText(s);
                                else if(y2==1)
                                    mybutton2.setText(s);
                                else
                                    mybutton1.setText(s);
                            }
                            board[0][0]=Integer.parseInt(mybutton9.getText().toString());
                            board[0][1]=Integer.parseInt(mybutton8.getText().toString());
                            board[0][2]=Integer.parseInt(mybutton7.getText().toString());
                            board[1][0]=Integer.parseInt(mybutton6.getText().toString());
                            board[1][1]=Integer.parseInt(mybutton5.getText().toString());
                            board[1][2]=0;
                            board[2][0]=Integer.parseInt(mybutton3.getText().toString());
                            board[2][1]=Integer.parseInt(mybutton2.getText().toString());
                            board[2][2]=Integer.parseInt(mybutton1.getText().toString());
                        }
                        else
                        {
                            //text.setText("invalid move..");
                            Toast toast = Toast.makeText(MainActivity.this, "message", Toast.LENGTH_SHORT);
                            toast.setText("Invalid Move");
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            //other setters
                            toast.show();
                        }



                        int k=0,f=0;
                        for(int i=0;i<3;i++)
                        {
                            for(int j=0;j<3;j++)
                            {
                                k+=1;
                                if(i==2 && j==2)
                                {
                                    if(board[i][j]!=0)
                                    {
                                        f=1;
                                    }
                                }
                                else
                                {
                                    if(board[i][j]!=k)
                                    {
                                        f=1;
                                    }
                                }
                            }
                        }
                        // check for win
                        if (f==0)
                        {
                            //text.setText("won!!");
                            Save(count);
                            Toast toast = Toast.makeText(MainActivity.this, "message", Toast.LENGTH_SHORT);
                            toast.setText("WON");
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            //other setters
                            toast.show();
                            count=0;
                            text.setText("0");
                        }
                        // prompt for move
                        else
                        {
                            //text.setText("next move...");
                        }


                    }
                });

        mybutton3.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        int x1=0,y1=0;
                        int x2=0,y2=0;
                        int tile;
                        if(mybutton3.getText().toString() == "_")
                        {
                            tile=0;
                        }
                        else
                        {
                            tile = Integer.parseInt(mybutton3.getText().toString());
                        }
                        for(int i=0;i<3;i++)
                        {
                            for(int j=0;j<3;j++)
                            {
                                if(board[i][j]==tile)
                                {
                                    x1=i;
                                    y1=j;
                                }
                                if(board[i][j]==0)
                                {
                                    x2=i;
                                    y2=j;
                                }
                            }
                        }
                        if(((y1==y2)&&((x1==x2+1)||(x1==x2-1)))|| ((x1==x2)&&((y1==y2+1)||(y1==y2-1))))
                        {
                            s=Integer.toString(tile);
                            mybutton3.setText("_");
                            count++;
                            s2=Integer.toString(count);
                            text.setText(s2);
                            if(x2==0)
                            {
                                if(y2==0)
                                    mybutton9.setText(s);
                                else if(y2==1)
                                    mybutton8.setText(s);
                                else
                                    mybutton7.setText(s);
                            }
                            else if(x2==1)
                            {
                                if(y2==0)
                                    mybutton6.setText(s);
                                else if(y2==1)
                                    mybutton5.setText(s);
                                else
                                    mybutton4.setText(s);
                            }
                            else
                            {
                                if(y2==0)
                                    mybutton3.setText(s);
                                else if(y2==1)
                                    mybutton2.setText(s);
                                else
                                    mybutton1.setText(s);
                            }
                            board[0][0]=Integer.parseInt(mybutton9.getText().toString());
                            board[0][1]=Integer.parseInt(mybutton8.getText().toString());
                            board[0][2]=Integer.parseInt(mybutton7.getText().toString());
                            board[1][0]=Integer.parseInt(mybutton6.getText().toString());
                            board[1][1]=Integer.parseInt(mybutton5.getText().toString());
                            board[1][2]=Integer.parseInt(mybutton4.getText().toString());
                            board[2][0]=0;
                            board[2][1]=Integer.parseInt(mybutton2.getText().toString());
                            board[2][2]=Integer.parseInt(mybutton1.getText().toString());
                        }
                        else
                        {
                            //text.setText("invalid move..");
                            Toast toast = Toast.makeText(MainActivity.this, "message", Toast.LENGTH_SHORT);
                            toast.setText("Invalid Move");
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            //other setters
                            toast.show();
                        }



                        int k=0,f=0;
                        for(int i=0;i<3;i++)
                        {
                            for(int j=0;j<3;j++)
                            {
                                k+=1;
                                if(i==2 && j==2)
                                {
                                    if(board[i][j]!=0)
                                    {
                                        f=1;
                                    }
                                }
                                else
                                {
                                    if(board[i][j]!=k)
                                    {
                                        f=1;
                                    }
                                }
                            }
                        }
                        // check for win
                        if (f==0)
                        {
                            //text.setText("won!!");
                            Save(count);
                            count=0;
                            Toast toast = Toast.makeText(MainActivity.this, "message", Toast.LENGTH_SHORT);
                            toast.setText("WON");
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            //other setters
                            toast.show();
                            text.setText("0");
                        }
                        // prompt for move
                        else
                        {
                            //text.setText("next move...");
                        }


                    }
                });

        mybutton2.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        int x1=0,y1=0;
                        int x2=0,y2=0;
                        int tile;
                        if(mybutton2.getText().toString() == "_")
                        {
                            tile=0;
                        }
                        else
                        {
                            tile = Integer.parseInt(mybutton2.getText().toString());
                        }
                        for(int i=0;i<3;i++)
                        {
                            for(int j=0;j<3;j++)
                            {
                                if(board[i][j]==tile)
                                {
                                    x1=i;
                                    y1=j;
                                }
                                if(board[i][j]==0)
                                {
                                    x2=i;
                                    y2=j;
                                }
                            }
                        }
                        if(((y1==y2)&&((x1==x2+1)||(x1==x2-1)))|| ((x1==x2)&&((y1==y2+1)||(y1==y2-1))))
                        {
                            s=Integer.toString(tile);
                            mybutton2.setText("_");
                            count++;
                            s2=Integer.toString(count);
                            text.setText(s2);
                            if(x2==0)
                            {
                                if(y2==0)
                                    mybutton9.setText(s);
                                else if(y2==1)
                                    mybutton8.setText(s);
                                else
                                    mybutton7.setText(s);
                            }
                            else if(x2==1)
                            {
                                if(y2==0)
                                    mybutton6.setText(s);
                                else if(y2==1)
                                    mybutton5.setText(s);
                                else
                                    mybutton4.setText(s);
                            }
                            else
                            {
                                if(y2==0)
                                    mybutton3.setText(s);
                                else if(y2==1)
                                    mybutton2.setText(s);
                                else
                                    mybutton1.setText(s);
                            }
                            board[0][0]=Integer.parseInt(mybutton9.getText().toString());
                            board[0][1]=Integer.parseInt(mybutton8.getText().toString());
                            board[0][2]=Integer.parseInt(mybutton7.getText().toString());
                            board[1][0]=Integer.parseInt(mybutton6.getText().toString());
                            board[1][1]=Integer.parseInt(mybutton5.getText().toString());
                            board[1][2]=Integer.parseInt(mybutton4.getText().toString());
                            board[2][0]=Integer.parseInt(mybutton3.getText().toString());
                            board[2][1]=0;
                            board[2][2]=Integer.parseInt(mybutton1.getText().toString());
                        }
                        else
                        {
                            Toast toast = Toast.makeText(MainActivity.this, "message", Toast.LENGTH_SHORT);
                            toast.setText("Invalid Move");
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            //other setters
                            toast.show();
                        }



                        int k=0,f=0;
                        for(int i=0;i<3;i++)
                        {
                            for(int j=0;j<3;j++)
                            {
                                k+=1;
                                if(i==2 && j==2)
                                {
                                    if(board[i][j]!=0)
                                    {
                                        f=1;
                                    }
                                }
                                else
                                {
                                    if(board[i][j]!=k)
                                    {
                                        f=1;
                                    }
                                }
                            }
                        }
                        // check for win
                        if (f==0)
                        {
                            //text.setText("won!!");
                            Save(count);
                            count=0;
                            Toast toast = Toast.makeText(MainActivity.this, "message", Toast.LENGTH_SHORT);
                            toast.setText("WON");
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            //other setters
                            toast.show();
                            text.setText("0");
                        }
                        // prompt for move
                        else
                        {
                            //text.setText("next move...");
                        }


                    }
                });


        mybutton1.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        int x1=0,y1=0;
                        int x2=0,y2=0;
                        int tile;
                        if(mybutton1.getText().toString() == "_")
                        {
                            tile=0;
                        }
                        else
                        {
                            tile = Integer.parseInt(mybutton1.getText().toString());
                        }
                        for(int i=0;i<3;i++)
                        {
                            for(int j=0;j<3;j++)
                            {
                                if(board[i][j]==tile)
                                {
                                    x1=i;
                                    y1=j;
                                }
                                if(board[i][j]==0)
                                {
                                    x2=i;
                                    y2=j;
                                }
                            }
                        }
                        if(((y1==y2)&&((x1==x2+1)||(x1==x2-1)))|| ((x1==x2)&&((y1==y2+1)||(y1==y2-1))))
                        {
                            s=Integer.toString(tile);
                            mybutton1.setText("_");
                            count++;
                            s2=Integer.toString(count);
                            text.setText(s2);
                            if(x2==0)
                            {
                                if(y2==0)
                                    mybutton9.setText(s);
                                else if(y2==1)
                                    mybutton8.setText(s);
                                else
                                    mybutton7.setText(s);
                            }
                            else if(x2==1)
                            {
                                if(y2==0)
                                    mybutton6.setText(s);
                                else if(y2==1)
                                    mybutton5.setText(s);
                                else
                                    mybutton4.setText(s);
                            }
                            else
                            {
                                if(y2==0)
                                    mybutton3.setText(s);
                                else if(y2==1)
                                    mybutton2.setText(s);
                                else
                                    mybutton1.setText(s);
                            }
                            board[0][0]=Integer.parseInt(mybutton9.getText().toString());
                            board[0][1]=Integer.parseInt(mybutton8.getText().toString());
                            board[0][2]=Integer.parseInt(mybutton7.getText().toString());
                            board[1][0]=Integer.parseInt(mybutton6.getText().toString());
                            board[1][1]=Integer.parseInt(mybutton5.getText().toString());
                            board[1][2]=Integer.parseInt(mybutton4.getText().toString());
                            board[2][0]=Integer.parseInt(mybutton3.getText().toString());
                            board[2][1]=Integer.parseInt(mybutton2.getText().toString());
                            board[2][2]=0;

                        }
                        else
                        {
                            Toast toast = Toast.makeText(MainActivity.this, "message", Toast.LENGTH_SHORT);
                            toast.setText("Invalid Move");
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            //other setters
                            toast.show();
                        }


                        int k=0,f=0;
                        for(int i=0;i<3;i++)
                        {
                            for(int j=0;j<3;j++)
                            {
                                k+=1;
                                if(i==2 && j==2)
                                {
                                    if(board[i][j]!=0)
                                    {
                                        f=1;
                                    }
                                }
                                else
                                {
                                    if(board[i][j]!=k)
                                    {
                                        f=1;
                                    }
                                }
                            }
                        }
                        // check for win
                        if (f==0)
                        {
                            //text.setText("won!!");
                            Save(count);
                            count=0;
                            Toast toast = Toast.makeText(MainActivity.this, "message", Toast.LENGTH_SHORT);
                            toast.setText("WON");
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            //other setters
                            toast.show();
                            text.setText("0");
                        }
                        // prompt for move
                        else
                        {
                            //text.setText("next move...");
                        }


                    }
                });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void Save(int moves)
    {
        String s=Integer.toString(moves);
        Toast toast = Toast.makeText(MainActivity.this, "message", Toast.LENGTH_SHORT);
        toast.setText("YOUR SCORE : " + " " + s);
        toast.setGravity(Gravity.CENTER, 0, 0);
        //other setters
        toast.show();
        LoadInt();
        int hs=Entry.hscore;
        if(moves<hs || hs==0)
        {
            Entry.hscore=moves;
            SaveInt("key", moves);
            HighScore.hscore.setText(Integer.toString(Entry.hscore));
        }
        Intent i = new Intent(getApplicationContext(), Score.class);
        i.putExtra("keyy",Integer.toString(moves));
        startActivity(i);
    }
    public void SaveInt(String key, int value){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();

    }
    public void LoadInt(){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Entry.hscore = sharedPreferences.getInt("key", 0);
    }
    @Override
    public void onBackPressed() {
        // your code.
        Intent i=new Intent(MainActivity.this,Entry.class);
        startActivity(i);
    }
}
