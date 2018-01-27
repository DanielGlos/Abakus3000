package umb.daniel.abakus3000.mainActivities.functionsActivities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AlertDialog;
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
                calculate(binding.input.getText().toString().trim());
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

    private void calculate(String arg) {
        String str = ("+" + arg).replaceAll("\\s", "");

        double a = koef(str, "([+-][0-9]*)x\\^2");
        double b = koef(str, "([+-][0-9]*)x(?!\\^)");
        double c = koef(str, "([+-][0-9]+)(?!x)");

        double temp1 = Math.sqrt(b * b - 4 * a * c);

        double root1 = (-b +  temp1) / (2*a) ;
        double root2 = (-b -  temp1) / (2*a) ;

        showResults(root1, root2);
    }

    private void showResults(double root1, double root2)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (Double.isNaN(root1) || Double.isInfinite(root2))
            builder.setMessage(R.string.lbl_nemaRiesenie);
        else
            builder.setMessage(String.format("x1 = %f\nx2 = %f", root1, root2));
        builder.setTitle(R.string.dialog_title);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
