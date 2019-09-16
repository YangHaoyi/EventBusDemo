package com.yanghaoyi.eventbusdemo.event;

/**
 * @author : YangHaoYi on 2019/9/16.
 * Email  :  yang.haoyi@qq.com
 * Description : Event事件
 * Change : YangHaoYi on 2019/9/16.
 * Version : V 1.0
 */
public class MessageEvent {

    /** 消息 **/
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
