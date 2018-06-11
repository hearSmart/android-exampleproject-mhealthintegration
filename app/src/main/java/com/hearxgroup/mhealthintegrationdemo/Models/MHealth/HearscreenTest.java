/*
 *
 * *
 *  Copyright (c) 2016-2018 hearX Group (Pty) Ltd. All rights reserved
 *  Contact info@hearxgroup.com
 *  Created by David Howe
 *  Last modified David Howe on 2018/02/21 10:49 AM
 * /
 */

package com.hearxgroup.mhealthintegrationdemo.Models.MHealth;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class HearscreenTest {
    @SerializedName("local_id")
    private Long id;
    @SerializedName("id")
    private Long serverId;
    @SerializedName("patient_id")
    private Long serverPatientId; //server ID's
    @SerializedName("facility_id")
    private Long serverFacilityId; //server ID's
    @SerializedName("member_id")
    private Long serverMemberId;
    @SerializedName("device_id")
    private Long serverDeviceId;
    @SerializedName("headset_id")
    private Long serverHeadsetId; //server ID's
    @SerializedName("test_date")
    private Long testDate;
    @SerializedName("best_ear")
    private int bestEar;
    @SerializedName("duration")
    private int duration;
    @SerializedName("software_version")
    private String softwareVersion;
    @SerializedName("quality_test")
    private boolean qualityTest;
    @SerializedName("notes")
    private String notes;
    @SerializedName("protocol")
    private String protocol;
    @SerializedName("result_impairment")
    private int resultImpairment;
    @SerializedName("result")
    private int result;
    @SerializedName("known_impairment_type")
    private int knownImpairmentType;
    @SerializedName("lat")
    private double lat;
    @SerializedName("lng")
    private double lng;
    @SerializedName("address")
    private String address;
    @SerializedName("updated_at")
    private Long updatedAt;
    @SerializedName("created_at")
    private Long createdAt;
    @SerializedName("generated_id")
    private String generatedId;
    @SerializedName("generated_patient_id")
    private String generatedPatientId;
    @SerializedName("generated_facility_id")
    private String generatedFacilityId;
    private boolean pendingInTest;
    @SerializedName("frequency_results")
    private FrequencyResult[] frequencyResults;
    @SerializedName("frequency_results_json")
    private String frequencyResultsJson; //FrequencyResult[]
    @SerializedName("local_patient_id") //DEPRECATED
    private Long localPatientId;
    @SerializedName("local_facility_id") //DEPRECATED
    private Long localFacilityId;

    public static HearscreenTest fromJson(String json) {
        return new Gson().fromJson(json, HearscreenTest.class);
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTestDate() {
        return this.testDate;
    }

    public void setTestDate(Long testDate) {
        this.testDate = testDate;
    }

    public Long getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getSoftwareVersion() {
        return this.softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public boolean getQualityTest() {
        return this.qualityTest;
    }

    public void setQualityTest(boolean qualityTest) {
        this.qualityTest = qualityTest;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public int getResult() {
        return this.result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getKnownImpairmentType() {
        return this.knownImpairmentType;
    }

    public void setKnownImpairmentType(int knownImpairmentType) {
        this.knownImpairmentType = knownImpairmentType;
    }

    public double getLat() {
        return this.lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return this.lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFrequencyResultsJson() {
        return this.frequencyResultsJson;
    }

    public void setFrequencyResultsJson(String frequencyResultsJson) {
        this.frequencyResultsJson = frequencyResultsJson;
    }

    public boolean getPendingInTest() {
        return this.pendingInTest;
    }

    public void setPendingInTest(boolean pendingInTest) {
        this.pendingInTest = pendingInTest;
    }

    public String getGeneratedPatientId() {
        return generatedPatientId;
    }

    public void setGeneratedPatientId(String generatedPatientId) {
        this.generatedPatientId = generatedPatientId;
    }

    public String getGeneratedFacilityId() {
        return generatedFacilityId;
    }

    public void setGeneratedFacilityId(String generatedFacilityId) {
        this.generatedFacilityId = generatedFacilityId;
    }

    public Long getServerPatientId() {
        return this.serverPatientId;
    }

    public void setServerPatientId(Long serverPatientId) {
        this.serverPatientId = serverPatientId;
    }

    public Long getServerFacilityId() {
        return this.serverFacilityId;
    }

    public void setServerFacilityId(Long serverFacilityId) {
        this.serverFacilityId = serverFacilityId;
    }

    public Long getServerMemberId() {
        return this.serverMemberId;
    }

    public void setServerMemberId(Long serverMemberId) {
        this.serverMemberId = serverMemberId;
    }

    public Long getServerId() {
        return this.serverId;
    }

    public void setServerId(Long serverId) {
        this.serverId = serverId;
    }

    public Long getServerDeviceId() {
        return this.serverDeviceId;
    }

    public void setServerDeviceId(Long serverDeviceId) {
        this.serverDeviceId = serverDeviceId;
    }

    public int getResultImpairment() {
        return this.resultImpairment;
    }

    public void setResultImpairment(int resultImpairment) {
        this.resultImpairment = resultImpairment;
    }

    public Long getServerHeadsetId() {
        return this.serverHeadsetId;
    }

    public void setServerHeadsetId(Long serverHeadsetId) {
        this.serverHeadsetId = serverHeadsetId;
    }

    public int getBestEar() {
        return this.bestEar;
    }

    public void setBestEar(int bestEar) {
        this.bestEar = bestEar;
    }

    public String getGeneratedId() {
        return this.generatedId;
    }

    public void setGeneratedId(String generatedId) {
        this.generatedId = generatedId;
    }

    public Long getLocalPatientId() {
        return this.localPatientId;
    }

    public void setLocalPatientId(Long localPatientId) {
        this.localPatientId = localPatientId;
    }

    public Long getLocalFacilityId() {
        return this.localFacilityId;
    }

    public void setLocalFacilityId(Long localFacilityId) {
        this.localFacilityId = localFacilityId;
    }

    public FrequencyResult[] getFrequencyResults() {
        return frequencyResults;
    }

    public void setFrequencyResults(FrequencyResult[] frequencyResults) {
        this.frequencyResults = frequencyResults;
    }
}
