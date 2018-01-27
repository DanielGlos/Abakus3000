package umb.daniel.abakus3000.mainActivities.functionsActivities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Locale;

import umb.daniel.abakus3000.mainActivities.R;
import umb.daniel.abakus3000.mainActivities.databinding.ActivityGoniomBinding;

public class GoniomActivity extends AppCompatActivity {

    ActivityGoniomBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_goniom);

        binding.btnRataj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate(Double.parseDouble(binding.input.getText().toString()));
            }
        });
    }

    private void calculate(Double uhol) {
        binding.txtSin.setText(String.format(Locale.getDefault(),"Sin = %f", Math.sin(uhol)));
        binding.txtCos.setText(String.format(Locale.getDefault(),"Cos = %f", Math.cos(uhol)));
        binding.txtTan.setText(String.format(Locale.getDefault(),"Tan= %f", Math.tan(uhol)));
    }


}
