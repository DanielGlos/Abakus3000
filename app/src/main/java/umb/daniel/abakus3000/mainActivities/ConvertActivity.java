package umb.daniel.abakus3000.mainActivities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import umb.daniel.abakus3000.Decimal;
import umb.daniel.abakus3000.mainActivities.databinding.ActivityConvertBinding;


public class ConvertActivity extends AppCompatActivity implements Decimal.OnFragmentInteractionListener {

    ActivityConvertBinding binding;
    StringBuffer buf = new StringBuffer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_convert);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Decimal fragment = new Decimal();
        fragmentTransaction.add(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onFragmentInteraction(String text) {
        if (text.equals("C"))
        {
            binding.txtDec.setText(null);
            binding.txtBin.setText(null);
            binding.txtHex.setText(null);
        }else {
            binding.txtDec.setText(binding.txtDec.getText() + text);
            convertToBin(Integer.parseInt(binding.txtDec.getText().toString()));
            binding.txtBin.setText(buf);
            buf = new StringBuffer();
        }

    }

    private void convertToBin(int number)
    {
        int remainder;

        if (number <= 1) {
            buf.append(number);
            return;
        }

        remainder = number %2;
        convertToBin(number >> 1);
        buf.append(remainder);
    }

}
