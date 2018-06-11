/*
 *
 * *
 *  Copyright (c) 2017-2018 hearX Group (Pty) Ltd. All rights reserved
 *  Contact info@hearxgroup.com
 *  Created by David Howe
 *  Last modified David Howe on 2018/02/07 11:25 AM
 * /
 */

package com.hearxgroup.mhealthintegrationdemo.Models.HearTest;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class FrequencyResultEntry {
    private int frequency;
    private int ear;
    private int threshold; // Threshold of hearing result for the corresponding frequency
    private int noise; //Average ambient noise during tone presentation
    @SerializedName("noise_5db_less")
    private int noise5DbLess;
    @SerializedName("no_response")
    private boolean noResponse; //Whether the patient never responded during this play through frequency
    @SerializedName("condition_tone")
    private boolean conditionTone;
    private boolean masked; //Whether masking was applied

    public static FrequencyResultEntry build(
            int frequency, int ear, int intensity, int noise, int noise5DbLess,
            boolean noResponse, boolean conditionTone, boolean masked) {
        FrequencyResultEntry entry = new FrequencyResultEntry();
        entry.setFrequency(frequency);
        entry.setThreshold(intensity);
        entry.setEar(ear);
        entry.setNoise(noise);
        entry.setNoise5DbLess(noise5DbLess);
        entry.setNoResponse(noResponse);
        entry.setConditionTone(conditionTone);
        entry.setMasked(masked);
        return entry;
    }

    public static FrequencyResultEntry fromJson(String json) {
        return new Gson().fromJson(json, FrequencyResultEntry.class);
    }

    public String toJson(){
        return new Gson().toJson(this);
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getEar() {
        return ear;
    }

    public void setEar(int ear) {
        this.ear = ear;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public int getNoise() {
        return noise;
    }

    public void setNoise(int noise) {
        this.noise = noise;
    }

    public int getNoise5DbLess() {
        return noise5DbLess;
    }

    public void setNoise5DbLess(int noise5DbLess) {
        this.noise5DbLess = noise5DbLess;
    }

    public boolean isNoResponse() {
        return noResponse;
    }

    public void setNoResponse(boolean noResponse) {
        this.noResponse = noResponse;
    }

    public boolean isConditionTone() {
        return conditionTone;
    }

    public void setConditionTone(boolean conditionTone) {
        this.conditionTone = conditionTone;
    }

    public boolean isMasked() {
        return masked;
    }

    public void setMasked(boolean masked) {
        this.masked = masked;
    }
}
