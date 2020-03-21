package com.example.fragmentinsidefragmentpractice.recyclerAll;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentinsidefragmentpractice.R;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<ViewHolderData> {

    Context activity;
    List<String> item;
    List<Integer> image;

    public CustomAdapter(Context fragmentActivity, List<String> item, List<Integer> image) {
        this.activity = fragmentActivity;
        this.item = item;
        this.image = image;
    }

    @NonNull
    @Override
    public ViewHolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.recylcer_sample, parent, false);
        return new ViewHolderData(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderData holder, int position) {
        String currentItem = item.get(position);
        Integer currentImage = image.get(position);
        holder.sampleText.setText(currentItem);
        holder.sampleImage.setImageResource(currentImage);

    }

    @Override
    public int getItemCount() {
        return item.size();
    }
}
