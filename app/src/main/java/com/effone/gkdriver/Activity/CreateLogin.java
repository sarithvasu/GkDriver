package com.effone.gkdriver.Activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.effone.gkdriver.Common.AppPreferences;
import com.effone.gkdriver.Common.GKDriver;
import com.effone.gkdriver.Common.Validation;
import com.effone.gkdriver.Connection.Connectivty;
import com.effone.gkdriver.Connection.Util;
import com.effone.gkdriver.Database.DataBaseHelper;
import com.effone.gkdriver.Database.InsertDbHelper;
import com.effone.gkdriver.Database.SelectDbHelper;
import com.effone.gkdriver.R;
import com.effone.gkdriver.fragments.DeliveryDetailsFragment;
import com.effone.gkdriver.fragments.ForgotPasswordFragment;
import com.effone.gkdriver.fragments.MapsFragment;
import com.effone.gkdriver.fragments.OrderHistoryFragment;
import com.effone.gkdriver.fragments.Out_For_Delivery;
import com.effone.gkdriver.fragments.ResetPasswordFragment;
import com.effone.gkdriver.fragments.Status_delivery;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static com.effone.gkdriver.Common.DBConstants.DATE_FORMAT;
import static com.effone.gkdriver.R.string.login;


public class CreateLogin extends AppCompatActivity implements OnClickListener, Response.Listener<String>, Response.ErrorListener {
    private static final String TAG = "CreateLogin";
    private AppPreferences appPreferences;
    TextView mTvAvailablity, mTvOrder, mTvDelivery, mTvStatus, mTvLogin,mTvLogout, mTvEmail;
    private LocationManager locationManager;
    private DataBaseHelper mDataBaseHelper;
    private InsertDbHelper mInsertDbHelper;
    private SelectDbHelper mSelectDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar);
        mDataBaseHelper = new DataBaseHelper(this);
        mInsertDbHelper = new InsertDbHelper(this);
        mSelectDbHelper = new SelectDbHelper(this);
        appPreferences = new AppPreferences(this);
        init();
        LoginLogout();
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

//        if(checkPermission()) getView(); else  askPermission();

    }

    private void LoginLogout() {
        if (appPreferences.getUserName().equals("")) {
            showLoginScreen();

            //mTvLogin.setText(getString(login));
            mTvLogout.setVisibility(View.GONE);
            mTvLogin.setVisibility(View.VISIBLE);
            mTvEmail.setVisibility(View.GONE);

        } else {
            mTvLogout.setText(getString(R.string.logout));
            mTvLogout.setVisibility(View.VISIBLE);
            mTvLogin.setVisibility(View.GONE);
            mTvEmail.setText(appPreferences.getUserName());
            mTvEmail.setVisibility(View.VISIBLE);
        }
    }

    private void getView() {
        if (!Util.Operations.isOnline(this)) {
            Connectivty.showInternetDisabledAlertToUser(this);
        } else if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            Connectivty.showGPSDisabledAlertToUser(this);
        } else {
            init();
        }

    }

    private void init() {
        mTvAvailablity = (TextView) findViewById(R.id.tv_mTvAvailablity);
        mTvOrder = (TextView) findViewById(R.id.tv_mTvOrder);
        mTvDelivery = (TextView) findViewById(R.id.tv_mTvDelivery);
        mTvStatus = (TextView) findViewById(R.id.tv_mTvStatus);
        mTvLogout = (TextView) findViewById(R.id.tv_logout);
        mTvLogout.setOnClickListener(this);
        mTvLogin= (TextView) findViewById(R.id.tv_login);
        mTvLogin.setOnClickListener(this);
        mTvEmail = (TextView) findViewById(R.id.tv_email_id);

        mTvAvailablity.setOnClickListener(this);
        mTvOrder.setOnClickListener(this);
        mTvDelivery.setOnClickListener(this);
        mTvStatus.setOnClickListener(this);
        MapsFragment mCommonHeaderFragment = new MapsFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.context_panel, mCommonHeaderFragment, "header")
                .commit();
        visible_invisible(1);
    }

    private void showLoginScreen() {
        final Validation validation = new Validation();

        final Dialog login = new Dialog(this);
        login.setCancelable(false);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_MODE_CHANGED);
