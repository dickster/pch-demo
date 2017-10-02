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

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Auto policy.
 */
@Document
@XmlRootElement(name="AutoPolicy")
@XmlAccessorType(XmlAccessType.FIELD)
public class AutoPolicy {

    /**
     * The Policy number.
     */
    @Id
    @XmlElement(required = true)
    private String policyNumber;

    /**
     * The Policy effective date.
     */
    @XmlElement(required = true)
    private String policyEffectiveDate;

    /**
     * The Insureds.
     */
    private List<Insured> insureds = new ArrayList<>();

    /**
     * The Drivers.
     */
    private List<Driver> drivers = new ArrayList<>();

    /**
     * The Vehicles.
     */
    private List<Vehicle> vehicles = new ArrayList<>();

    /**
     * The Locations.
     */
    private List<Location> locations = new ArrayList<>();

    /**
     * Instantiates a new Auto policy.
     */
    public AutoPolicy() {
    }

    /**
     * Instantiates a new Auto policy.
     *
     * @param policyNumber the policy number
     */
    public AutoPolicy(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    /**
     * Gets locations.
     *
     * @return the locations
     */
    public List<Location> getLocations() {
        return locations;
    }

    /**
     * Sets locations.
     *
     * @param locations the locations
     */
    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    /**
     * Gets policy number.
     *
     * @return the policy number
     */
    public String getPolicyNumber() {
        return this.policyNumber;
    }

    /**
     * Sets policy number.
     *
     * @param policyNumber the policy number
     */
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    /**
     * Gets policy effective date.
     *
     * @return the policy effective date
     */
    public String getPolicyEffectiveDate() {
        return policyEffectiveDate;
    }

    /**
     * Sets policy effective date.
     *
     * @param policyEffectiveDate the policy effective date
     */
    public void setPolicyEffectiveDate(String policyEffectiveDate) {
        this.policyEffectiveDate = policyEffectiveDate;
    }

    /**
     * Gets insureds.
     *
     * @return the insureds
     */
    public List<Insured> getInsureds() {
        return insureds;
    }

    /**
     * Sets insureds.
     *
     * @param insureds the insureds
     */
    public void setInsureds(List<Insured> insureds) {
        this.insureds = insureds;
    }

    /**
     * Gets drivers.
     *
     * @return the drivers
     */
    public List<Driver> getDrivers() {
        return drivers;
    }

    /**
     * Sets drivers.
     *
     * @param drivers the drivers
     */
    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    /**
     * Gets vehicles.
     *
     * @return the vehicles
     */
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * Sets vehicles.
     *
     * @param vehicles the vehicles
     */
    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
