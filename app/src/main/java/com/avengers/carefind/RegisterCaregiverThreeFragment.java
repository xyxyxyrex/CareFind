package com.avengers.carefind;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

public class RegisterCaregiverThreeFragment extends Fragment {

    private CaregiverViewModel caregiverViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register_caregiver_three, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Use ViewModelProvider to get the shared ViewModel instance
        caregiverViewModel = new ViewModelProvider(requireActivity()).get(CaregiverViewModel.class);

        EditText email = view.findViewById(R.id.etEmail);
        EditText username = view.findViewById(R.id.etUsername);
        EditText password = view.findViewById(R.id.etPassword);

        view.findViewById(R.id.buttonRegister).setOnClickListener(v -> {
            // Set values in the shared ViewModel
            caregiverViewModel.setEmail(email.getText().toString());
            caregiverViewModel.setUsername(username.getText().toString());
            caregiverViewModel.setPassword(password.getText().toString());

            // Navigate to the confirmation fragment
            NavHostFragment.findNavController(this)
                    .navigate(R.id.action_registerCaregiverThreeFragment_to_caregiverConfirmationFragment);
        });
    }
}
