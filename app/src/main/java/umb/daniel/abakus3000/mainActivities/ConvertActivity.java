package umb.daniel.abakus3000.mainActivities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import umb.daniel.abakus3000.fragments.*;
import umb.daniel.abakus3000.mainActivities.databinding.ActivityConvertBinding;


public class ConvertActivity extends AppCompatActivity implements Dec.OnFragmentInteractionListener,
        Hex.OnFragmentInteractionListener, Bin.OnFragmentInteractionListener{

    private ActivityConvertBinding binding;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    enum base
    {
        DEC,
        BIN,
        HEX
    }

    private base baseSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_convert);

        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        Dec fragment = new Dec();
        fragmentTransaction.add(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

        addEditTextListeners();
    }

    @Override
    public void decOnFragmentInteraction(String text) {
        if (text.equals("CE"))
        {
            binding.txtDec.setText(null);
            binding.txtBin.setText(null);
            binding.txtHex.setText(null);
        }else if(baseSelected == base.DEC){
            binding.txtDec.setText(binding.txtDec.getText() + text);
            binding.txtBin.setText(Long.toBinaryString(Long.parseLong(binding.txtDec.getText().toString())));
            binding.txtHex.setText(Long.toHexString(Long.parseLong(binding.txtDec.getText().toString())));
        }
    }

    @Override
    public void hexOnFragmentInteraction(String text) {
        if (text.equals("CE"))
        {
            binding.txtDec.setText(null);
            binding.txtBin.setText(null);
            binding.txtHex.setText(null);
        }else if(baseSelected == base.HEX){
//            binding.txtHex.setText(binding.txtHex.getText() + text);
//            binding.txtBin.setText(Long.toBinaryString(Long.parseLong(binding.txtDec.getText().toString())));
//            binding.txtHex.setText(Long.toHexString(Long.parseLong(binding.txtDec.getText().toString())));
        }
    }

    @Override
    public void binOnFragmentInteraction(String text) {
        if (text.equals("CE"))
        {
            binding.txtDec.setText(null);
            binding.txtBin.setText(null);
            binding.txtHex.setText(null);
        }else if(baseSelected == base.BIN){
            binding.txtBin.setText(binding.txtBin.getText() + text);
            binding.txtDec.setText(Long.toString(Long.parseLong(binding.txtBin.getText().toString(), 2)));
            binding.txtHex.setText(Long.toString(Long.parseLong(binding.txtDec.getText().toString(),16)));
        }
    }

    private void addEditTextListeners()
    {
        binding.txtDec.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    baseSelected = base.DEC;
                }
            }
        });

        binding.txtBin.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    baseSelected = base.BIN;
                }
            }
        });

        binding.txtHex.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    baseSelected = base.HEX;
                }
            }
        });

        binding.txtDec.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                binding.txtDec.requestFocus();
                fragmentTransaction = getFragmentManager().beginTransaction();
                Dec fragment = new Dec();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
                return true;
            }
        });
        binding.txtBin.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                binding.txtBin.requestFocus();
                fragmentTransaction = getFragmentManager().beginTransaction();
                Bin fragment = new Bin();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
                return true;
            }
        });
        binding.txtHex.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                binding.txtHex.requestFocus();
                fragmentTransaction = getFragmentManager().beginTransaction();
                Hex fragment = new Hex();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
                return true;
            }
        });
    }
}
