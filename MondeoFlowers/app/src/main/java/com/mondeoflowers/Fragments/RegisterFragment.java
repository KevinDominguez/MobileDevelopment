package com.mondeoflowers.Fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mondeoflowers.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

    private Button regButton;
    private EditText nameText;
    private EditText numberText;
    private EditText mailText;
    private EditText postCodeText;
    private EditText adresText;
    private Button btnRegister;

    SharedPreferences uSettings;
    SharedPreferences.Editor editor;




    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);

    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        uSettings = getActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE);
        editor = uSettings.edit();


        nameText = (EditText) getView().findViewById(R.id.editTextName);
        nameText.setText(uSettings.getString("UserName", null));
        numberText = (EditText) getView().findViewById(R.id.editTextNumber);
        numberText.setText(uSettings.getString("UserNumber", null));
        mailText = (EditText) getView().findViewById(R.id.editTextMail);
        mailText.setText(uSettings.getString("UserMail", null));
        postCodeText = (EditText) getView().findViewById(R.id.editTextPostCode);
        postCodeText.setText(uSettings.getString("UserPostCode", null));
        adresText = (EditText) getView().findViewById(R.id.editTextAdres);
        adresText.setText(uSettings.getString("UserAdres", null));

        btnRegister = (Button) getActivity().findViewById(R.id.buttonRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString("UserName", nameText.getText().toString());
                editor.putString("UserNumber", numberText.getText().toString());
                editor.putString("UserMail", mailText.getText().toString());
                editor.putString("UserPostCode", postCodeText.getText().toString());
                editor.putString("UserAdres", adresText.getText().toString());
                editor.apply();
            }
        });
    }
}