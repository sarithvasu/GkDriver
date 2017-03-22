package com.effone.gkdriver.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.effone.gkdriver.Adapter.OrderHistoryItems;
import com.effone.gkdriver.Database.InsertDbHelper;
import com.effone.gkdriver.Database.SelectDbHelper;
import com.effone.gkdriver.Model.OrderDetilas;
import com.effone.gkdriver.Model.OrderHistory;
import com.effone.gkdriver.R;

import java.util.ArrayList;

public class Out_For_Delivery extends Fragment implements AdapterView.OnItemClickListener {
    TextView mHeaderText;
    ImageView mMoreIcon;
    ListView mListView;
    ArrayList<OrderDetilas> orderDetails;
    InsertDbHelper insertDbHelper;
    SelectDbHelper selectDbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_order_history, container, false);
        insertDbHelper =new InsertDbHelper(getActivity());
        selectDbHelper=new SelectDbHelper(getActivity());
        init(root);
        return root;
    }

    private void init(View root) {
        mHeaderText = (TextView) root.findViewById(R.id.delivery_status);
        mHeaderText.setText(getString(R.string.status_out_delivery));
        mMoreIcon = (ImageView) root.findViewById(R.id.img_menu);
        mMoreIcon.setVisibility(View.GONE);
        mListView = (ListView) root.findViewById(R.id.list_item);
        virtualMethod();
    }

    private void virtualMethod() {
        orderDetails = new ArrayList<>();
        orderDetails.add(new OrderDetilas(1,5,"Delivery", "11-Feb-2017", "@ 2:43 PM", "Ambrosia salad", "#1-99 Farmhouse Ln", "Marshfield,MA 02050,USA", "Mr.Addy", "(877) 304-4493"));
        orderDetails.add(new OrderDetilas(2,5,"Delivery", "11-Feb-2017", "@ 3.20 PM", "Michigan salad", "#1-99 Earldor cir", "Marshfield,MA 02050,USA", "Mr.Donald ", "(877) 304-4489"));
        orderDetails.add(new OrderDetilas(3,5,"Delivery", "11-Feb-2017", "@ 5.17 PM", "Jello  salad", "#101-234 Prince Roger Way", "Marshfield,MA 02050,USA", "Mr.Steven  ", "(877) 304-4493"));
        orderDetails.add(new OrderDetilas(4,5,"Delivery", "11-Feb-2017", "@ 5.28 PM", "Ambrosia salad", "#1-42 Farmhouse", "Marshfield,MA 02050,USA", "Mr.Jeff  ", "(877) 304-4493"));
        orderDetails.add(new OrderDetilas(5,5,"Delivery", "11-Feb-2017", "@ 2:43 PM", "Ambrosia salad", "#1-99 Farmhouse Ln", "Marshfield,MA 02050,USA", "Mr.Addy", "(877) 304-4493"));
        orderDetails.add(new OrderDetilas(6,5,"Delivery", "11-Feb-2017", "@ 3.20 PM", "Michigan salad", "#1-99 Earldor cir", "Marshfield,MA 02050,USA", "Mr.Donald ", "(877) 304-4489"));
        orderDetails.add(new OrderDetilas(7,5,"Delivery", "11-Feb-2017", "@ 5.17 PM", "Jello  salad", "#101-234 Prince Roger Way", "Marshfield,MA 02050,USA", "Mr.Steven  ", "(877) 304-4493"));
        orderDetails.add(new OrderDetilas(8,5,"Delivery", "11-Feb-2017", "@ 5.28 PM", "Ambrosia salad", "#1-42 Farmhouse", "Marshfield,MA 02050,USA", "Mr.Jeff  ", "(877) 304-4493"));
        orderDetails.add(new OrderDetilas(9,5,"Delivery", "11-Feb-2017", "@ 2:43 PM", "Ambrosia salad", "#1-99 Farmhouse Ln", "Marshfield,MA 02050,USA", "Mr.Addy", "(877) 304-4493"));
        orderDetails.add(new OrderDetilas(10,5,"Delivery", "11-Feb-2017", "@ 3.20 PM", "Michigan salad", "#1-99 Earldor cir", "Marshfield,MA 02050,USA", "Mr.Donald ", "(877) 304-4489"));
        orderDetails.add(new OrderDetilas(11,5,"Delivery", "11-Feb-2017", "@ 5.17 PM", "Jello  salad", "#101-234 Prince Roger Way", "Marshfield,MA 02050,USA", "Mr.Steven  ", "(877) 304-4493"));
        orderDetails.add(new OrderDetilas(12,5,"Delivery", "11-Feb-2017", "@ 5.28 PM", "Ambrosia salad", "#1-42 Farmhouse", "Marshfield,MA 02050,USA", "Mr.Jeff  ", "(877) 304-4493"));

        insertDbHelper.insertIntoOrderHistory(orderDetails);
        OrderHistoryItems orderHistoryItems = new OrderHistoryItems(getActivity(), R.layout.order_list_item, selectDbHelper.orderList("Out_for_delivery"));
        mListView.setAdapter(orderHistoryItems);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        int orderDetilas= ((OrderDetilas) mListView.getItemAtPosition(i)).getOrder_id();

        Status_delivery status_delivery = new Status_delivery();
        status_delivery.orderId(orderDetilas);
        FragmentTransaction fts1 = getFragmentManager().beginTransaction();
        fts1.add(R.id.context_panel, status_delivery, "header").addToBackStack(null).commit();
    }
}
