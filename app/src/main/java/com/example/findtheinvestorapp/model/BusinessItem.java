package com.example.findtheinvestorapp.model;

import java.io.Serializable;
import java.util.List;

public class BusinessItem implements Serializable {
    private String facilityOverview;
    private String trackableAsset;
    private List<String> interest;
    private List<String> industryType;
    private List<String> productsAndServiceTags;
    private int completePercentage;
    private List<String> otherImages;
    private String _id;
    private String firstName;
    private String lastName;
    private String companyName;
    private String country;
    private String userRole;
    private String businessEstablishment;
    private String industryStage;
    private String businessLine;
    private String businessHighlight;
    private String productsAndServices;
    private String averageMonthlySalesNumber;
    private String averageMonthlySalesCurrentlu;
    private String email;
    private String mainImage;
    private List<Employee> employeeList;
    private List<IntangibleAsset> intangibleAssetList;
    private List<Ebit> ebitList;
    private List<Roi> roiList;
    private List<Asset> assetList;

    public class Employee implements Serializable{
        private String yearNumber;
        private int numberOfEmployees;

        public Employee(String yearNumber, int numberOfEmployees) {
            this.yearNumber = yearNumber;
            this.numberOfEmployees = numberOfEmployees;
        }

        public String getYearNumber() {
            return yearNumber;
        }

        public void setYearNumber(String yearNumber) {
            this.yearNumber = yearNumber;
        }

        public int getNumberOfEmployees() {
            return numberOfEmployees;
        }

        public void setNumberOfEmployees(int numberOfEmployees) {
            this.numberOfEmployees = numberOfEmployees;
        }
    }
    public class IntangibleAsset implements Serializable{
        private String assetsName;
        private int marketValue;
        private int bookValue;

        public IntangibleAsset(String assetsName, int marketValue, int bookValue) {
            this.assetsName = assetsName;
            this.marketValue = marketValue;
            this.bookValue = bookValue;
        }

        public String getAssetsName() {
            return assetsName;
        }

        public void setAssetsName(String assetsName) {
            this.assetsName = assetsName;
        }

        public int getMarketValue() {
            return marketValue;
        }

        public void setMarketValue(int marketValue) {
            this.marketValue = marketValue;
        }

        public int getBookValue() {
            return bookValue;
        }

        public void setBookValue(int bookValue) {
            this.bookValue = bookValue;
        }
    }
    public class Ebit implements Serializable{
        private String currency;
        private int earningAmount;
        private String yearNumber;

        public Ebit(String currency, int earningAmount, String yearNumber) {
            this.currency = currency;
            this.earningAmount = earningAmount;
            this.yearNumber = yearNumber;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public int getEarningAmount() {
            return earningAmount;
        }

        public void setEarningAmount(int earningAmount) {
            this.earningAmount = earningAmount;
        }

        public String getYearNumber() {
            return yearNumber;
        }

        public void setYearNumber(String yearNumber) {
            this.yearNumber = yearNumber;
        }
    }
    public class Roi implements Serializable{
        private float roiPercentage;
        private String yearNumber;

        public Roi(float roiPercentage, String yearNumber) {
            this.roiPercentage = roiPercentage;
            this.yearNumber = yearNumber;
        }

        public float getRoiPercentage() {
            return roiPercentage;
        }

        public void setRoiPercentage(float roiPercentage) {
            this.roiPercentage = roiPercentage;
        }

        public String getYearNumber() {
            return yearNumber;
        }

        public void setYearNumber(String yearNumber) {
            this.yearNumber = yearNumber;
        }
    }
    public class Asset implements Serializable{
        private int bookValue;
        private int marketValue;
        private String assetType;
        private String assetsName;

        public Asset(int bookValue, int marketValue, String assetType, String assetsName) {
            this.bookValue = bookValue;
            this.marketValue = marketValue;
            this.assetType = assetType;
            this.assetsName = assetsName;
        }

        public String getAssetsName() {
            return assetsName;
        }

        public void setAssetsName(String assetsName) {
            this.assetsName = assetsName;
        }

        public int getBookValue() {
            return bookValue;
        }

        public void setBookValue(int bookValue) {
            this.bookValue = bookValue;
        }

        public int getMarketValue() {
            return marketValue;
        }

        public void setMarketValue(int marketValue) {
            this.marketValue = marketValue;
        }

        public String getAssetType() {
            return assetType;
        }

        public void setAssetType(String assetType) {
            this.assetType = assetType;
        }
    }

    public BusinessItem(String facilityOverview, String trackableAsset, List<String> interest, List<String> industryType, List<String> productsAndServiceTags, int completePercentage, List<String> otherImages, String _id, String firstName, String lastName, String companyName, String country, String userRole, String businessEstablishment, String industryStage, String businessLine, String businessHighlight, String productsAndServices, String averageMonthlySalesNumber, String averageMonthlySalesCurrentlu, String email, String mainImage, List<Employee> employeeList, List<IntangibleAsset> intangibleAssetList, List<Ebit> ebitList, List<Roi> roiList, List<Asset> assetList) {
        this.facilityOverview = facilityOverview;
        this.trackableAsset = trackableAsset;
        this.interest = interest;
        this.industryType = industryType;
        this.productsAndServiceTags = productsAndServiceTags;
        this.completePercentage = completePercentage;
        this.otherImages = otherImages;
        this._id = _id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.country = country;
        this.userRole = userRole;
        this.businessEstablishment = businessEstablishment;
        this.industryStage = industryStage;
        this.businessLine = businessLine;
        this.businessHighlight = businessHighlight;
        this.productsAndServices = productsAndServices;
        this.averageMonthlySalesNumber = averageMonthlySalesNumber;
        this.averageMonthlySalesCurrentlu = averageMonthlySalesCurrentlu;
        this.email = email;
        this.mainImage = mainImage;
        this.employeeList = employeeList;
        this.intangibleAssetList = intangibleAssetList;
        this.ebitList = ebitList;
        this.roiList = roiList;
        this.assetList = assetList;

    }

