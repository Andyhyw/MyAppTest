package com.example.app3.listviews.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.app3.R;
import com.example.app3.listviews.model.News;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> implements View.OnClickListener {
    private static final String TAG = "RecyclerViewAdapter";

    private onRecyclerViewListener onRecyclerViewListener;
    private List<News> mList;
    private Context context;

    public RecyclerViewAdapter(Context context, List<News> mList) {
        this.context = context;
        this.mList = mList;
    }

    public News getItem(int position){
        return mList.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyViewHolder viewHolder;
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_listview_layout, parent, false);
        viewHolder = new MyViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        News news = mList.get(position);
        holder.img_icon.setTag(position);
        holder.tv_title.setTag(position);
        holder.tv_title.setText(news.getTitle());
        holder.tv_content.setText(news.getContent());
        holder.tv_content.setTag(position);
        holder.btn_adpt.setTag(position);
        holder.img_icon.setImageResource(news.getaIcon());
        holder.tv_title.setOnClickListener(this);
        holder.img_icon.setOnClickListener(this);
        holder.btn_adpt.setOnClickListener(this::onClick);
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_title:
                int position = (int) v.getTag();
                Log.i(TAG, "titile---position:" + position);
                onRecyclerViewListener.editHeadIcon(position);
                break;
            case R.id.btn_adpt:
                int position1 = (int) v.getTag();
                onRecyclerViewListener.deleteInfo(position1);
                break;
            default:
                break;
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img_icon;
        TextView tv_title;
        TextView tv_content;
        Button btn_adpt;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_content = itemView.findViewById(R.id.tv_content);
            tv_title = itemView.findViewById(R.id.tv_title);
            img_icon = itemView.findViewById(R.id.img_icon);
            btn_adpt =itemView.findViewById(R.id.btn_adpt);
        }
    }

    public void setOnRecyclerViewListener( RecyclerViewAdapter.onRecyclerViewListener onRecyclerViewListener) {
        this.onRecyclerViewListener = onRecyclerViewListener;
    }



   public interface onRecyclerViewListener {
        void editHeadIcon(int position);
        void deleteInfo(int position);
    }
}