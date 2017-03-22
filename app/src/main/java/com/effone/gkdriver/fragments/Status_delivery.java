package com.effone.gkdriver.fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.effone.gkdriver.Common.GKDriver;
import com.effone.gkdriver.Database.SelectDbHelper;
import com.effone.gkdriver.R;


public class Status_delivery extends Fragment implements View.OnClickListener {
    private int mOrderId;
    private EditText mEtCommets;
    private RadioGroup mRadioGroup;
    private TextView mTvSubmit;
    private SelectDbHelper mSelectDbHelper;
    private ImageView mImgMenu;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     View root= inflater.inflate(R.layout.fragment_status_delivery, container, false);
        init(root);
      return root;
    }

    private void init(View root) {
        mEtCommets=(EditText)root.findViewById(R.id.et_comments_area);
        mTvSubmit=(TextView)root.findViewById(R.id.tv_submit);
        mRadioGroup = (RadioGroup) root.findViewById(R.id.radioGroup);

        mTvSubmit.setOnClickListener(this);
        mSelectDbHelper=new SelectDbHelper(getActivity());
    }


    public void orderId(int orderDetilas) {
        mOrderId=orderDetilas;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_submit:
                String comments=mEtCommets.getText().toString().trim();
                int selectedId = mRadioGroup.getCheckedRadioButtonId();
                if(selectedId != -1){
                    if(comments.length()>50) {
                        RadioButton radioButton = (RadioButton) mRadioGroup.findViewById(selectedId);
                        Toast.makeText(getActivity(), radioButton.getText(), Toast.LENGTH_SHORT).show();
                        mSelectDbHelper.updateOrderHistory(mOrderId,comments, (String) radioButton.getText());
                    }else {
                        GKDriver.createOKAlert(getActivity(), getString(R.string.confimation),  getString(R.string.msg_commment));
                    }

                }else {
                    GKDriver.createOKAlert(getActivity(), getString(R.string.confimation),  getString(R.string.msg_delivery));
                }
                break;

        }

    }
}
