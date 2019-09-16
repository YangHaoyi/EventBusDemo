package com.yanghaoyi.eventbusdemo.activity;

import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.yanghaoyi.eventbusdemo.R;
import com.yanghaoyi.eventbusdemo.event.MessageEvent;
import com.yanghaoyi.eventbusdemo.receiver.TestReceiver;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * @author : YangHaoYi on 2019/9/12.
 * Email  :  yang.haoyi@qq.com
 * Description :广播EventBus测试Demo
 *              adb广播 adb shell am broadcast -a com.yanghaoyi.receive --es KEY_MSG "this is test string"
 * Change : YangHaoYi on 2019/9/12.
 * Version : V 1.0
 */
public class MainActivity extends AppCompatActivity {

    /** 消息改变测试文本 **/
    private TextView tvMessage;
    /** 广播接收器 **/
    private TestReceiver testReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    /** 初始化 **/
    private void init(){
        initRegister();
        initView();
    }

    /** 初始化注册监听 **/
    private void initRegister(){
        EventBus.getDefault().register(this);
        //8.0以上静态注册广播失效，建议全部使用动态注册
        registerReceiver();
    }

    /** 初始化View **/
    private void initView(){
        tvMessage = findViewById(R.id.tvMessage);
    }

    /** 注册广播 **/
    private void registerReceiver(){
        testReceiver = new TestReceiver();
        IntentFilter intentFilter = new IntentFilter(TestReceiver.ACTION);
        registerReceiver(testReceiver, intentFilter);
    }

    /** Event事件 **/
    @Subscribe
    public void onTestEvent(MessageEvent event){
        tvMessage.setText(event.getMessage());
    }

    /** 解注册 **/
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(testReceiver);
        EventBus.getDefault().unregister(this);
    }
}
