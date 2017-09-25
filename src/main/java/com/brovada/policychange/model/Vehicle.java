/*
 * Copyright (c) brovada Technologies, Inc. All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * brovada Technologies, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with brovada.
 */
package com.brovada.policychange.model;

import java.util.List;

/**
 * The type Vehicle.
 */
public class Vehicle {

    /**
     * The Manufacturer.
     */
    private String manufacturer;

    /**
     * The Model.
     */
    private String model;

    /**
     * The Model year.
     */
    private String modelYear;

    /**
     * The Body type.
     */
    private String bodyType;

    /**
     * The Cost new amt.
     */
    private String costNewAmt;

    /**
     * The Annual distance.
     */
    private String annualDistance;

    /**
     * The Purchase date.
     */
    private String purchaseDate;

    /**
     * The Vin.
     */
    private String vin;

    /**
     * The Veh use cd.
     */
    private String vehUseCd;

    /**
     * The Engine type.
     */
    private String engineType;

    /**
     * The Rate class cd.
     */
    private String rateClassCd;

    /**
     * The Coverages.
     */
    private List<Coverage> coverages;

    /**
     * The Question answers.
     */
    private List<QuestionAnswer> questionAnswers;

    /**
     * Instantiates a new Vehicle.
     */
    public Vehicle() {
    }

    /**
     * Gets coverages.
     *
     * @return the coverages
     */
    public List<Coverage> getCoverages() {
        return coverages;
    }

    /**
     * Sets coverages.
     *
     * @param coverages the coverages
     */
    public void setCoverages(List<Coverage> coverages) {
        this.coverages = coverages;
    }

    /**
     * Gets question answers.
     *
     * @return the question answers
     */
    public List<QuestionAnswer> getQuestionAnswers() {
        return questionAnswers;
    }

    /**
     * Sets question answers.
     *
     * @param questionAnswers the question answers
     */
    public void setQuestionAnswers(List<QuestionAnswer> questionAnswers) {
        this.questionAnswers = questionAnswers;
    }

    /**
     * Gets manufacturer.
     *
     * @return the manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Sets manufacturer.
     *
     * @param manufacturer the manufacturer
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Gets model.
     *
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets model.
     *
     * @param model the model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets model year.
     *
     * @return the model year
     */
    public String getModelYear() {
        return modelYear;
    }

    /**
     * Sets model year.
     *
     * @param modelYear the model year
     */
    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    /**
     * Gets body type.
     *
     * @return the body type
     */
    public String getBodyType() {
        return bodyType;
    }

    /**
     * Sets body type.
     *
     * @param bodyType the body type
     */
    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    /**
     * Gets cost new amt.
     *
     * @return the cost new amt
     */
    public String getCostNewAmt() {
        return costNewAmt;
    }

    /**
     * Sets cost new amt.
     *
     * @param costNewAmt the cost new amt
     */
    public void setCostNewAmt(String costNewAmt) {
        this.costNewAmt = costNewAmt;
    }

    /**
     * Gets annual distance.
     *
     * @return the annual distance
     */
    public String getAnnualDistance() {
        return annualDistance;
    }

    /**
     * Sets annual distance.
     *
     * @param annualDistance the annual distance
     */
    public void setAnnualDistance(String annualDistance) {
        this.annualDistance = annualDistance;
    }

    /**
     * Gets purchase date.
     *
     * @return the purchase date
     */
    public String getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * Sets purchase date.
     *
     * @param purchaseDate the purchase date
     */
    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    /**
     * Gets vin.
     *
     * @return the vin
     */
    public String getVin() {
        return vin;
    }

    /**
     * Sets vin.
     *
     * @param vin the vin
     */
    public void setVin(String vin) {
        this.vin = vin;
    }

    /**
     * Gets veh use cd.
     *
     * @return the veh use cd
     */
    public String getVehUseCd() {
        return vehUseCd;
    }

    /**
     * Sets veh use cd.
     *
     * @param vehUseCd the veh use cd
     */
    public void setVehUseCd(String vehUseCd) {
        this.vehUseCd = vehUseCd;
    }

    /**
     * Gets engine type.
     *
     * @return the engine type
     */
    public String getEngineType() {
        return engineType;
    }

    /**
     * Sets engine type.
     *
     * @param engineType the engine type
     */
    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    /**
     * Gets rate class cd.
     *
     * @return the rate class cd
     */
    public String getRateClassCd() {
        return rateClassCd;
    }

    /**
     * Sets rate class cd.
     *
     * @param rateClassCd the rate class cd
     */
    public void setRateClassCd(String rateClassCd) {
        this.rateClassCd = rateClassCd;
    }
}
