package com.effone.gkdriver.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.effone.gkdriver.Model.OrderDetilas;
import com.effone.gkdriver.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarith.vasu on 09-03-2017.
 */

public class OrderHistoryItems  extends ArrayAdapter<OrderDetilas> {
    private ArrayList<OrderDetilas> values;
    private LayoutInflater inflater;

    public OrderHistoryItems(Context context, int resource, List<OrderDetilas> values) {
        super(context, resource, values);
        this.values =(ArrayList<OrderDetilas>) values;
        inflater = (LayoutInflater)context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        final FilterViewHolder holder;

        if(convertView==null){
            vi = inflater.inflate(R.layout.order_list_item, null);
            holder = new FilterViewHolder();
            holder.date = (TextView) vi.findViewById(R.id.tv_date_time);
            holder.saladname = (TextView ) vi.findViewById(R.id.tv_salad_name);
            holder.address = (TextView ) vi.findViewById(R.id.tv_address1);
            holder.addreess1 = (TextView ) vi.findViewById(R.id.tv_address2);
            holder.name = (TextView ) vi.findViewById(R.id.tv_name_phone);
            vi.setTag( holder );
        }
        else
            holder = (FilterViewHolder) vi.getTag();

        if (values.size() <= 0) {
            holder.date.setText("No Data");

        } else {
            /***** Get each Model object from Arraylist ********/

            OrderDetilas value = (OrderDetilas) values.get(position);

            /************  Set Model values in Holder elements ***********/

            holder.date.setText("Delivered   "+value.getDateofDelivery()+" "+ value.getTime());
            holder.saladname.setText(value.getItemName());
            holder.address.setText(value.getAddress());
            holder.addreess1.setText(value.getAddress2());
            holder.name.setText(value.getName()+" "+value.getPhone());




        }

        return vi;



    }
    public static  class FilterViewHolder {
       TextView date,saladname,address,addreess1,name;

    }


}