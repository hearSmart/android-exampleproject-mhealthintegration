package com.hearxgroup.mhealthintegrationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.hearxgroup.mhealthintegrationdemo.Models.HearTest.HearTestTest;
import com.hearxgroup.mhealthintegrationdemo.Models.HearTest.HearTestTestRequest;
import com.hearxgroup.mhealthintegrationdemo.Models.MHealth.HearscreenTest;
import com.hearxgroup.mhealthintegrationdemo.Models.MHealth.MHealthTestRequest;
import com.hearxgroup.mhealthintegrationdemo.TestRetriever.HearTest.HearTestTestRetriever;
import com.hearxgroup.mhealthintegrationdemo.TestRetriever.HearTest.HearTestTestRetrieverContract;
import com.hearxgroup.mhealthintegrationdemo.TestRetriever.MHealth.MHealthTestRetriever;
import com.hearxgroup.mhealthintegrationdemo.TestRetriever.MHealth.MHealthTestRetrieverContract;

import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements
        Contract.PresenterToUIInterface,
        MHealthTestRetrieverContract.TestRetrieverInterface,
        HearTestTestRetrieverContract.TestRetrieverInterface {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.spin_integration_type) Spinner spin_integration_type;
    @BindView(R.id.llyt_mhealth_options) LinearLayout llyt_mhealth_options;
    @BindView(R.id.edt_test_id) EditText edt_test_id;
    @BindView(R.id.edt_gender) EditText edt_gender;
    @BindView(R.id.edt_birthdate) EditText edt_birthdate;
    @BindView(R.id.edt_firstname) EditText edt_firstname;
    @BindView(R.id.edt_lastname) EditText edt_lastname;
    @BindView(R.id.edt_languageiso) EditText edt_languageiso;
    @BindView(R.id.edt_id_number) EditText edt_id_number;
    @BindView(R.id.edt_mrn_number) EditText edt_mrn_number;
    @BindView(R.id.edt_email) EditText edt_email;
    @BindView(R.id.edt_contactno) EditText edt_contactno;
    @BindView(R.id.btn_generate) Button btn_generate;
    @BindView(R.id.btn_go) Button btn_go;

    private int integrationType = Constants.INTEGRATION_TYPE_MHEALTH;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupUI();
        onNewIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        handleIntent(intent);
        setIntent(null);
    }

    private void setupUI() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btn_generate.setOnClickListener(viewClickListener);
        btn_go.setOnClickListener(viewClickListener);
        presenter = new Presenter(MainActivity.this);
        setupIntegrationTypeAdapter();
    }

    private void handleIntent(Intent intent) {
        Log.d(TAG, "handleIntent");
        Bundle bundle = intent.getExtras();
        if(bundle!=null && bundle.getString(Constants.BUNDLE_EXTRA_MHTEST_GN_ID)!=null) {
            String testId = bundle.getString(Constants.BUNDLE_EXTRA_MHTEST_GN_ID);
            Log.d(TAG, "testId: " + testId);
            if (testId != null && testId.length() > 0) {
                MHealthTestRetriever testRetriever = new MHealthTestRetriever(MainActivity.this, getLoaderManager(), MainActivity.this);
                testRetriever.run(testId);
            }
        }
        else  if(bundle!=null && bundle.getString(Constants.BUNDLE_EXTRA_HT_TEST_GN_ID)!=null) {
            String testId = bundle.getString(Constants.BUNDLE_EXTRA_HT_TEST_GN_ID);
            Log.d(TAG, "HT testId: " + testId);
            if (testId != null && testId.length() > 0) {
                HearTestTestRetriever testRetriever = new HearTestTestRetriever(MainActivity.this, getLoaderManager(), MainActivity.this);
                testRetriever.run(testId);
            }
        }
    }

    private void setupIntegrationTypeAdapter() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.array_integration_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_integration_type.setAdapter(adapter);
        spin_integration_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                integrationType = position + 1;
                setupUIForType(integrationType);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void setupUIForType(int integrationType) {
        switch(integrationType) {
            case Constants.INTEGRATION_TYPE_MHEALTH:
                llyt_mhealth_options.setVisibility(View.VISIBLE);
            break;

            case Constants.INTEGRATION_TYPE_HEARTEST:
                llyt_mhealth_options.setVisibility(View.GONE);
            break;
        }
    }

    private View.OnClickListener viewClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.btn_generate://GENERATE TEST ID
                    edt_test_id.setText(getRandomSequence());
                break;

                case R.id.btn_go: //ATTEMPT TO LAUNCH TEST
                    switch(integrationType) {
                        case Constants.INTEGRATION_TYPE_MHEALTH:
                            presenter.uiEventBtnClkGo(
                                    MHealthTestRequest.build(
                                            edt_test_id.getText().toString(),
                                            edt_gender.getText().toString(),
                                            edt_birthdate.getText().toString(),
                                            edt_firstname.getText().toString(),
                                            edt_lastname.getText().toString(),
                                            edt_languageiso.getText().toString(),
                                            edt_id_number.getText().toString(),
                                            edt_mrn_number.getText().toString(),
                                            edt_email.getText().toString(),
                                            edt_contactno.getText().toString(),
                                            Constants.RETURN_TEST_ACTION_NAME));
                        break;
                        case Constants.INTEGRATION_TYPE_HEARTEST:
                            presenter.uiEventBtnClkGo(
                                    HearTestTestRequest.build(
                                            edt_test_id.getText().toString(),
                                            Constants.RETURN_TEST_ACTION_NAME));
                            break;
                    }
                break;
            }
        }
    };

    private String getRandomSequence() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    @Override
    public void launch(Intent intent) {
        startActivity(intent);
    }

    @Override
    public void onHearscreenRetrieve(final HearscreenTest test) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                presenter.actionReceivedHSTest(MainActivity.this, test);
                Log.d(TAG, "HS TEST ENTRY: "+test.toJson());
            }
        });
    }

    @Override
    public void onHearTestRetrieve(final HearTestTest test) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                presenter.actionReceivedHTTest(MainActivity.this, test);
                Log.d(TAG, "HT TEST ENTRY: "+test.toJson());
            }
        });
    }
}
