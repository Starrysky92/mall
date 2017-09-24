package com.qianfeng;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Administrator on 2017/9/22 0022.
 */
//发送者
public class ProducerMsg {
    public static void main(String[] args) {
        send();
    }
    public static void send(){
        //创建链接工厂
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        try {
            //建立连接
            Connection con = factory.createConnection();
            //会话
            Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //队列
            Queue queue = session.createQueue("first");
            //消息生产者
            MessageProducer producer = session.createProducer(queue);
            //消息
            TextMessage message = session.createTextMessage("hello word!");
           //发送
            producer.send(message);
            session.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
