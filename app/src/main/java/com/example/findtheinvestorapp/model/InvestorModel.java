package com.example.findtheinvestorapp.model;

public class InvestorModel {

    private String companyDescription;
    private String companyName;
    private String mainImage;
    private String backgroundImage;

    public InvestorModel(String companyDescription, String companyName, String mainImage, String backgroundImage) {
        this.companyDescription = companyDescription;
        this.companyName = companyName;
        this.mainImage = mainImage;
        this.backgroundImage = backgroundImage;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }
}

