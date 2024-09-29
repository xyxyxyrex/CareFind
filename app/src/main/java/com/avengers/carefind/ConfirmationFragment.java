package com.avengers.carefind;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class ConfirmationFragment extends Fragment {

    private TextView textViewConfirmationMessage;
    private TextView textViewDetails;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_confirmation, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        textViewConfirmationMessage = view.findViewById(R.id.textViewConfirmationMessage);
        textViewDetails = view.findViewById(R.id.textViewDetails); // Initialize the new TextView

        // Get shared instance of the ViewModel
        ClientViewModel clientViewModel = new ViewModelProvider(requireActivity()).get(ClientViewModel.class);

        // Set a confirmation message
        textViewConfirmationMessage.setText("Registration Successful! Your details have been saved.");

        // Retrieve user details from the ViewModel
        String fullName = clientViewModel.getFullName().getValue();
        String dob = clientViewModel.getDob().getValue();
        String gender = clientViewModel.getGender().getValue();
        String phoneNumber = clientViewModel.getPhoneNumber().getValue();
        String landline = clientViewModel.getLandline().getValue();
        String addressLine1 = clientViewModel.getAddressLine1().getValue();
        String addressLine2 = clientViewModel.getAddressLine2().getValue();
        String conditions = clientViewModel.getConditions().getValue();
        String age = clientViewModel.getAge().getValue();
        String patientGender = clientViewModel.getPatientGender().getValue();
        String tasks = clientViewModel.getTasks().getValue();
        String budget = clientViewModel.getBudget().getValue();
        String email = clientViewModel.getEmail().getValue();
        String username = clientViewModel.getUsername().getValue();
        Boolean termsAccepted = clientViewModel.getTermsAccepted().getValue();
        String caregiverType = clientViewModel.getCaregiverType().getValue();

        // Construct a detailed string
        StringBuilder details = new StringBuilder();
        details.append("Full Name: ").append(fullName).append("\n");
        details.append("Date of Birth: ").append(dob).append("\n");
        details.append("Gender: ").append(gender).append("\n");
        details.append("Phone Number: ").append(phoneNumber).append("\n");
        details.append("Landline: ").append(landline).append("\n");
        details.append("Address Line 1: ").append(addressLine1).append("\n");
        details.append("Address Line 2: ").append(addressLine2).append("\n");
        details.append("Conditions: ").append(conditions).append("\n");
        details.append("Age: ").append(age).append("\n");
        details.append("Patient Gender: ").append(patientGender).append("\n");
        details.append("Tasks: ").append(tasks).append("\n");
        details.append("Budget: ").append(budget).append("\n");
        details.append("Email: ").append(email).append("\n");
        details.append("Username: ").append(username).append("\n");
        details.append("Terms Accepted: ").append(termsAccepted != null && termsAccepted ? "Yes" : "No").append("\n");
        details.append("Caregiver Type: ").append(caregiverType);

        textViewDetails.setText(details.toString()); // Display the details

        // Set up the button to redirect to LoginActivity
        Button buttonBackToLogin = view.findViewById(R.id.buttonBackToLogin);
        buttonBackToLogin.setOnClickListener(v -> {
            // Redirect to LoginActivity
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
            // Optionally finish the current activity to prevent going back
            getActivity().finish();
        });
    }
}
