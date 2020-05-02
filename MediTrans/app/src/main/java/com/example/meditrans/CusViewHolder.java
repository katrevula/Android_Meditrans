package com.example.meditrans;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CusViewHolder extends RecyclerView.ViewHolder {

    public TextView email, location,owner,phone,addr,name,time,uname;

    public CardView cardView;


    public CusViewHolder(View itemView) {
        super(itemView);

//        email = itemView.findViewById(R.id.emailmodel);
//        location = itemView.findViewById(R.id.locationmodel);
//        owner = itemView.findViewById(R.id.ownermodel);
//        phone = itemView.findViewById(R.id.phonemodel);
//        addr = itemView.findViewById(R.id.addrmodel);
//        uname = itemView.findViewById(R.id.unamemodel);
//
//        name = itemView.findViewById(R.id.namemodel);
//        time = itemView.findViewById(R.id.timemodel);


        location = itemView.findViewById(R.id.location);
        name = itemView.findViewById(R.id.shopName);
        cardView = itemView.findViewById(R.id.cardCustomerRecyler);



    }


}