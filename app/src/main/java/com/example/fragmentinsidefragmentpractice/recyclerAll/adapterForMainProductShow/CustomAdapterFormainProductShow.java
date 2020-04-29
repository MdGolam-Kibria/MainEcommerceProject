package com.example.fragmentinsidefragmentpractice.recyclerAll.adapterForMainProductShow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentinsidefragmentpractice.R;

import java.util.List;

public class CustomAdapterFormainProductShow extends RecyclerView.Adapter<ViewHolderForMainProductShow> {

    Context context;
    List<Integer> productImage;
    List<String> productDescription;
    List<String> productCost;

    public CustomAdapterFormainProductShow(Context context, List<Integer> productImage, List<String> productDescription, List<String> productCost) {
        this.context = context;
        this.productImage = productImage;
        this.productDescription = productDescription;
        this.productCost = productCost;

    }

    @NonNull
    @Override
    public ViewHolderForMainProductShow onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_view_sample, parent, false);
        return new ViewHolderForMainProductShow(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderForMainProductShow holder, int position) {
        Integer currentImage = productImage.get(position);
        String currentProductDescription = productDescription.get(position);
        String currentProductCost = productCost.get(position);
        holder.productImage.setImageResource(currentImage);
        holder.productDescription.setText(currentProductDescription);
        holder.productCost.setText(currentProductCost);
    }

    @Override
    public int getItemCount() {
        return productImage.size();
    }
}
