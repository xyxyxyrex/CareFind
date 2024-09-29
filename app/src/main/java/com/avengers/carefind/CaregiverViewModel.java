package com.avengers.carefind;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CaregiverViewModel extends ViewModel {
    private final MutableLiveData<String> fullName = new MutableLiveData<>();
    private final MutableLiveData<String> dob = new MutableLiveData<>();
    private final MutableLiveData<String> gender = new MutableLiveData<>();
    private final MutableLiveData<String> phoneNumber = new MutableLiveData<>();
    private final MutableLiveData<String> landline = new MutableLiveData<>();
    private final MutableLiveData<String> addressLine1 = new MutableLiveData<>();
    private final MutableLiveData<String> addressLine2 = new MutableLiveData<>();
    private final MutableLiveData<String> yearsOfExperience = new MutableLiveData<>();
    private final MutableLiveData<String> expertise = new MutableLiveData<>(); // Keep expertise field
    private final MutableLiveData<String> uploadedDocuments = new MutableLiveData<>();
    private final MutableLiveData<String> email = new MutableLiveData<>();
    private final MutableLiveData<String> username = new MutableLiveData<>();
    private final MutableLiveData<String> password = new MutableLiveData<>();
    private final MutableLiveData<Boolean> termsAccepted = new MutableLiveData<>(); // Add termsAccepted field

    // Basic Info Getters and Setters
    public LiveData<String> getFullName() {
        return fullName;
    }

    public void setFullName(String name) {
        fullName.setValue(name);
    }

    public LiveData<String> getDob() {
        return dob;
    }

    public void setDob(String dateOfBirth) {
        dob.setValue(dateOfBirth);
    }

    public LiveData<String> getGender() {
        return gender;
    }

    public void setGender(String genderValue) {
        gender.setValue(genderValue);
    }

    public LiveData<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phone) {
        phoneNumber.setValue(phone);
    }

    public LiveData<String> getLandline() {
        return landline;
    }

    public void setLandline(String line) {
        landline.setValue(line);
    }

    public LiveData<String> getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String address1) {
        addressLine1.setValue(address1);
    }

    public LiveData<String> getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String address2) {
        addressLine2.setValue(address2);
    }

    // Experience and Document Info Getters and Setters
    public LiveData<String> getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(String experience) {
        yearsOfExperience.setValue(experience);
    }

    public LiveData<String> getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertiseValue) {
        expertise.setValue(expertiseValue);
    }

    public LiveData<String> getUploadedDocuments() {
        return uploadedDocuments;
    }

    public void setUploadedDocuments(String documents) {
        uploadedDocuments.setValue(documents);
    }

    // Login Info Getters and Setters
    public LiveData<String> getEmail() {
        return email;
    }

    public void setEmail(String emailValue) {
        email.setValue(emailValue);
    }

    public LiveData<String> getUsername() {
        return username;
    }

    public void setUsername(String usernameValue) {
        username.setValue(usernameValue);
    }

    public LiveData<String> getPassword() {
        return password;
    }

    public void setPassword(String passwordValue) {
        password.setValue(passwordValue);
    }

    // Terms Accepted Getters and Setters
    public LiveData<Boolean> getTermsAccepted() {
        return termsAccepted;
    }

    public void setTermsAccepted(Boolean accepted) {
        termsAccepted.setValue(accepted);
    }
}
