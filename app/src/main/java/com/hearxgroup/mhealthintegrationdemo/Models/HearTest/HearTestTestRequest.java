/*
 *
 * *
 *  Copyright (c) 2016-2018 hearX Group (Pty) Ltd. All rights reserved
 *  Contact info@hearxgroup.com
 *  Created by David Howe
 *  Last modified David Howe on 2018/02/20 5:37 PM
 * /
 */

package com.hearxgroup.mhealthintegrationdemo.Models.HearTest;

import android.support.annotation.Nullable;

import com.google.gson.Gson;

public class HearTestTestRequest {
    private String generatedId; //32 character length randomly generated string *NB REQUIRED
    @Nullable
    private String returnIntentActionName; //Return intent filter action name

    public static HearTestTestRequest build(
            String generatedId,
            String returnIntentActionName) {
        HearTestTestRequest mHealthTestRequest = new HearTestTestRequest();
        mHealthTestRequest.setGeneratedId(generatedId);
        mHealthTestRequest.setReturnIntentActionName(returnIntentActionName);
        return mHealthTestRequest;
    }

    public String getGeneratedId() {
        return generatedId;
    }

    public void setGeneratedId(String generatedId) {
        this.generatedId = generatedId;
    }

    public String getReturnIntentActionName() {
        return returnIntentActionName;
    }

    public void setReturnIntentActionName(String returnIntentActionName) {
        this.returnIntentActionName = returnIntentActionName;
    }

    public static HearTestTestRequest fromJson(String json) {
        return new Gson().fromJson(json, HearTestTestRequest.class);
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

}
