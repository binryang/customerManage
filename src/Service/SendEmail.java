package Service;

import domain.Customer;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by yangrb on 17-7-18.
 */
public class SendEmail extends Thread {
    //用于给用户发送邮件的邮箱
    private String from = "*********";

    //邮箱的用户名
    private String username = "bingo2here";

    //邮箱的独立密码
    private String password = "*******";

    //发送邮件的服务器地址
    private String host = "smtp.163.com";

    private Customer customer;

    public SendEmail(Customer customer){
        this.customer = customer;
    }

    //重写run方法的实现，在run方法中发送邮件给指定的用户

    @Override
    public void run() {
        try {
            Properties properties = new Properties();
            properties.setProperty("mail.host",host);
            properties.setProperty("mail.transport.protocol","smtp");
            properties.setProperty("mail.smtp.auth","true");
            Session session = Session.getInstance(properties);
            session.setDebug(true);
            Transport ts = session.getTransport();
            ts.connect(host,username,password);
            Message message = createEmail(session,customer);
            ts.sendMessage(message,message.getAllRecipients());
            ts.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 创建要发送的邮件
     */
    public Message createEmail(Session session,Customer customer) throws Exception{
        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress(from));
        mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress(customer.getEmail()));
        mimeMessage.setSubject("用户添加邮件");

        String info = customer.getName()+" 谢谢添加！";
        mimeMessage.setContent(info,"text/html;charset=UTF-8");
        mimeMessage.saveChanges();
        return mimeMessage;
    }
}
