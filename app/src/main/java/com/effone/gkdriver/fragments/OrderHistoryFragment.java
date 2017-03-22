package com.effone.gkdriver.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.effone.gkdriver.Adapter.OrderHistoryItems;
import com.effone.gkdriver.Database.SelectDbHelper;
import com.effone.gkdriver.Model.OrderDetilas;
import com.effone.gkdriver.R;

import java.util.ArrayList;


public class OrderHistoryFragment extends Fragment implements View.OnClickListener {
    private ListView mListView;
    ArrayList<OrderDetilas> orderDetails;
    private SelectDbHelper mSelectDbHelper;
    private ImageView mImgMenuIcon;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_order_history, container, false);
        mSelectDbHelper=new SelectDbHelper(getActivity());
        init(root);
        return root;

    }

    private void init(View root) {
        mListView = (ListView) root.findViewById(R.id.list_item);
        mImgMenuIcon=(ImageView)root.findViewById(R.id.img_menu);
        mImgMenuIcon.setOnClickListener(this);
        OrderHistoryItems orderHistoryItems = new OrderHistoryItems(getActivity(), R.layout.order_list_item,mSelectDbHelper.orderList("HISTOR") );
        mListView.setAdapter(orderHistoryItems);
    }

    @Override
    public void onClick(View view) {
        final PopupMenu popup = new PopupMenu(getActivity(), mImgMenuIcon);
        //Inflating the Popup using xml file
        popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

        //registering popup with OnMenuItemClickListener
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                OrderHistoryItems orderHistoryItems;
                Toast.makeText(getActivity(),"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                switch (item.getItemId()){
                    case R.id.menu_delivery:
                     orderHistoryItems = new OrderHistoryItems(getActivity(), R.layout.order_list_item,mSelectDbHelper.orderList("HISTOR") );
                        mListView.setAdapter(orderHistoryItems);
                        break;
                    case R.id.menu_cancel:
                       orderHistoryItems = new OrderHistoryItems(getActivity(), R.layout.order_list_item,mSelectDbHelper.orderList("Canceled") );
                        mListView.setAdapter(orderHistoryItems);
                        break;
                    case R.id.menu_delete:
                        mSelectDbHelper.deleteAll();
                        orderHistoryItems = new OrderHistoryItems(getActivity(), R.layout.order_list_item,mSelectDbHelper.orderList("Canceled") );
                        mListView.setAdapter(orderHistoryItems);
                        break;

                }
                return true;
            }
        });
        popup.show();
    }
}



