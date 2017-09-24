package com.qianfeng;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Administrator on 2017/9/22 0022.
 */
public class TopicsProducer {
    public static void send(){
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        factory.setTrustAllPackages(true);
        try {
            Connection con = factory.createConnection();
            Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic topic = session.createTopic("ticket");
            MessageProducer producer = session.createProducer(topic);
            Test test=new Test("a78",99);
            ObjectMessage message = session.createObjectMessage(test);
            producer.send(message);

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        send();
    }
}
