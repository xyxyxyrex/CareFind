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

public class CaregiverConfirmationFragment extends Fragment {

    private TextView textViewConfirmationMessage;
    private TextView textViewDetails;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_caregiver_confirmation, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        textViewConfirmationMessage = view.findViewById(R.id.textViewConfirmationMessage);
        textViewDetails = view.findViewById(R.id.textViewDetails);


        CaregiverViewModel caregiverViewModel = new ViewModelProvider(requireActivity()).get(CaregiverViewModel.class);


        textViewConfirmationMessage.setText("Registration Successful! Your details have been saved.");


        String fullName = caregiverViewModel.getFullName().getValue();
        String dob = caregiverViewModel.getDob().getValue();
        String gender = caregiverViewModel.getGender().getValue();
        String phoneNumber = caregiverViewModel.getPhoneNumber().getValue();
        String landline = caregiverViewModel.getLandline().getValue();
        String addressLine1 = caregiverViewModel.getAddressLine1().getValue();
        String addressLine2 = caregiverViewModel.getAddressLine2().getValue();
        String yearsOfExperience = caregiverViewModel.getYearsOfExperience().getValue();
        String expertise = caregiverViewModel.getExpertise().getValue();
        String email = caregiverViewModel.getEmail().getValue();
        String username = caregiverViewModel.getUsername().getValue();
        Boolean termsAccepted = caregiverViewModel.getTermsAccepted().getValue();

        // Construct a detailed string
        StringBuilder details = new StringBuilder();
        details.append("Full Name: ").append(fullName).append("\n");
        details.append("Date of Birth: ").append(dob).append("\n");
        details.append("Gender: ").append(gender).append("\n");
        details.append("Phone Number: ").append(phoneNumber).append("\n");
        details.append("Landline: ").append(landline).append("\n");
        details.append("Address Line 1: ").append(addressLine1).append("\n");
        details.append("Address Line 2: ").append(addressLine2).append("\n");
        details.append("Years of Experience: ").append(yearsOfExperience).append("\n");
        details.append("Expertise: ").append(expertise).append("\n");
        details.append("Email: ").append(email).append("\n");
        details.append("Username: ").append(username).append("\n");
        details.append("Terms Accepted: ").append(termsAccepted != null && termsAccepted ? "Yes" : "No");

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
