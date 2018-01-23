package umb.daniel.abakus3000.mainActivities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import umb.daniel.abakus3000.Decimal;
import umb.daniel.abakus3000.mainActivities.databinding.ActivityConvertBinding;


public class ConvertActivity extends AppCompatActivity implements Decimal.OnFragmentInteractionListener {

    ActivityConvertBinding binding;

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
        System.out.println(text);
    }

}
