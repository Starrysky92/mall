package com.qianfeng;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Administrator on 2017/9/22 0022.
 */
public class ConsumerMSg {
    public static void receiver(){
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        try {
            Connection con = factory.createConnection();
            con.start();
            Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue("first");
            MessageConsumer consumer = session.createConsumer(queue);
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    TextMessage msg= (TextMessage) message;
                    try {
                        System.out.println(msg.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        receiver();
    }
}
