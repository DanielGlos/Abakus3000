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
import umb.daniel.abakus3000.mainActivities.databinding.ActivityHranBinding;

public class HranActivity extends AppCompatActivity {


    ActivityHranBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_hran);

        binding.btnRataj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate(binding.input.getText().toString().trim());
            }
        });
    }

    private void calculate(String input) {

        double a,b,c;
        double objem, povrch;
        List<String> values = Arrays.asList(input.split(","));
        a = Double.parseDouble(values.get(0));
        b = Double.parseDouble(values.get(1));
        c = Double.parseDouble(values.get(2));

        objem = (a*b) * c;
        povrch = 2*(a*b) + ((2*a)+(2*b)) * c;

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
