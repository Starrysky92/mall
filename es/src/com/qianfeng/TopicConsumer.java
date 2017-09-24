package com.qianfeng;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Administrator on 2017/9/22 0022.
 */
public class TopicConsumer {
    public static void main(String[] args) {
        recive();
    }
    public static void recive(){
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        factory.setTrustAllPackages(true);
        try {
            Connection con = factory.createConnection();
            con.start();
            Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic ticket = session.createTopic("ticket");
            MessageConsumer consumer = session.createConsumer(ticket);
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    ObjectMessage msg= (ObjectMessage) message;
                    try {
                        Test test= (Test) msg.getObject();
                        System.out.println(test.getNum());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
