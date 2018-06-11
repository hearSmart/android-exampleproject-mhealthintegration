/*
 * *
 *  * Copyright (c) 2017 hearX Group (Pty) Ltd. All rights reserved
 *  * Created by David Howe
 *  * hearX Group (Pty) Ltd.
 *  * info@hearxgroup.com
 *
 */

package com.hearxgroup.mhealthintegrationdemo.Models.HearTest;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.hearxgroup.mhealthintegrationdemo.Models.MHealth.HearscreenTest;

/**
 * Created by David Howe on 2017/08/30.
 * hearX Group (Pty) Ltd.
 * info@hearxgroup.com
 */

public class HearTestTest {
    public static final int VERSION = 1;
    @SerializedName("hardware_id")
    private int hardwareId;
    @SerializedName("protocol")
    private String protocol;
    @SerializedName("duration")
    private int duration;
    @SerializedName("software_version")
    private String softwareVersion;
    @SerializedName("mean_response_time")
    private double meanResponseTime;
    @SerializedName("std_dev_response_time")
    private double stdDevResponseTime;
    @SerializedName("total_responses")
    private int totalResponses;
    @SerializedName("total_false_responses")
    private int totalFalseResponses;
    @SerializedName("pta_left")
    private double ptaLeft;
    @SerializedName("pta_right")
    private double ptaRight;
    @SerializedName("operation_mode")
    private int operationMode;
    @SerializedName("notes")
    private String notes;
    @SerializedName("frequency_results_json")
    private String frequencyResultsJson;
    @SerializedName("test_generated_id")
    private String testGeneratedId;
    @SerializedName("headphone_model")
    private String headphoneModel; //NEW
    @SerializedName("protocol_min_intensity")
    private int protocolMinIntensity; //NEW

    public static HearTestTest fromJson(String json) {
        return new Gson().fromJson(json, HearTestTest.class);
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
