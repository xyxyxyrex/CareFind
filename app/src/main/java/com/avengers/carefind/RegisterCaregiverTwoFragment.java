package com.avengers.carefind;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;

public class RegisterCaregiverTwoFragment extends Fragment {

    private CaregiverViewModel caregiverViewModel;
    private ArrayList<Uri> documentUris = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register_caregiver_two, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Get the shared ViewModel instance
        caregiverViewModel = new ViewModelProvider(requireActivity()).get(CaregiverViewModel.class);

        EditText yearsOfExperience = view.findViewById(R.id.etYearsOfExperience);
        Spinner expertiseSpinner = view.findViewById(R.id.spinnerExpertise);
        Button uploadDocumentsButton = view.findViewById(R.id.buttonUploadDocuments);
        Button nextButton = view.findViewById(R.id.buttonNext);

        // Setting up the ArrayAdapter for the expertise Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.expertise_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        expertiseSpinner.setAdapter(adapter);

        // Setting up the document upload button
        uploadDocumentsButton.setOnClickListener(v -> openFilePicker());

        nextButton.setOnClickListener(v -> {
            // Set data in ViewModel
            caregiverViewModel.setYearsOfExperience(yearsOfExperience.getText().toString());
            caregiverViewModel.setExpertise(expertiseSpinner.getSelectedItem().toString());
            caregiverViewModel.setUploadedDocuments(documentUris.toString()); // Convert URIs to string representation

            // Navigate to the next fragment
            NavHostFragment.findNavController(this)
                    .navigate(R.id.action_registerCaregiverTwoFragment_to_registerCaregiverThreeFragment);
        });
    }

    // Method to open file picker
    private void openFilePicker() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*"); // Allow any type of file
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true); // Allow multiple file selection
        documentPickerLauncher.launch(intent);
    }

    // Activity Result Launcher for file picker
    private final ActivityResultLauncher<Intent> documentPickerLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == -1 && result.getData() != null) {
                    if (result.getData().getClipData() != null) {
                        // Multiple documents selected
                        int count = result.getData().getClipData().getItemCount();
                        for (int i = 0; i < count; i++) {
                            Uri documentUri = result.getData().getClipData().getItemAt(i).getUri();
                            documentUris.add(documentUri); // Save document URIs
                        }
                    } else if (result.getData().getData() != null) {
                        // Single document selected
                        Uri documentUri = result.getData().getData();
                        documentUris.add(documentUri); // Save document URI
                    }
                }
            });
}
