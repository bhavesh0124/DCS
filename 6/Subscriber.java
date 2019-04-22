/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.Connection;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.jms.Topic;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
/**
 *
 * @author chanchalroshan
 */
public class Subscriber {
    private static String url= ActiveMQConnection.DEFAULT_BROKER_URL;
    
    public static void main(String args[]) throws JMSException{
        
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("testt");
        MessageConsumer consumer = session.createConsumer(topic);
        MessageListener listener = new MessageListener() {
            @Override
            public void onMessage(Message msg) {
                
                try{
                    if(msg instanceof TextMessage){
                        TextMessage textMessage = (TextMessage) msg;
                        System.out.println("Received Message: " + textMessage.getText()+ " ");
                    }
                }catch(JMSException e){
                    System.out.println("Caught: "+e);
                    e.printStackTrace();
                }
                
            }
        };
        
        consumer.setMessageListener(listener);
        try{
            System.in.read();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
