package umb.daniel.abakus3000;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import umb.daniel.abakus3000.mainActivities.CalcActivity;
import umb.daniel.abakus3000.mainActivities.ConvertActivity;
import umb.daniel.abakus3000.mainActivities.FuncActivity;
import umb.daniel.abakus3000.mainActivities.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void btn_calculator_click(View view) {
        Intent myIntent = new Intent(MainActivity.this, CalcActivity.class);
        MainActivity.this.startActivity(myIntent);
    }

    public void btn_convert_click(View view) {
        Intent myIntent = new Intent(MainActivity.this, ConvertActivity.class);
        MainActivity.this.startActivity(myIntent);
    }

    public void btn_functions_click(View view) {
        Intent myIntent = new Intent(MainActivity.this, FuncActivity.class);
        MainActivity.this.startActivity(myIntent);
    }
}
