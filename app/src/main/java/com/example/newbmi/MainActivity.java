package com.example.newbmi;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private ImageView imagee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        height = findViewById(R.id.ed_height);
        weight = findViewById(R.id.ed_weight);
        imagee = findViewById(R.id.imagee);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void bmi (View view){
        float h = Float.parseFloat(height.getText().toString());
        float w = Float.parseFloat(weight.getText().toString());
        float bmi = w / (h*h);
        imagee.setVisibility(View.VISIBLE);
        imagee.setAlpha(1.0f);
        if(bmi<18.5){
            imagee.setImageResource(R.drawable.small);
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("BMI")
                    .setMessage("You bmi is :" +bmi+" 體重過輕")
                    .setPositiveButton("OK", null)
                    .show();
            Toast.makeText(MainActivity.this,"要多吃一點啊 長胖胖才可愛", Toast.LENGTH_LONG).show();
        }else if(bmi >= 18.5 && bmi < 24){
            imagee.setImageResource(R.drawable.ok);
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("BMI")
                    .setMessage("You bmi is :" +bmi+" 體重正常")
                    .setPositiveButton("OK", null)
                    .show();
            Toast.makeText(MainActivity.this,"體重hen正常", Toast.LENGTH_LONG).show();
        }else {
            imagee.setImageResource(R.drawable.fatt);
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("BMI")
                    .setMessage("You bmi is :" +bmi+" 體重過重")
                    .setPositiveButton("OK", null)
                    .show();
            Toast.makeText(MainActivity.this, "小胖子該減肥啦", Toast.LENGTH_LONG).show();
        }
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