// Set GUI of login screen
        login.requestWindowFeature(Window.FEATURE_NO_TITLE);
        login.setContentView(R.layout.activity_create_login);

        final EditText mEtEmail, mEtPassword;
        TextView mBtLogin, mTvResetPassword, mTvCancel, mTvForgotPassword;
        mEtEmail = (EditText) login.findViewById(R.id.et_email);
        mEtPassword = (EditText) login.findViewById(R.id.et_password);
        mBtLogin = (TextView) login.findViewById(R.id.tv_login);
        mTvCancel = (TextView) login.findViewById(R.id.tv_cancel);
        mTvResetPassword = (TextView) login.findViewById(R.id.tv_reset_password);
        mTvForgotPassword = (TextView) login.findViewById(R.id.forgotPassword);
        String udata = getString(R.string.forgot);
        SpannableString content = new SpannableString(udata);
        content.setSpan(new UnderlineSpan(), 0, udata.length(), 0);
        mTvForgotPassword.setText(content);
        mTvResetPassword.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                ResetPasswordFragment resetPasswordFragment = new ResetPasswordFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.context_panel, resetPasswordFragment, "header").addToBackStack(null).commit();
                login.cancel();
                visible_invisible(5);
                keyboardhidden();


            }
        });
        mTvForgotPassword.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                login.cancel();
                ForgotPasswordFragment forgotPasswordFragment = new ForgotPasswordFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.add(R.id.context_panel, forgotPasswordFragment, "header").addToBackStack(null).commit();
                visible_invisible(5);
                keyboardhidden();
            }
        });
        mTvCancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                login.cancel();
            }
        });
        mBtLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEtEmail.getText().toString().trim();
                String password = mEtPassword.getText().toString().trim();
                int i = 0;
                if (!validation.isValidEmail(email)) {
                    ++i;
                    mEtEmail.setError(getString(R.string.err_msg_email));
                }
                String msg = validation.contiansChar(password);
                if (msg.equals("nochar")) {
                    ++i;
                    mEtPassword.setError(getString(R.string.err_msg_password_char));
                } else if (msg.equals("nonumbers")) {
                    ++i;
                    mEtPassword.setError(getString(R.string.err_msg_password_digit));
                } else if (msg.equals("nolength")) {
                    ++i;
                    mEtPassword.setError(getString(R.string.err_msg_password_length));
                }
                if (i == 0) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.US);
                    Calendar cal = Calendar.getInstance();
                    String currentDateTimeString = dateFormat.format(cal.getTime());
                    if (mSelectDbHelper.countNumberOfRecords() != 1) {
                        if (firstTimeLogin(currentDateTimeString, email, password)) {
                            GKDriver.createOKAlert(login.getContext(), getString(R.string.confimation), getString(R.string.sucessfulllogin) + " " + appPreferences.getUserName());
                            LoginLogout();
                            login.cancel();
                            keyboardhidden();
                        } else {
                            GKDriver.createOKAlert(login.getContext(), getString(R.string.confimation), getString(R.string.failedtologin));
                        }

                    } else {
                        if (secondTimeLogin(currentDateTimeString, email, password)) {
                            GKDriver.createOKAlert(login.getContext(), getString(R.string.confimation), getString(R.string.sucessfulllogin) + " " + appPreferences.getUserName());
                            LoginLogout();
                            login.cancel();
                            keyboardhidden();
                        } else {
                            GKDriver.createOKAlert(login.getContext(), getString(R.string.confimation), getString(R.string.failedtologin));
                        }
                    }

                }

            }
        });
