package com.example.app3.listviews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.app3.R;
import com.example.app3.listviews.model.BodyBean;
import com.example.app3.listviews.model.FootBean;
import com.example.app3.listviews.model.MultyBaseBean;
import com.example.app3.listviews.model.TitleBean;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

public class RecyclerViewMultyAdapter  extends RecyclerView.Adapter {

    public final static int TITLE = 1001;//标题的viewType
    public final static int BODY = 1002;//横向列表的viewType
    public final static int FOOT = 1003;//正常列表的viewType
    private List<MultyBaseBean> mlist;//adapter的数据源
    private Context context;
    private LayoutInflater inflater;


    public RecyclerViewMultyAdapter(List<MultyBaseBean> mlist) {
        this.mlist = mlist;
    }

    @Override
    public int getItemViewType(int position) {
        if (mlist.size() > 0) {
            return mlist.get(position).getViewType();
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (context == null)
            context = parent.getContext();
        if (inflater == null)
            inflater = LayoutInflater.from(context);
        View view;
        switch (viewType) {
            case TITLE:
                view = inflater.inflate(R.layout.listitem_title, parent, false);
                return new TitleHolder(view);
            case BODY:
                view = inflater.inflate(R.layout.listitem_body, parent, false);
                return new BodyHolder(view);
            case FOOT:
                view = inflater.inflate(R.layout.listitem_foot, parent, false);
                return new FootHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TitleHolder) {
            TitleBean titleBean = (TitleBean) mlist.get(position);
            ((TitleHolder) holder).vp.setAdapter(new RecyclerViewPagerAdapter(titleBean.getTitles()));
        }

        if (holder instanceof BodyHolder) {
            BodyBean bodyBean = (BodyBean) mlist.get(position);
            ((BodyHolder) holder).rv.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
            ((BodyHolder) holder).rv.setAdapter(new BodyAdapter(bodyBean.getRes()));
        }

        if (holder instanceof FootHolder) {
            FootBean footBean = (FootBean) mlist.get(position);
            ((FootHolder) holder).tv_foot.setText(footBean.getStr());
        }
    }



    private class TitleHolder extends RecyclerView.ViewHolder {

        ViewPager vp;

        public TitleHolder(View itemView) {
            super(itemView);
            vp = itemView.findViewById(R.id.vp);
        }
    }

    private class BodyHolder extends RecyclerView.ViewHolder {

        RecyclerView rv;

        public BodyHolder(View itemView) {
            super(itemView);
            rv = itemView.findViewById(R.id.rv);
        }
    }

    private class FootHolder extends RecyclerView.ViewHolder {

        TextView tv_foot;

        public FootHolder(View itemView) {
            super(itemView);
            tv_foot = itemView.findViewById(R.id.tv_foot);
        }
    }

}
