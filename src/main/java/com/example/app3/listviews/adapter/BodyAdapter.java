package com.example.app3.listviews.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.app3.R;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class BodyAdapter extends RecyclerView.Adapter {
    private List<Integer> res;
    public BodyAdapter(List<Integer> res) {
        this.res = res;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_body_img, parent, false);
        return new ImgHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ImgHolder) {
            ((ImgHolder) holder).iv.setImageResource(res.get(position));
        }
    }

    private class ImgHolder extends RecyclerView.ViewHolder {

        ImageView iv;

        public ImgHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
        }
    }

    @Override
    public int getItemCount() {
        return res.size();
    }
}
