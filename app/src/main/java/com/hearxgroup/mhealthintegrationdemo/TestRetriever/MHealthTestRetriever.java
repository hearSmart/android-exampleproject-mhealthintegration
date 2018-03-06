/*
 *
 * *
 *  Copyright (c) 2016-2018 hearX Group (Pty) Ltd. All rights reserved
 *  Contact info@hearxgroup.com
 *  Created by David Howe
 *  Last modified David Howe on 2018/02/21 10:07 PM
 * /
 */

package com.hearxgroup.mhealthintegrationdemo.TestRetriever;

import android.app.LoaderManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import com.google.gson.Gson;
import com.hearxgroup.mhealthintegrationdemo.Models.FrequencyResult;
import com.hearxgroup.mhealthintegrationdemo.Models.HearscreenTest;

public class MHealthTestRetriever implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final String TAG = MHealthTestRetriever.class.getSimpleName();
    static final String HEARSCREEN_TEST_ID_PROVIDER_NAME = "com.hearxgroup.mhealthstudio.TestProvider/hearscreen.test/";
    private static final int LOADER_ID = 1;
    private Uri CONTENT_URI;
    private LoaderManager loaderManager;
    private Context context;
    private MHealthTestRetrieverContract.TestRetrieverInterface listener;

    public MHealthTestRetriever(Context context, LoaderManager loaderManager, MHealthTestRetrieverContract.TestRetrieverInterface listener) {
        this.context = context;
        this.loaderManager = loaderManager;
        this.listener = listener;
    }

    public void run(String generatedTestId) {
        startHearscreenPoll(generatedTestId);
    }

    private void startHearscreenPoll(String generatedTestId) {
        CONTENT_URI = Uri.parse("content://" + HEARSCREEN_TEST_ID_PROVIDER_NAME + generatedTestId);
        loaderManager.initLoader(LOADER_ID, null, MHealthTestRetriever.this);
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
            String hsTestJson = data.getString(1);
            if(hsTestJson!=null && hsTestJson.length()>0) {
                HearscreenTest test = HearscreenTest.fromJson(hsTestJson);
                test.setFrequencyResults(new Gson().fromJson(test.getFrequencyResultsJson(), FrequencyResult[].class));
                test.setFrequencyResultsJson(null);
                listener.onHearscreenRetrieve(HearscreenTest.fromJson(hsTestJson));
            }
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
    }

}
