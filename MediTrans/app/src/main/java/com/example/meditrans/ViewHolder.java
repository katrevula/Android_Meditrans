package com.example.meditrans;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView email, location,owner,phone,addr,name,time,uname;


    public ViewHolder(View itemView) {
        super(itemView);

        email = itemView.findViewById(R.id.emailmodel);
        location = itemView.findViewById(R.id.locationmodel);
        owner = itemView.findViewById(R.id.ownermodel);
        phone = itemView.findViewById(R.id.phonemodel);
        addr = itemView.findViewById(R.id.addrmodel);
        uname = itemView.findViewById(R.id.unamemodel);

        name = itemView.findViewById(R.id.namemodel);
        time = itemView.findViewById(R.id.timemodel);


    }


}