package com.example.rafaelsmartin.listview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by Rafael S Martin on 27/05/2017.
 */

public class MainActivity extends AppCompatActivity {

    Button button, button2, button3, button4;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(context, ActivityList.class);
                startActivity(i);
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(context, ActivityGrid.class);
                startActivity(i);
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(context, ActivityListCardView.class);
                startActivity(i);
            }
        });

        button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(context, ActivityRecyclerListCardView.class);
                startActivity(i);
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



}
