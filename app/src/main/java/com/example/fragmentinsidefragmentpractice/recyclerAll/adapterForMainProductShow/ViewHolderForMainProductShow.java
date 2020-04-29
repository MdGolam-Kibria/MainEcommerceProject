package com.example.fragmentinsidefragmentpractice.recyclerAll.adapterForMainProductShow;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentinsidefragmentpractice.R;

public class ViewHolderForMainProductShow extends RecyclerView.ViewHolder {
    ImageView productImage;
    TextView productDescription,productCost;
    public ViewHolderForMainProductShow(@NonNull View itemView) {
        super(itemView);
        productImage = itemView.findViewById(R.id.productImage);
        productDescription = itemView.findViewById(R.id.productDescription);
        productCost = itemView.findViewById(R.id.productCost);
    }
}
