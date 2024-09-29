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

public class RegisterClientOneFragment extends Fragment {

    private ClientViewModel clientViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register_client_one, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        clientViewModel = new ViewModelProvider(requireActivity()).get(ClientViewModel.class);

        EditText fullName = view.findViewById(R.id.etFullName);
        EditText dob = view.findViewById(R.id.etDOB);
        Spinner gender = view.findViewById(R.id.spinnerGender);
        EditText phoneNumber = view.findViewById(R.id.etPhoneNumber);
        EditText landline = view.findViewById(R.id.etLandline);
        EditText addressLine1 = view.findViewById(R.id.etAddressLine1);
        EditText addressLine2 = view.findViewById(R.id.etAddressLine2);

        // Setting up the ArrayAdapter for the gender Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.gender_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(adapter);

        view.findViewById(R.id.buttonNext).setOnClickListener(v -> {
            // Save data to ViewModel
            clientViewModel.setFullName(fullName.getText().toString());
            clientViewModel.setDob(dob.getText().toString());
            clientViewModel.setGender(gender.getSelectedItem().toString());
            clientViewModel.setPhoneNumber(phoneNumber.getText().toString());
            clientViewModel.setLandline(landline.getText().toString());
            clientViewModel.setAddressLine1(addressLine1.getText().toString());
            clientViewModel.setAddressLine2(addressLine2.getText().toString());

            // Navigate to the next fragment
            NavHostFragment.findNavController(this)
                    .navigate(R.id.action_registerClientOneFragment_to_registerClientTwoFragment);
        });
    }
}
