package top.sinfonia.demo.mq.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author singoasher
 * @date 2018/6/22
 */
@Component
public class DemoCommandLineRunner implements CommandLineRunner {
    private JmsTemplate jmsTemplate;

    @Autowired
    public DemoCommandLineRunner(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        jmsTemplate.send(DemoJmsConstants.JMS_LISTENER_DESTINATION_APP_START, new DemoMessageCreator(args));
    }
}