    public List<String> getInterest() {
        return interest;
    }
    public String getStringInterest(){
        StringBuilder strbul=new StringBuilder();
        List<String> interests = getInterest();
        for(String str : interests)
        {
            strbul.append(str);
            //for adding comma between elements
            strbul.append(" ,");
        }
        //just for removing last comma
        if(strbul.length()>0) {
            strbul.setLength(strbul.length() - 1);
        }
        String str=strbul.toString();
        return str;
    }

    public void setInterest(List<String> interest) {
        this.interest = interest;
    }

    public String getStringIndustryType() {
        StringBuilder strbul=new StringBuilder();
        List<String> industry = getIndustryType();
        for(String str : industry)
        {
            strbul.append(str);
            //for adding comma between elements
            strbul.append(" ,");
        }
        //just for removing last comma
        if(strbul.length()>0) {
            strbul.setLength(strbul.length() - 1);
        }
        String str=strbul.toString();
        return str;
    }

    public List<String> getIndustryType() {
        return industryType;
    }

    public void setIndustryType(List<String> industryType) {
        this.industryType = industryType;
    }

    public List<String> getProductsAndServiceTags() {
        return productsAndServiceTags;
    }

    public String getStringProductsAndServiceTags() {
        StringBuilder strbul=new StringBuilder();
        List<String> tags = getProductsAndServiceTags();
        for(String str : tags)
        {
            strbul.append(str);
            //for adding comma between elements
            strbul.append(" ,");
        }
        //just for removing last comma
        if(strbul.length()>0) {
            strbul.setLength(strbul.length() - 1);
        }
        String str=strbul.toString();
        return str;
    }

    public void setProductsAndServiceTags(List<String> productsAndServiceTags) {
        this.productsAndServiceTags = productsAndServiceTags;
    }

    public int getCompletePercentage() {
        return completePercentage;
    }

    public void setCompletePercentage(int completePercentage) {
        this.completePercentage = completePercentage;
    }

    public List<String> getOtherImages() {
        return otherImages;
    }

    public void setOtherImages(List<String> otherImages) {
        this.otherImages = otherImages;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getBusinessEstablishment() {
        return businessEstablishment;
    }

    public void setBusinessEstablishment(String businessEstablishment) {
        this.businessEstablishment = businessEstablishment;
    }

    public String getIndustryStage() {
        return industryStage;
    }

    public void setIndustryStage(String industryStage) {
        this.industryStage = industryStage;
    }

    public String getBusinessLine() {
        return businessLine;
    }

    public void setBusinessLine(String businessLine) {
        this.businessLine = businessLine;
    }

    public String getBusinessHighlight() {
        return businessHighlight;
    }

    public void setBusinessHighlight(String businessHighlight) {
        this.businessHighlight = businessHighlight;
    }

    public String getProductsAndServices() {
        return productsAndServices;
    }

    public void setProductsAndServices(String productsAndServices) {
        this.productsAndServices = productsAndServices;
    }

    public String getAverageMonthlySalesNumber() {
        return averageMonthlySalesNumber;
    }

    public void setAverageMonthlySalesNumber(String averageMonthlySalesNumber) {
        this.averageMonthlySalesNumber = averageMonthlySalesNumber;
    }

    public String getAverageMonthlySalesCurrentlu() {
        return averageMonthlySalesCurrentlu;
    }

    public void setAverageMonthlySalesCurrentlu(String averageMonthlySalesCurrentlu) {
        this.averageMonthlySalesCurrentlu = averageMonthlySalesCurrentlu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<IntangibleAsset> getIntangibleAssetList() {
        return intangibleAssetList;
    }

    public void setIntangibleAssetList(List<IntangibleAsset> intangibleAssetList) {
        this.intangibleAssetList = intangibleAssetList;
    }

    public List<Ebit> getEbitList() {
        return ebitList;
    }

    public void setEbitList(List<Ebit> ebitList) {
        this.ebitList = ebitList;
    }

    public List<Roi> getRoiList() {
        return roiList;
    }

    public void setRoiList(List<Roi> roiList) {
        this.roiList = roiList;
    }

    public List<Asset> getAssetList() {
        return assetList;
    }

    public void setAssetList(List<Asset> assetList) {
        this.assetList = assetList;
    }

    public String getTrackableAsset() {
        return trackableAsset;
    }

    public void setTrackableAsset(String trackableAsset) {
        this.trackableAsset = trackableAsset;
    }

    public String getFacilityOverview() {
        return facilityOverview;
    }

    public void setFacilityOverview(String facilityOverview) {
        this.facilityOverview = facilityOverview;
    }
}

