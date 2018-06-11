/*
 *
 * *
 *  Copyright (c) 2016-2018 hearX Group (Pty) Ltd. All rights reserved
 *  Contact info@hearxgroup.com
 *  Created by David Howe
 *  Last modified David Howe on 2018/02/21 10:07 PM
 * /
 */

package com.hearxgroup.mhealthintegrationdemo.TestRetriever.HearTest;

import android.app.LoaderManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import com.google.gson.Gson;
import com.hearxgroup.mhealthintegrationdemo.Models.HearTest.HearTestTest;
import com.hearxgroup.mhealthintegrationdemo.Models.MHealth.FrequencyResult;
import com.hearxgroup.mhealthintegrationdemo.Models.MHealth.HearscreenTest;
import com.hearxgroup.mhealthintegrationdemo.TestRetriever.MHealth.MHealthTestRetrieverContract;

public class HearTestTestRetriever implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final String TAG = HearTestTestRetriever.class.getSimpleName();
    static final String ID_PROVIDER_NAME = "com.hearxgroup.heartest.TestProvider/test/";
    private static final int LOADER_ID = 1;
    private Uri CONTENT_URI;
    private LoaderManager loaderManager;
    private Context context;
    private HearTestTestRetrieverContract.TestRetrieverInterface listener;

    public HearTestTestRetriever(Context context, LoaderManager loaderManager, HearTestTestRetrieverContract.TestRetrieverInterface listener) {
        this.context = context;
        this.loaderManager = loaderManager;
        this.listener = listener;
    }

    public void run(String generatedTestId) {
        startTestPoll(generatedTestId);
    }

    private void startTestPoll(String generatedTestId) {
        CONTENT_URI = Uri.parse("content://" + ID_PROVIDER_NAME + generatedTestId);
        loaderManager.initLoader(LOADER_ID, null, HearTestTestRetriever.this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(context, CONTENT_URI,
                null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        data = context.getContentResolver().query(CONTENT_URI, null, null, null, null);
        if (data != null && data.getCount() > 0) {
            data.moveToFirst();
            String dataJson = data.getString(1);
            if(dataJson!=null && dataJson.length()>0) {
                HearTestTest test = HearTestTest.fromJson(dataJson);
                listener.onHearTestRetrieve(test);
            }
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
    }

}
