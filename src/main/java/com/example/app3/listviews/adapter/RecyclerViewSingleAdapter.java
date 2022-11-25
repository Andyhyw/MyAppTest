package com.example.app3.listviews.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.app3.R;
import com.example.app3.listviews.model.RvSingleData;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewSingleAdapter extends RecyclerView.Adapter {
        /* new RecyclerView.Adapter() 可以转移到单独的文件里去
         * 在Adapter（）内部： 点击右键 - Refactor(重构) - Move -移到一个类里面去.
         * 它会全自动的把匿名类 提取成一个内部类。
         *
         * 之后再继续移动到一个单独的文件里面。
         */
        class ViewHoler extends RecyclerView.ViewHolder {
            private View root; //暂无意义，参考上面案例，可以实现与外界连接
            private TextView tvTitle,tvContent;

    public ViewHoler(View root) {
                super(root);
                //我们知道传进来的布局就是list_cell;创建之后就可以获取到这两个控件。
                tvTitle = root.findViewById(R.id.tv_title);
                tvContent = root.findViewById(R.id.tv_content);
            }
            //需要添加两个get方法被外界访问到的
    public TextView getTvTitle() {
                return tvTitle;
            }

    public TextView getTvContent() {
                return tvContent;
            }
        }

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            /*
             *之后要创建View，不是new TextView（）我们要换种方式，根据一个资源进行创建，使用LayoutInflater.from
             * LayoutInflater : 布局解释器，用布局解释器解析一个布局,布局首先传进来的是一个资源，资源就是建立的cell
             * 第二项：是我们创建的布局的根对象，这里传 null ,通过这种方式我们就创建了这种布局。然后获取控件
             */
            return new ViewHoler(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_single,null));
        }

        @Override//分别来进行配置 //我们来创建一个数据对象。创建构造函数
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ViewHoler vh = (ViewHoler) holder;
            //首先获取到这些数据
            RvSingleData cd = data[position];
            vh.getTvTitle().setText(cd.title);
            vh.getTvContent().setText(cd.title);
        }

        //创建完对象之后，它是一个RvSingleData[]
        private RvSingleData[]data = new RvSingleData[]{new RvSingleData("周杰伦","双节棍"),new RvSingleData("周杰伦","以父之名")};

        @Override
        public int getItemCount() {
            return data.length;
        }


    }

    //创建一个数据对象的
//列表项数据

