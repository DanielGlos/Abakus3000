package umb.daniel.abakus3000.mainActivities.functionsActivities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import umb.daniel.abakus3000.mainActivities.R;
import umb.daniel.abakus3000.mainActivities.databinding.ActivityKvadBinding;

public class KvadActivity extends AppCompatActivity {

    private ActivityKvadBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_kvad);

        binding.btnRataj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quadParse(binding.input.getText().toString().trim());
            }
        });
    }

    private double koef(String str, String regex) {
        Pattern patt = Pattern.compile(regex);
        Matcher match = patt.matcher(str);
        String temp = "+0";
        double value = 0;
        while(match.find()){
            temp = match.group(1);
            value = value + Double.parseDouble(temp);
        }
        return (temp.length() == 1) ? (value + 1) : value;
    }

    private void quadParse(String arg) {
        String str = ("+" + arg).replaceAll("\\s", "");

        double a1 = koef(str, "([+-][0-9]*)x\\^2");
        double b1 = koef(str, "([+-][0-9]*)x(?!\\^)");
        double c1 = koef(str, "([+-][0-9]+)(?!x)");
        System.out.println("Values are a: " + a1 + " b: " + b1 + " c: " + c1);
    }
}
