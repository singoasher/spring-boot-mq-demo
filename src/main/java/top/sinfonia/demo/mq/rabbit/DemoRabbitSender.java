package top.sinfonia.demo.mq.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.sinfonia.demo.mq.domain.model.User;
import top.sinfonia.demo.mq.infrastructure.constant.DemoConstants;

/**
 * @author singoasher
 * @date 2018/6/22
 */
@Component
public class DemoRabbitSender {
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public DemoRabbitSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendToDemoRabbitListener(String message) {
        rabbitTemplate.convertAndSend(DemoConstants.RABBIT_LISTENER_DESTINATION_DEMO, message);
    }

    public void send(User user) {
        rabbitTemplate.convertAndSend(DemoConstants.RABBIT_USER_QUEUE, user);
    }

    public void sendToTopicDemo1(User user) {
        rabbitTemplate.convertAndSend(DemoConstants.RABBIT_TOPIC_DEMO_EXCHANGE, DemoConstants.RABBIT_TOPIC_DEMO1_ROUTING_KEY, user);
    }

    public void sendToTopicDemo2(User user) {
        rabbitTemplate.convertAndSend(DemoConstants.RABBIT_TOPIC_DEMO_EXCHANGE, DemoConstants.RABBIT_TOPIC_DEMO2_ROUTING_KEY, user);
    }

    public void sentToFanoutDemo(User user) {
        rabbitTemplate.convertAndSend(DemoConstants.RABBIT_FANOUT_DEMO_EXCHANGE, null, user);
    }
}
