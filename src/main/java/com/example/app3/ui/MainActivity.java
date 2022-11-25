package com.example.app3.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app3.R;
import com.example.app3.fragment.dongtai.MainDongtaiActivity;
import com.example.app3.fragment.jingtai.FragmentJingtaiActivity;
import com.example.app3.fragment.tabvpgfgmt.MainTabViewPagerFgmtActivity;
import com.example.app3.frgtofrgmsg.MainFragmentActivity;
import com.example.app3.listviews.ui.GridViewActivity;
import com.example.app3.listviews.ui.ListViewActivity;
import com.example.app3.listviews.ui.RecyclerViewActivity;
import com.example.app3.listviews.ui.RecyclerViewActivity2;
import com.example.app3.listviews.ui.RecyclerViewSingleActivity;
import com.example.app3.listviews.ui.RecyvlerViewMultyActivity;
import com.example.app3.model.User;
import com.example.app3.fragment.viewpagerfgmt.MainViewPagerFgmtActivity;
import com.example.app3.sp.SPActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button
            btn_jingtai,
            btn_dongtai,
            btn_activity_value,
            btn_interface,
            btn_eventbus,
            btn_normal,
            btn_list,
            btn_singel_select,
            btn_multy_select,
            btn_hor_progress,
            btn_ring_progress,
            btn_bottom,
            btn_custom_half,
            btn_custom,
            btn_view_pager_fgmt,
            btn_tab_view_pager_fgmt,
            btn_lv,
            btn_gridv,
            btn_rv,
            btn_rv2,
            btn_rv_single,
            btn_rv_multy,
            btn_sp;
    final static String ATag  = "MainActivity";
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context =this;
        //context =MainActivity6.this;
