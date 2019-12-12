package com.sectors.model;

public class UsersDTO {

    private long id;
    private String userName;
    private String password;
    private String mobileNumber;
    private String userType;
    private String email;
    private String confirmed;

//    private List<TrainingsDTO> trainingsDTOList;
//    public List<TrainingsDTO> getTrainingsDTOList() {
//        return trainingsDTOList;
//    }
//    public void setTrainingsDTOList(List<TrainingsDTO> trainingsDTOList) {
//        this.trainingsDTOList = trainingsDTOList;
//        if(trainingsDTOList != null && trainingsDTOList.size() > 0) {
//            setTrainingsDelivered(String.valueOf(trainingsDTOList.size()));
//        }
//    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
        //BeanUtils
    }
}
