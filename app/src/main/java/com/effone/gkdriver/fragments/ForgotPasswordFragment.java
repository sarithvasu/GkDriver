package com.effone.gkdriver.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.effone.gkdriver.Common.GKDriver;
import com.effone.gkdriver.Common.Validation;
import com.effone.gkdriver.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static com.effone.gkdriver.Common.DBConstants.DATE_FORMAT;

/**
 * Created by sarith.vasu on 10-03-2017.
 */

public class ForgotPasswordFragment extends Fragment implements View.OnClickListener {
    EditText mEtEmail;
    TextView mSubmit;
    Validation validation;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     View root= inflater.inflate(R.layout.activity_forgot_password, container, false);
        init(root);
    return root;
    }

    private void init(View root) {

        mEtEmail=(EditText)root.findViewById(R.id.et_fwd_email_id);
        mSubmit=(TextView)root.findViewById(R.id.tv_submit);
        mSubmit.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        validation=new Validation();
        String email=mEtEmail.getText().toString().trim();
        int i = 0;
        if (!validation.isValidEmail(email)) {
            ++i;
            mEtEmail.setError(getString(R.string.err_msg_email));
        }
        if (i == 0) {
                    GKDriver.createOKAlert(getActivity(), getString(R.string.confimation), getString(R.string.sucessfulllogin) );

                }
    }
}
