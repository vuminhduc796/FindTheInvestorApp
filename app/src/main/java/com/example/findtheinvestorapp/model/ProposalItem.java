package com.example.findtheinvestorapp.model;

import java.io.Serializable;

public class ProposalItem implements Serializable {
    private String dateProposaled;
    private String proposalID;
    private String proposalTitle;
    private String proposalDetailedDescription;
    private String proposalTag;
    private String placeOfOrigin;
    private String proposalCondition;
    private String proposalType;
    private String investmentAmount;
    private String proposalUserEmail;
    private int proposalInternalRating;

    public ProposalItem(String dateProposaled, String proposalID, String proposalTitle, String proposalDetailedDescription, String proposalTag, String placeOfOrigin, String proposalCondition, String proposalType, String investmentAmount, String proposalUserEmail, int proposalInternalRating) {
        this.dateProposaled = dateProposaled;
        this.proposalID = proposalID;
        this.proposalTitle = proposalTitle;
        this.proposalDetailedDescription = proposalDetailedDescription;
        this.proposalTag = proposalTag;
        this.placeOfOrigin = placeOfOrigin;
        this.proposalCondition = proposalCondition;
        this.proposalType = proposalType;
        this.investmentAmount = investmentAmount;
        this.proposalUserEmail = proposalUserEmail;
        this.proposalInternalRating = proposalInternalRating;
    }

    public String getDateProposaled() {
        return dateProposaled;
    }

    public void setDateProposaled(String dateProposaled) {
        this.dateProposaled = dateProposaled;
    }

    public String getProposalID() {
        return proposalID;
    }

    public void setProposalID(String proposalID) {
        this.proposalID = proposalID;
    }

    public String getProposalTitle() {
        return proposalTitle;
    }

    public void setProposalTitle(String proposalTitle) {
        this.proposalTitle = proposalTitle;
    }

    public String getProposalDetailedDescription() {
        return proposalDetailedDescription;
    }

    public void setProposalDetailedDescription(String proposalDetailedDescription) {
        this.proposalDetailedDescription = proposalDetailedDescription;
    }

    public String getProposalTag() {
        return proposalTag;
    }

    public void setProposalTag(String proposalTag) {
        this.proposalTag = proposalTag;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public String getProposalCondition() {
        return proposalCondition;
    }

    public void setProposalCondition(String proposalCondition) {
        this.proposalCondition = proposalCondition;
    }

    public String getProposalType() {
        return proposalType;
    }

    public void setProposalType(String proposalType) {
        this.proposalType = proposalType;
    }

    public String getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(String investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public String getProposalUserEmail() {
        return proposalUserEmail;
    }

    public void setProposalUserEmail(String proposalUserEmail) {
        this.proposalUserEmail = proposalUserEmail;
    }

    public int getProposalInternalRating() {
        return proposalInternalRating;
    }

    public void setProposalInternalRating(int proposalInternalRating) {
        this.proposalInternalRating = proposalInternalRating;
    }
}
