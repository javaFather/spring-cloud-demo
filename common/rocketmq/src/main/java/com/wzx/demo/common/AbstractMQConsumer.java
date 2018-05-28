package com.wzx.demo.common;

import com.wzx.demo.consumerEnum.RocketMqEnum;
import lombok.Data;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListener;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * @author YM10174
 * @date 2018/5/15 17:08:33
 */
@Data
public abstract class AbstractMQConsumer {
    private final Logger LOGGER = LoggerFactory.getLogger(AbstractMQConsumer.class);

    private DefaultMQPushConsumer mqPushConsumer;
    /**消费者组名**/
    private String consumerGroup;
    private String nameAddr;
    private ConsumeFromWhere consumeFromWhere = ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET;
    private boolean isStarted;
    private int delayLevelWhenNextConsume = 0;

    private String topics;

    private String nameServer;

    private MessageListener listener;

    public AbstractMQConsumer(){}

    public AbstractMQConsumer(String consumerGroup,String nameAddr){
        this.consumerGroup = consumerGroup;
        this.nameAddr = nameAddr;
    }

    /**
     * 订阅头
     * @param set
     */
    public abstract void setSubscribeTag(Set<RocketMqEnum> set);

    /**
     * 收到的消息进行消费 true表示成功
     * @param msgExt
     * @return
     */
    public abstract boolean consumerMsg(MessageExt msgExt);

    /**
     *  MQ的消费类
     * @param
     * @author wangzx
     * @date 2018/5/23 15:28
     */

    public void init() {
        mqPushConsumer = new DefaultMQPushConsumer(consumerGroup);
        mqPushConsumer.setNamesrvAddr(nameServer);
        try {
            mqPushConsumer.subscribe(topics, "*");
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        mqPushConsumer.setInstanceName(UUID.randomUUID().toString());
        mqPushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        mqPushConsumer.registerMessageListener((MessageListenerConcurrently) this.listener);

        try {
            mqPushConsumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        System.out.println("消息队列启动! group=" + mqPushConsumer.getConsumerGroup() + " instance=" + mqPushConsumer.getInstanceName()
        );
    }

      /**
       *  MQ消息的监听接口类
       * @param
       * @author wangzx
       * @date 2018/5/23 15:28
       */
        public class RocketMQListener implements MessageListenerConcurrently {
        @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
//        System.out.println("get data from rocketMQ:" + msgs);
                for (MessageExt message : msgs) {

                    String msg = new String(message.getBody());
                    System.out.println("msg data from rocketMQ:" + msg);
                }

                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        }




}
