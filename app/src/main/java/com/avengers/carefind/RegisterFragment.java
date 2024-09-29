package com.avengers.carefind;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class RegisterFragment extends Fragment {

    public RegisterFragment() {
        super(R.layout.fragment_register);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnClient = view.findViewById(R.id.btnClient);
        Button btnCaregiver = view.findViewById(R.id.btnCaregiver);

        btnClient.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_registerFragment_to_registerClientOneFragment));

        btnCaregiver.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_registerFragment_to_registerCaregiverOneFragment));
    }
}