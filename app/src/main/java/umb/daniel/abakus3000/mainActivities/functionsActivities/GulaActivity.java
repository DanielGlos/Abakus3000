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
import umb.daniel.abakus3000.mainActivities.databinding.ActivityGulaBinding;

public class GulaActivity extends AppCompatActivity {

    ActivityGulaBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_gula   );

        binding.btnRataj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate(Double.parseDouble(binding.input.getText().toString().trim()));
            }
        });
    }

    private void calculate(Double polomer) {

        double objem, povrch;

        objem = (4.0/3.0)*3.14159*Math.pow(polomer,3);
        povrch = 4*3.14159*Math.pow(polomer,2);

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
