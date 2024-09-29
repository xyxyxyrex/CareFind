package com.avengers.carefind;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.lifecycle.ViewModelProvider;

public class RegisterClientTwoFragment extends Fragment {

    private EditText etConditions, etAge, etGender, etTasks, etBudget;
    private Spinner spinnerCaregiverType;
    private ClientViewModel clientViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register_client_two, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        clientViewModel = new ViewModelProvider(requireActivity()).get(ClientViewModel.class);

        etConditions = view.findViewById(R.id.etConditions);
        etAge = view.findViewById(R.id.etAge);
        etGender = view.findViewById(R.id.etGender); // Declare etGender here
        etTasks = view.findViewById(R.id.etTasks);
        etBudget = view.findViewById(R.id.etBudget);
        spinnerCaregiverType = view.findViewById(R.id.spinnerCaregiverType);

        // Setting up the ArrayAdapter for Caregiver Type Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.caregiver_type_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCaregiverType.setAdapter(adapter);

        Button buttonNext = view.findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(v -> {
            // Set values in ViewModel
            clientViewModel.setConditions(etConditions.getText().toString());
            clientViewModel.setAge(etAge.getText().toString());
            clientViewModel.setTasks(etTasks.getText().toString());
            clientViewModel.setTasks(etBudget.getText().toString());
            clientViewModel.setGender(etGender.getText().toString()); // Set gender here
            clientViewModel.setCaregiverType(spinnerCaregiverType.getSelectedItem().toString());

            // Navigate to the next fragment
            NavHostFragment.findNavController(this)
                    .navigate(R.id.action_registerClientTwoFragment_to_registerClientThreeFragment);
        });
    }
}
