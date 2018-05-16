package com.wzx.rocketmq.common;

import com.wzx.demo.consumerEnum.RocketMqEnum;
import lombok.Data;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

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




}
