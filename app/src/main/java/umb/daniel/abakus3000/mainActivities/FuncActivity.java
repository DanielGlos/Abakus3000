package umb.daniel.abakus3000.mainActivities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import umb.daniel.abakus3000.mainActivities.databinding.ActivityFuncBinding;
import umb.daniel.abakus3000.mainActivities.functionsActivities.*;

public class FuncActivity extends AppCompatActivity {

    ActivityFuncBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_func);
        addOnClickListeners();
    }


    private void addOnClickListeners()
    {
        binding.btnFunc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(FuncActivity.this, KvadActivity.class);
                FuncActivity.this.startActivity(myIntent);
            }
        });

        binding.btnFunc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(FuncActivity.this, GoniomActivity.class);
                FuncActivity.this.startActivity(myIntent);
            }
        });

        binding.btnFunc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(FuncActivity.this, HranActivity.class);
                FuncActivity.this.startActivity(myIntent);
            }
        });

        binding.btnFunc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(FuncActivity.this, ValActivity.class);
                FuncActivity.this.startActivity(myIntent);
            }
        });

        binding.btnFunc5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(FuncActivity.this, GulaActivity.class);
                FuncActivity.this.startActivity(myIntent);
            }
        });
    }
}
