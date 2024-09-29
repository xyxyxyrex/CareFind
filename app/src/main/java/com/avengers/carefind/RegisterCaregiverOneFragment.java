package com.avengers.carefind;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

public class RegisterCaregiverOneFragment extends Fragment {

    private CaregiverViewModel caregiverViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register_caregiver_one, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Get the shared ViewModel instance
        caregiverViewModel = new ViewModelProvider(requireActivity()).get(CaregiverViewModel.class);

        EditText fullName = view.findViewById(R.id.etFullName);
        EditText dob = view.findViewById(R.id.etDOB);
        Spinner gender = view.findViewById(R.id.spinnerGender);
        EditText phoneNumber = view.findViewById(R.id.etPhoneNumber);
        EditText landline = view.findViewById(R.id.etLandline);
        EditText addressLine1 = view.findViewById(R.id.etAddressLine1);
        EditText addressLine2 = view.findViewById(R.id.etAddressLine2);

        // Use requireContext to avoid null context
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.gender_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(adapter);

        view.findViewById(R.id.buttonNext).setOnClickListener(v -> {
            // Set data in ViewModel
            caregiverViewModel.setFullName(fullName.getText().toString());
            caregiverViewModel.setDob(dob.getText().toString());

            // Set gender from Spinner with null check
            Object selectedGender = gender.getSelectedItem();
            caregiverViewModel.setGender(selectedGender != null ? selectedGender.toString() : "");

            caregiverViewModel.setPhoneNumber(phoneNumber.getText().toString());
            caregiverViewModel.setLandline(landline.getText().toString());
            caregiverViewModel.setAddressLine1(addressLine1.getText().toString());
            caregiverViewModel.setAddressLine2(addressLine2.getText().toString());

            // Navigate to next fragment
            NavHostFragment.findNavController(this)
                    .navigate(R.id.action_registerCaregiverOneFragment_to_registerCaregiverTwoFragment);
        });
    }
}
