package com.example.app3.service.aidl;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.example.app3.IMyAidlInterface;
import com.example.app3.service.IAidlService;

public class AIDLService extends Service {
	//字义一个字符串数组，用于从该数组中获取随机字符串
	String[] tests =new String[]{
			"坚持",
			"奋斗",
			"淡泊"
	};
	private String test;	//随机字符串属性
	private int ran;
	//创建ITextService.Stub的实例，并实现ITestService中的方法
	private final IAidlService.Stub mBinder= new IAidlService.Stub() {

		@Override
		public String getTest() throws RemoteException {
			return test;
		}

		@Override
		public int getValue() throws RemoteException {
			return ran;
		}

	};
	//重写远程绑定方法
	@Override
	public IBinder onBind(Intent arg0) {
		Log.i("AIDLService","远程绑定：AIDLService");	//输出日志信息
		return mBinder;		//返回IBinder对象
	}
	@Override
	public void onCreate() {
		super.onCreate();
		Thread thread =new Thread(new Runnable() {
			@Override
			public void run() {
					int i=0;
					while (i<=20) {
						int index = new Random().nextInt(3);    //生一个0-2的随机整数
						test = tests[index];    //从数字中取出对应的字符串
						Log.i("AIDLService输出：", test);    //将获取的随机字符串输出到LogCat中
						i++;
						try {
							Thread.sleep(2000);

						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
			}
		});
		thread.start();


		//定时任务
		Timer timer = new Timer();
		timer.schedule(new TimerTask()
		{
			int i=0;
			@Override
			public void run()
			{

				while (i<=20) {
					int index = new Random().nextInt(3);    //生一个0-2的随机整数
					ran = index;    //从数字中取出对应的字符串
					i++;
					Log.i("AIDLServiceTimer输出：", ran + "");    //将获取的随机字符串输出到LogCat中
				}
			}
		}, 0, 40000);

	}
	//重写解除绑定方法
	@Override
	public boolean onUnbind(Intent intent) {
		Log.i("AIDLService","取消远程绑定：AIDLService");	//输出日志信息
		return false;
	}


}
