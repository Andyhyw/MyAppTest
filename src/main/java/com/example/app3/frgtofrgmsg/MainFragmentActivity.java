package com.example.app3.frgtofrgmsg;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.app3.R;
import com.example.app3.interfce.ILeftCallBack;
import com.example.app3.interfce.IRightCallBack;
import com.example.app3.interfce.MessageListener;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * 这种方式是两个fragment直接通信的。（不推荐使用）
 */
public class MainFragmentActivity extends FragmentActivity implements MessageListener , View.OnClickListener{

    private FragmentManager manager;
    private FragmentTransaction transaction;

    Button btn1,btn2;
    TextView textTitle;
    LeftFragment leftFragment;
    RightFragment rightFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main_2);



        /*获取manager*/
        manager = this.getSupportFragmentManager();
        /*创建事物*/
        transaction = manager.beginTransaction();
        /*创建leftFragment*/
         leftFragment = new LeftFragment();
//        Bundle bundle =new Bundle();
//        bundle.putString("KK","acti--leftt");
//        leftFragment.setArguments(bundle);
        /*创建RightFragment*/
         rightFragment = new RightFragment();
        /*通过事物把两个fragment分别添加到对应的容器中*/
        transaction.add(R.id.left, leftFragment, "left");
        transaction.add(R.id.right, rightFragment, "right");

        /*提交事物*/
        transaction.commit();

        initView();

//        Bundle bundle =new Bundle();
//        bundle.putString("KK","acti--leftt");
//        getSupportFragmentManager().getFragments();//获取activity里面所有的fragments
//      leftFragment1.setArguments(bundle);

    }

    private void initView() {
        textTitle =findViewById(R.id.tv_title);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn1.setOnClickListener(this::onClick);
        btn2.setOnClickListener(this::onClick);
    }


    @Override
    public void sendMessage(String message) {
        LeftFragment leftFragment1=(LeftFragment)  getSupportFragmentManager().findFragmentById(R.id.left);
        leftFragment1.setTextView("activity--to--left");

    }

    /**
     *activity-->fragment     先找到对应传值的fragment对象   静态注册的用id  动态加载用tag，在调用对应fragment里面的方法
     * fragment <-->fragment  先找到对应传值的fragment对象   静态注册的用id  动态加载用tag，在调用对应fragment里面的方法
     * fragment --->activity  接口的形式   先定义一个借口，在fragment里面写一个带有接口参数的public方法，
     *                        在activity里面得到对应fragment的实例，用这个fragment实例调用fragment里面的这带接口参数的方法。
     */

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                leftFragment.sendMessage(new ILeftCallBack() {
                    @Override
                    public void getMessageFromLeft(String left) {
                        textTitle.setText(left);
                    }
                });
                LeftFragment leftFragment1=(LeftFragment)  getSupportFragmentManager().findFragmentById(R.id.left);
                leftFragment1.setTextView("activity--to--left");
                break;
            case R.id.btn2:
                rightFragment.sendMessage(new IRightCallBack() {
                    @Override
                    public void getMessageFromRight(String right) {
                        textTitle.setText(right);
                    }
                });
                break;
        }

    }
}
