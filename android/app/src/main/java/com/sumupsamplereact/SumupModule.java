package com.sumupsamplereact;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.sumup.merchant.Models.TransactionInfo;
import com.sumup.merchant.api.SumUpAPI;
import com.sumup.merchant.api.SumUpLogin;
import com.sumup.merchant.api.SumUpPayment;

import java.util.UUID;

/**
 * Created by maxguimaraes on 15/09/17.
 */

public class SumupModule extends ReactContextBaseJavaModule {

    private final String CALLBACK_TYPE_SUCCESS = "success";
    private final String CALLBACK_TYPE_ERROR = "error";
    private final String CALLBACK_TYPE_CANCEL = "cancel";

    private static final int REQUEST_CODE_LOGIN = 1;
    private static final int REQUEST_CODE_PAYMENT = 2;
    private static final int REQUEST_CODE_PAYMENT_SETTINGS = 3;
    private final String AFFILIATE_KEY = "YOURKEY";
    private Context mActivityContext;
    private Callback mTokenCallback;

    private Promise mPromiseSumup;

    public SumupModule(ReactApplicationContext reactContext, Context activityContext) {
        super(reactContext);

        mActivityContext = activityContext;
        reactContext.addActivityEventListener(mActivityEventListener);
    }

    @Override
    public String getName() {
        return "SumupModule";
    }

    @ReactMethod
    public void login() {
        
        SumUpLogin sumUplogin = SumUpLogin.builder(AFFILIATE_KEY).build();
        SumUpAPI.openLoginActivity(getCurrentActivity(), sumUplogin, REQUEST_CODE_LOGIN);
    }
    @ReactMethod
    public void charge(){
        SumUpPayment payment = SumUpPayment.builder()
                .affiliateKey(AFFILIATE_KEY)
                .productAmount(1.0)
                .currency(SumUpPayment.Currency.BRL).build();
        SumUpAPI.openPaymentActivity(getCurrentActivity(), payment, REQUEST_CODE_PAYMENT);
    }
    @ReactMethod
    public void paymentSettings(){
        SumUpAPI.openPaymentSettingsActivity(getCurrentActivity(), REQUEST_CODE_PAYMENT_SETTINGS);
    }

    @ReactMethod
    public void prepareCardTerminal(){
        SumUpAPI.prepareForCheckout();
    }

    @ReactMethod
    public void logout(){
        SumUpAPI.logout();
    }

    private final ActivityEventListener mActivityEventListener = new BaseActivityEventListener() {

        @Override
        public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
            switch (requestCode) {

                case REQUEST_CODE_PAYMENT:
                    if (data != null) {
                        Bundle extra = data.getExtras();
                        TransactionInfo transactionInfo = extra.getParcelable(SumUpAPI.Response.TX_INFO);
                    }
                    break;

                default:
                    break;
            }
        }
    };

}
