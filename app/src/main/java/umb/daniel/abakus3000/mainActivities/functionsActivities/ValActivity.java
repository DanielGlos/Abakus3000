package umb.daniel.abakus3000.mainActivities.functionsActivities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import umb.daniel.abakus3000.mainActivities.R;
import umb.daniel.abakus3000.mainActivities.databinding.ActivityValBinding;

public class ValActivity extends AppCompatActivity {

    ActivityValBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_val);

        binding.btnRataj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate(binding.input.getText().toString().trim());
            }
        });
    }

    private void calculate(String input) {

        double r,v;
        double objem, povrch;
        List<String> values = Arrays.asList(input.split(","));
        r = Double.parseDouble(values.get(0));
        v = Double.parseDouble(values.get(1));

        objem = 3.14159*Math.pow(r,2);
        povrch = 2*3.14159*r*(v+r);

        if (objem != Double.NaN)
        {
            binding.txtPovrch.setText(String.format(Locale.getDefault(),"Povrch: %f", povrch));
            binding.txtObjem.setText(String.format(Locale.getDefault(),"Objem: %f", objem));
        }else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.lbl_zlyVstup).setTitle(R.string.lbl_chybaVstupu);
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
}
