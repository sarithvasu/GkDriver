package com.effone.gkdriver.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.effone.gkdriver.Adapter.OrderHistoryItems;
import com.effone.gkdriver.Model.OrderDetilas;
import com.effone.gkdriver.R;

import java.util.ArrayList;


public class OrderHistoryFragment extends Fragment {
    private ListView mListView;
    ArrayList<OrderDetilas> orderDetails;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_order_history, container, false);
        init(root);
        return root;

    }

    private void init(View root) {
        mListView = (ListView) root.findViewById(R.id.list_item);
        orderDetails = new ArrayList<>();
        orderDetails.add(new OrderDetilas("11-Feb-2017", "@ 2:43 PM", "Ambrosia salad", "#1-99 Farmhouse Ln", "Marshfield,MA 02050,USA", "Mr.Addy", "(877) 304-4493"));
        orderDetails.add(new OrderDetilas("11-Feb-2017", "@ 3.20 PM", "Michigan salad", "#1-99 Earldor cir", "Marshfield,MA 02050,USA", "Mr.Donald ", "(877) 304-4489"));
        orderDetails.add(new OrderDetilas("11-Feb-2017", "@ 5.17 PM", "Jello  salad", "#101-234 Prince Roger Way", "Marshfield,MA 02050,USA", "Mr.Steven  ", "(877) 304-4493"));
        orderDetails.add(new OrderDetilas("11-Feb-2017", "@ 5.28 PM", "Ambrosia salad", "#1-42 Farmhouse", "Marshfield,MA 02050,USA", "Mr.Jeff  ", "(877) 304-4493"));

        OrderHistoryItems orderHistoryItems = new OrderHistoryItems(getActivity(), R.layout.order_list_item, orderDetails);
        mListView.setAdapter(orderHistoryItems);
    }
}



