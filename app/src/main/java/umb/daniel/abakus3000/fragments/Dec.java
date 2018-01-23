package umb.daniel.abakus3000.fragments;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import umb.daniel.abakus3000.mainActivities.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Dec.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Dec#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Dec extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View view;

    private OnFragmentInteractionListener mListener;

    public Dec() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Dec.
     */
    // TODO: Rename and change types and number of parameters
    public static Dec newInstance(String param1, String param2) {
        Dec fragment = new Dec();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dec, container, false);

        addOnClickListeners();

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String text) {
        if (mListener != null) {
            mListener.decOnFragmentInteraction(text);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void decOnFragmentInteraction(String text);
    }

    private void addOnClickListeners(){
        final Button btn_sedem = view.findViewById(R.id.btn_sedem);
        final Button btn_osem = view.findViewById(R.id.btn_osem);
        final Button btn_devat = view.findViewById(R.id.btn_devat);
        final Button btn_styri = view.findViewById(R.id.btn_styri);
        final Button btn_pat = view.findViewById(R.id.btn_pat);
        final Button btn_sest = view.findViewById(R.id.btn_sest);
        final Button btn_jeden = view.findViewById(R.id.btn_jedna);
        final Button btn_dva = view.findViewById(R.id.btn_dva);
        final Button btn_tri = view.findViewById(R.id.btn_tri);
        final Button btn_nula = view.findViewById(R.id.btn_nula);
        final Button btn_clear = view.findViewById(R.id.btn_clear);

        btn_sedem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonPressed(btn_sedem.getText().toString());
            }
        });

        btn_osem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonPressed(btn_osem.getText().toString());
            }
        });

        btn_devat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonPressed(btn_devat.getText().toString());
            }
        });

        btn_styri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonPressed(btn_styri.getText().toString());
            }
        });

        btn_pat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonPressed(btn_pat.getText().toString());
            }
        });

        btn_sest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonPressed(btn_sest.getText().toString());
            }
        });

        btn_jeden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonPressed(btn_jeden.getText().toString());
            }
        });

        btn_dva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonPressed(btn_dva.getText().toString());
            }
        });

        btn_tri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonPressed(btn_tri.getText().toString());
            }
        });

        btn_nula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonPressed(btn_nula.getText().toString());
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonPressed(btn_clear.getText().toString());
            }
        });
    }

}