//        getApplicationContext();
        Log.d(ATag,"onCreate");
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(ATag,"onCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(ATag,"onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(ATag,"onCreate");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(ATag,"onCreate");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(ATag,"onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(ATag,"onCreate");
    }


    private void initView() {
        btn_jingtai= findViewById(R.id.btn_jingtai_frg);
        btn_dongtai= findViewById(R.id.btn_dongtai_frg);
        btn_activity_value= findViewById(R.id.btn_activity_value);
        btn_interface= findViewById(R.id.btn_interface);
        btn_eventbus= findViewById(R.id.btn_eventbus);
        btn_view_pager_fgmt= findViewById(R.id.btn_view_pager_fgmt);
        btn_tab_view_pager_fgmt= findViewById(R.id.btn_tab_view_pager_fgmt);
        btn_normal= findViewById(R.id.btn_normal);
        btn_list= findViewById(R.id.btn_list);
        btn_singel_select=  findViewById(R.id.btn_singel_select);
        btn_multy_select=findViewById(R.id.btn_multy_select);
        btn_hor_progress=findViewById(R.id.btn_hor_progress);
        btn_ring_progress=findViewById(R.id.btn_ring_progress);
        btn_bottom=findViewById(R.id.btn_bottom);
        btn_custom_half=findViewById(R.id.btn_custom_half);
        btn_custom=findViewById(R.id.btn_custom);
//        findViewById(R.id.btn_normal);

        btn_lv=findViewById(R.id.btn_listview);
        btn_gridv=findViewById(R.id.btn_gridview);
        btn_rv=findViewById(R.id.btn_rv);
        btn_rv2=findViewById(R.id.btn_rv2);
        btn_rv_single=findViewById(R.id.btn_rv_single);
        btn_rv_multy=findViewById(R.id.btn_rv_mutlty);
        btn_sp=findViewById(R.id.btn_sp);

        btn_normal.setOnClickListener(this);
        btn_list.setOnClickListener(this);
        btn_singel_select.setOnClickListener(this);
        btn_multy_select.setOnClickListener(this);
        btn_hor_progress.setOnClickListener(this);
        btn_ring_progress.setOnClickListener(this);
        btn_bottom.setOnClickListener(this);
        btn_custom_half.setOnClickListener(this);
        btn_custom.setOnClickListener(this);

        btn_jingtai.setOnClickListener(this);
        btn_dongtai.setOnClickListener(this);
        btn_activity_value.setOnClickListener(this);
        btn_interface.setOnClickListener(this);
        btn_eventbus.setOnClickListener(this);
        btn_view_pager_fgmt.setOnClickListener(this);
        btn_tab_view_pager_fgmt.setOnClickListener(this);

        btn_lv.setOnClickListener(this);
        btn_gridv.setOnClickListener(this);
        btn_rv.setOnClickListener(this);
        btn_rv2.setOnClickListener(this::onClick);
        btn_rv_single.setOnClickListener(this);
        btn_rv_multy.setOnClickListener(this);

        btn_sp.setOnClickListener(this::onClick);
        BottomNavigationView bottomNavigationView;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_jingtai_frg:
                Intent intent1 =new Intent(context, FragmentJingtaiActivity.class);
                //intent1.setClass(context, FragmentJingtaiActivity.class);
                startActivity(intent1);
//                startActivityForResult();
                Toast.makeText(this,"eee",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_dongtai_frg:
                Intent intent2 =new Intent(context, MainDongtaiActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_activity_value:
                Intent intent3 =new Intent(context, MainFragmentActivity.class);
                startActivity(intent3);
                break;
            case R.id.btn_interface:
                Intent intent4 =new Intent(context, MainDongtaiActivity.class);
                startActivity(intent4);
                break;
            case R.id.btn_eventbus:
//                Intent intent5 =new Intent(context, FragmentJingtaiActivity.class);
//                startActivity(intent5);
                break;
            case R.id.btn_view_pager_fgmt:
                Intent intent5 =new Intent(context, MainViewPagerFgmtActivity.class);
                startActivity(intent5);
                break;
            case R.id.btn_tab_view_pager_fgmt:
                Intent intent6 =new Intent(context, MainTabViewPagerFgmtActivity.class);
                startActivity(intent6);
                break;

            case R.id.btn_normal:
                normalDialog();
                break;
            case R.id.btn_list:
                listDialog();
                break;
            case R.id.btn_singel_select:
                singleDialog();
                break;
            case R.id.btn_multy_select:
                multiDialog();
                break;
            case R.id.btn_custom_half:
                hanlfDialog();
                break;
            case R.id.btn_custom:
                cu_dialog();
                break;
            case R.id.btn_hor_progress:
                horDialog();
                break;
            case R.id.btn_ring_progress:
                break;
            case R.id.btn_bottom:
                break;
            case R.id.btn_listview:
                Intent intentListView =new Intent(context, ListViewActivity.class);
                startActivity(intentListView);
                break;
            case R.id.btn_gridview:
                Intent intentGV =new Intent(context, GridViewActivity.class);
                startActivity(intentGV);
                break;
            case R.id.btn_rv:
                Intent intentRV =new Intent(context, RecyclerViewActivity.class);
                startActivity(intentRV);
                break;
            case R.id.btn_rv2:
                Intent intentRV2 =new Intent(context, RecyclerViewActivity2.class);
                startActivity(intentRV2);
                break;
            case R.id.btn_rv_single:
                Intent intentRVSingle =new Intent(context, RecyclerViewSingleActivity.class);
                startActivity(intentRVSingle);
                break;
            case R.id.btn_rv_mutlty:
                Intent intentRVMulty =new Intent(context, RecyvlerViewMultyActivity.class);
                startActivity(intentRVMulty);
                break;
            case R.id.btn_sp:
                Intent intentSp =new Intent(context, SPActivity.class);
                startActivity(intentSp);
                break;

            default:
                break;
        }
    }

    private void horDialog() {
        ProgressDialog dialog =new ProgressDialog(context);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setMessage("正在加载中...");
        dialog.setMax(100);
        Timer timer =new Timer();
        timer.schedule(new TimerTask() {
            int  prgress =0;
            @Override
            public void run() {
                dialog.setProgress(++prgress);
                if (prgress >= 100){
                    timer.cancel();
                }
            }
        },500,1000);
        dialog.show();
    }

    public   void cu_dialog() {
        Dialog dialog = new Dialog(context,R.style.NormalDialogStyle);//
        View view =View.inflate(context,R.layout.dialog_custom,null);
        EditText etet =view.findViewById(R.id.etet);
        Button btnEnsure =view.findViewById(R.id.ensure_btn);
        Button btnCancel =view.findViewById(R.id.cancel_btn);
        dialog.setContentView(view);

        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
//        Display display =manager.getDefaultDisplay();
//        int h=display.getHeight();
//        int w=display.getWidth();
        //   System.out.println("h="+h+"---w="+w);

        //自定义view
        DisplayMetrics dm = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(dm);
        int ww = dm.widthPixels;// 获取屏幕分辨率宽度
        int hh = dm.heightPixels;// 获取屏幕分辨率高度
        System.out.println("hh="+hh+"---ww="+ww);
        Window window =dialog.getWindow();//decorview
        WindowManager.LayoutParams params= window.getAttributes();
        params.width=(int) (ww*0.8f);
        params.height=(int) (hh*0.3f);
        params.gravity= Gravity.CENTER;

        window.setAttributes(params);

        btnEnsure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"点击了确定按钮,自定义内容是："+etet.getText().toString(),Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void hanlfDialog() {
        View view =getLayoutInflater().inflate(R.layout.custom_half_dialog,null);
        TextView tv =view.findViewById(R.id.tv_c_h_d);
        AlertDialog dialog = new AlertDialog.Builder(context)//链式编程
                .setIcon(R.mipmap.wenhao)
                .setTitle("对话框标题")
                .setView(view)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"点击了确定按钮,自定义内容是："+tv.getText().toString(),Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"点击了取消按钮",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .create();
        dialog.show();
    }

    private void multiDialog() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        User user =new User();

        String[] items =list.toArray(new String[list.size()]);
        boolean[] whichSelectted= {false,true,true,false};

        AlertDialog dialog = new AlertDialog.Builder(context)//链式编程
                .setIcon(R.mipmap.wenhao)
                .setTitle("对话框标题")
                .setMultiChoiceItems(items, whichSelectted, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        Toast.makeText(context,"点击了"+items[which],Toast.LENGTH_SHORT).show();
                        whichSelectted[which]=isChecked;

//                        user.setName(items[which]);
//                        //dialog.dismiss();
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"点击了确定按钮",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"点击了取消按钮",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .create();
        dialog.show();
    }

    private void singleDialog() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        User user =new User();

        String[] items =list.toArray(new String[list.size()]);

        AlertDialog dialog = new AlertDialog.Builder(context)//链式编程
                .setIcon(R.mipmap.wenhao)
                .setTitle("对话框标题")
                .setSingleChoiceItems(items,3, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"点击了"+items[which],Toast.LENGTH_SHORT).show();
                        user.setName(items[which]);
                        //dialog.dismiss();
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"点击了确定按钮",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"点击了取消按钮",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .create();



        dialog.show();
    }

    private void listDialog() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        User user =new User();

        String[] items =list.toArray(new String[list.size()]);

        AlertDialog dialog = new AlertDialog.Builder(context)//链式编程
                .setIcon(R.mipmap.wenhao)
                .setTitle("对话框标题")
//                .setMessage("这里是提示内容")
//                .setCancelable(false)
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"点击了"+items[which],Toast.LENGTH_SHORT).show();
                        user.setName(items[which]);
                        //dialog.dismiss();
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"点击了确定按钮",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"点击了取消按钮",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .create();



        dialog.show();
    }

    private void normalDialog() {
        AlertDialog dialog = new AlertDialog.Builder(context)//链式编程
                .setIcon(R.mipmap.wenhao)
                .setTitle("对话框标题")
                .setMessage("这里是提示内容")
                .setCancelable(false)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"点击了确定按钮",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"点击了取消按钮",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .create();



        dialog.show();
    }
}