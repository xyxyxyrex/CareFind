package com.avengers.carefind;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ClientViewModel extends ViewModel {
    private final MutableLiveData<String> fullName = new MutableLiveData<>();
    private final MutableLiveData<String> dob = new MutableLiveData<>();
    private final MutableLiveData<String> gender = new MutableLiveData<>();
    private final MutableLiveData<String> phoneNumber = new MutableLiveData<>();
    private final MutableLiveData<String> landline = new MutableLiveData<>();
    private final MutableLiveData<String> addressLine1 = new MutableLiveData<>();
    private final MutableLiveData<String> addressLine2 = new MutableLiveData<>();
    private final MutableLiveData<String> conditions = new MutableLiveData<>();
    private final MutableLiveData<String> age = new MutableLiveData<>();
    private final MutableLiveData<String> patientGender = new MutableLiveData<>();
    private final MutableLiveData<String> tasks = new MutableLiveData<>();
    private final MutableLiveData<String> budget = new MutableLiveData<>();
    private final MutableLiveData<String> caregiverType = new MutableLiveData<>();
    private final MutableLiveData<String> email = new MutableLiveData<>();
    private final MutableLiveData<String> username = new MutableLiveData<>();
    private final MutableLiveData<String> password = new MutableLiveData<>();
    private final MutableLiveData<Boolean> termsAccepted = new MutableLiveData<>();

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

    public LiveData<String> getConditions() {
        return conditions;
    }

    public void setConditions(String conditionsValue) {
        conditions.setValue(conditionsValue);
    }

    public LiveData<String> getAge() {
        return age;
    }

    public void setAge(String ageValue) {
        age.setValue(ageValue);
    }

    public LiveData<String> getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGenderValue) {
        patientGender.setValue(patientGenderValue);
    }

    public LiveData<String> getTasks() {
        return tasks;
    }

    public void setTasks(String task) {
        tasks.setValue(task);
    }

    public LiveData<String> getBudget() {
        return budget;
    }

    public void setBudget(String budgetValue) {
        budget.setValue(budgetValue);
    }

    public LiveData<String> getCaregiverType() {
        return caregiverType;
    }

    public void setCaregiverType(String caregiverTypeValue) {
        caregiverType.setValue(caregiverTypeValue);
    }

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

    public LiveData<Boolean> isTermsAccepted() {
        return termsAccepted;
    }

    public LiveData<Boolean> getTermsAccepted() {
        return termsAccepted; // Add this getter
    }

    public void setTermsAccepted(Boolean accepted) {
        termsAccepted.setValue(accepted);
    }
}
