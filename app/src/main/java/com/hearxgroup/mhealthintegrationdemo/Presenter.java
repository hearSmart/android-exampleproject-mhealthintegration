package com.hearxgroup.mhealthintegrationdemo;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;

import com.hearxgroup.mhealthintegrationdemo.Models.TestRequest;

import java.util.List;

/**
 * Copyright (c) 2017 hearX Group (Pty) Ltd. All rights reserved
 * Created by David Howe on 2018/03/02.
 * hearX Group (Pty) Ltd.
 * info@hearxgroup.com
 */
public class Presenter {

    private Contract.PresenterToUIInterface uiInterface;

    public Presenter(Contract.PresenterToUIInterface uiInterface) {
       this.uiInterface = uiInterface;
    }

    protected void uiEventBtnClkGo(TestRequest testRequest) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.BUNDLE_EXTRA_TEST_REQUEST_JSON, testRequest.toJson());
        openApp(bundle, Constants.REQUEST_HEARING_TEST_ACTION_NAME);
    }

    private boolean openApp(Bundle bundle, String actionName) {
        Intent newIntent = new Intent(actionName);
        newIntent.setType("text/plain");
        PackageManager packageManager = IntegrationApplication.getAppContext().getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(newIntent, 0);
        boolean isIntentSafe = activities.size() > 0;
        if (isIntentSafe) {
            if(bundle!=null)
                newIntent.putExtras(bundle);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            newIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            uiInterface.launch(newIntent);
            return true;
        }
        return false; //MHEALTH APP INSTALLATION COULD NOT BE FOUND
    }
}