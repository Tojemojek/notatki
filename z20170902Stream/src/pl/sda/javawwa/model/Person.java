package pl.sda.javawwa.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String surname;
    private String addressStreet;
    private Integer addressStreetNumber;
    private String addressCity;
    private String zipCode;
    private LocalDate birthDate;
    private String bloodType;
    private Double weightInKg;
    private Double heightInCm;
    private List<String> telNo;

    public Person(String name, String surname, String addressStreet, Integer addressStreetNumber, String addressCity, String zipCode, LocalDate birthDate, String bloodType, Double weightInKg, Double heightInCm, List<String> telNo) {
        this.name = name;
        this.surname = surname;
        this.addressStreet = addressStreet;
        this.addressStreetNumber = addressStreetNumber;
        this.addressCity = addressCity;
        this.zipCode = zipCode;
        this.birthDate = birthDate;
        this.bloodType = bloodType;
        this.weightInKg = weightInKg;
        this.heightInCm = heightInCm;
        this.telNo = telNo;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public Integer getAddressStreetNumber() {
        return addressStreetNumber;
    }

    public void setAddressStreetNumber(Integer addressStreetNumber) {
        this.addressStreetNumber = addressStreetNumber;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public Double getWeightInKg() {
        return weightInKg;
    }

    public void setWeightInKg(Double weightInKg) {
        this.weightInKg = weightInKg;
    }

    public Double getHeightInCm() {
        return heightInCm;
    }

    public void setHeightInCm(Double heightInCm) {
        this.heightInCm = heightInCm;
    }

    public List<String> getTelNo() {
        return telNo;
    }

    public void setTelNo(List<String> telNo) {
        this.telNo = telNo;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", addressStreet='" + addressStreet + '\'' +
                ", addressStreetNumber=" + addressStreetNumber +
                ", addressCity='" + addressCity + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", birthDate=" + birthDate +
                ", bloodType='" + bloodType + '\'' +
                ", weightInKg=" + weightInKg +
                ", heightInCm=" + heightInCm +
                ", telNo=" + telNo +
                '}';
    }
}

