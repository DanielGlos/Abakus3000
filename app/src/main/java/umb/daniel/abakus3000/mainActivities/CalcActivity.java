package umb.daniel.abakus3000.mainActivities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.text.DecimalFormat;

import umb.daniel.abakus3000.mainActivities.databinding.ActivityCalcBinding;

public class CalcActivity extends AppCompatActivity {

    private ActivityCalcBinding binding;

    private double valueOne = Double.NaN;
    private double valueTwo;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;
    private boolean numLast = false;

    DecimalFormat decimalFormat = new DecimalFormat("#.##########");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_calc);
        addOnClickHandlers();
    }

    private void addOnClickHandlers(){
        binding.btnSedem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.txtField.setText(binding.txtField.getText() + "7");
                numLast = true;
            }
        });

        binding.btnOsem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.txtField.setText(binding.txtField.getText() + "8");
                numLast = true;
            }
        });

        binding.btnDevat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.txtField.setText(binding.txtField.getText() + "9");
                numLast = true;
            }
        });

        binding.btnStyri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.txtField.setText(binding.txtField.getText() + "4");
                numLast = true;
            }
        });

        binding.btnPat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.txtField.setText(binding.txtField.getText() + "5");
                numLast = true;
            }
        });

        binding.btnSest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.txtField.setText(binding.txtField.getText() + "6");
                numLast = true;
            }
        });

        binding.btnJedna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.txtField.setText(binding.txtField.getText() + "1");
                numLast = true;
            }
        });

        binding.btnDva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.txtField.setText(binding.txtField.getText() + "2");
                numLast = true;
            }
        });

        binding.btnTri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.txtField.setText(binding.txtField.getText() + "3");
                numLast = true;
            }
        });

        binding.btnNula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.txtField.setText(binding.txtField.getText() + "0");
                numLast = true;
            }
        });

        binding.btnCiarka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.txtField.setText(binding.txtField.getText() + ".");
                numLast = false;
            }
        });

        binding.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numLast) {
                    calculate();
                    CURRENT_ACTION = ADDITION;
                    binding.lblInfo.setText(decimalFormat.format(valueOne) + "+");
                    binding.txtField.setText(null);
                }
            }
        });

        binding.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numLast) {
                    calculate();
                    CURRENT_ACTION = SUBTRACTION;
                    binding.lblInfo.setText(decimalFormat.format(valueOne) + "-");
                    binding.txtField.setText(null);
                }
            }
        });

        binding.btnKrat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numLast) {
                    calculate();
                    CURRENT_ACTION = MULTIPLICATION;
                    binding.lblInfo.setText(decimalFormat.format(valueOne) + "*");
                    binding.txtField.setText(null);
                }
            }
        });

        binding.btnDelene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numLast) {
                    calculate();
                    CURRENT_ACTION = DIVISION;
                    binding.lblInfo.setText(decimalFormat.format(valueOne) + "/");
                    binding.txtField.setText(null);
                }
            }
        });

        binding.btnRovnasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numLast) {
                    calculate();
                    binding.lblInfo.setText(binding.lblInfo.getText().toString() +
                            decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne));
                    valueOne = Double.NaN;
                    CURRENT_ACTION = '0';
                    numLast = false;
                }
            }
        });

        binding.btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.txtField.setText(null);
                binding.lblInfo.setText(null);
                valueOne = Double.NaN;
                valueTwo = Double.NaN;
                numLast = false;
            }
        });

        binding.txtField.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }

    private void calculate() {
        if(!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(binding.txtField.getText().toString());
            binding.txtField.setText(null);

            if(CURRENT_ACTION == ADDITION)
                valueOne = this.valueOne + valueTwo;
            else if(CURRENT_ACTION == SUBTRACTION)
                valueOne = this.valueOne - valueTwo;
            else if(CURRENT_ACTION == MULTIPLICATION)
                valueOne = this.valueOne * valueTwo;
            else if(CURRENT_ACTION == DIVISION)
                valueOne = this.valueOne / valueTwo;
            numLast = true;
        }
        else {
            try {
                valueOne = Double.parseDouble(binding.txtField.getText().toString());
                numLast = false;
            }
            catch (Exception e){}
        }
    }


}
