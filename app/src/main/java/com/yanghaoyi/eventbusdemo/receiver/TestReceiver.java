package com.yanghaoyi.eventbusdemo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.yanghaoyi.eventbusdemo.event.MessageEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * @author : YangHaoYi on 2019/9/12.
 * Email  :  yang.haoyi@qq.com
 * Description :广播接收器
 * Change : YangHaoYi on 2019/9/12.
 * Version : V 1.0
 */
public class TestReceiver extends BroadcastReceiver {

    /** 广播Action **/
    public static final String ACTION = "com.yanghaoyi.receive";
    /** 接收Key **/
    private static final String KEY_MSG = "KEY_MSG";

    @Override
    public void onReceive(Context context, Intent intent) {
        if(ACTION.equals(intent.getAction())){
            dealWithReceive(intent);
        }
    }

    /** 处理广播消息 **/
    private void dealWithReceive(Intent intent){
        if(null!=intent.getExtras()){
            String message = intent.getExtras().getString(KEY_MSG);
            MessageEvent messageEvent = new MessageEvent();
            messageEvent.setMessage(message);
            EventBus.getDefault().post(messageEvent);
        }
    }

}
