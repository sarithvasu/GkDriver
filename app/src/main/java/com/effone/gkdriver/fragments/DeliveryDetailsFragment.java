package com.effone.gkdriver.fragments;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.effone.gkdriver.R;

public class DeliveryDetailsFragment extends Fragment {
  TextView mTvName,mTvAddress,mTvCity,mTvPin,mTvPhoneNumber,mTvOrderIds,mTvOrderdates,mTvPrizes,mTvQunat,mTvSummerySalad,mTvSummerySaladComments;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_delivery_details, container, false);
        init(root);
        return  root;

    }

    private void init(View root) {
        mTvName=(TextView)root.findViewById(R.id.tv_name);
        mTvAddress=(TextView)root.findViewById(R.id.tv_addres);
        mTvCity=(TextView)root.findViewById(R.id.tv_city);
        mTvPin=(TextView)root.findViewById(R.id.tv_pin);
        mTvPhoneNumber=(TextView)root.findViewById(R.id.tv_phone);
        //orderSummery Variables
        mTvOrderIds=(TextView)root.findViewById(R.id.order_ids);
        mTvOrderdates=(TextView)root.findViewById(R.id.order_datess);
        mTvPrizes=(TextView)root.findViewById(R.id.tv_prizes);
        mTvQunat=(TextView)root.findViewById(R.id.tv_quant);
        mTvSummerySalad=(TextView)root.findViewById(R.id.tv_summery);
        mTvSummerySaladComments=(TextView)root.findViewById(R.id.tv_summery_context);
    }


}