// Init button of login GUI

// Attached listener for login GUI button


// Make dialog box visible.
        login.show();
    }

    private boolean secondTimeLogin(String currentDateTimeString, String email, String password) {
        if (mInsertDbHelper.update_login_user())
            return firstTimeLogin(currentDateTimeString, email, password);
        return false;
    }

    private boolean firstTimeLogin(String currentDateTimeString, String email, String password) {
        if (mInsertDbHelper.login_user(currentDateTimeString, email, password)) {
            appPreferences.setUserName(email);
            mTvLogin.setText(getString(R.string.logout));
            mTvEmail.setText(appPreferences.getUserName());
            mTvEmail.setVisibility(View.VISIBLE);
            return true;
        } else
            return false;

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_logout:

                    logoutAlert();



                break;
            case R.id.tv_login:

                    showLoginScreen();




                break;
            case R.id.tv_mTvAvailablity:
                MapsFragment mCommonHeaderFragment = new MapsFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.add(R.id.context_panel, mCommonHeaderFragment, "header").addToBackStack(null).commit();
                visible_invisible(1);
                keyboardhidden();
                break;
            case R.id.tv_mTvDelivery:
                DeliveryDetailsFragment deliveryDetailsFragment = new DeliveryDetailsFragment();
                FragmentTransaction ftss = getFragmentManager().beginTransaction();
                ftss.add(R.id.context_panel, deliveryDetailsFragment, "header").addToBackStack(null).commit();
                visible_invisible(2);
                keyboardhidden();
                break;
            case R.id.tv_mTvStatus:
                Out_For_Delivery status_delivery = new Out_For_Delivery();
                FragmentTransaction fts1 = getFragmentManager().beginTransaction();
                fts1.add(R.id.context_panel, status_delivery, "header").addToBackStack(null).commit();
                visible_invisible(3);
                keyboardhidden();
                break;
            case R.id.tv_mTvOrder:
                OrderHistoryFragment mOrderHistoryFragment = new OrderHistoryFragment();
                FragmentTransaction fts = getFragmentManager().beginTransaction();
                fts.add(R.id.context_panel, mOrderHistoryFragment, "header").addToBackStack(null).commit();
                visible_invisible(4);
                keyboardhidden();
                break;

        }
    }


    private void visible_invisible(int i) {
        if (i == 1) {
            mTvAvailablity.setTextColor(getResources().getColor(R.color.yellow));
        } else {
            mTvAvailablity.setTextColor(getResources().getColor(R.color.white));

        }
        if (i == 4) {
            mTvOrder.setTextColor(getResources().getColor(R.color.yellow));
        } else {
            mTvOrder.setTextColor(getResources().getColor(R.color.white));
        }
        if (i == 2) {
            mTvDelivery.setTextColor(getResources().getColor(R.color.yellow));
        } else {
            mTvDelivery.setTextColor(getResources().getColor(R.color.white));
        }
        if (i == 3) {
            mTvStatus.setTextColor(getResources().getColor(R.color.yellow));
        } else {
            mTvStatus.setTextColor(getResources().getColor(R.color.white));
        }

    }


    @Override
    public void onResponse(String response) {

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    public void logoutAlert() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(R.string.quit)
                .setMessage(R.string.really_quit)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //Stop the activit
                        // y
                        appPreferences.setUserName("");
                        showLoginScreen();
                        mTvLogin.setText(R.string.login);
                        mTvEmail.setText(appPreferences.getUserName());
                        mTvEmail.setVisibility(View.GONE);
                        mTvLogout.setVisibility(View.GONE);
                        mTvLogin.setVisibility(View.VISIBLE);
                    }

                })
                .setNegativeButton(R.string.no, null)
                .show();
    }

    public void keyboardhidden() {
        InputMethodManager inputManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (this.getCurrentFocus() != null && inputManager != null) {
            inputManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}


