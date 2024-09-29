package com.avengers.carefind;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;


public class RegisterClientThreeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register_client_three, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        EditText email = view.findViewById(R.id.etEmail);
        EditText username = view.findViewById(R.id.etUsername);
        EditText password = view.findViewById(R.id.etPassword);
        CheckBox termsCheckbox = view.findViewById(R.id.checkboxTerms);

        view.findViewById(R.id.buttonRegister).setOnClickListener(v -> {
            // Handle registration logic and save to ViewModel
            // Navigate to confirmation fragment
            NavHostFragment.findNavController(this)
                    .navigate(R.id.action_registerClientThreeFragment_to_confirmationFragment);
        });
    }
}
