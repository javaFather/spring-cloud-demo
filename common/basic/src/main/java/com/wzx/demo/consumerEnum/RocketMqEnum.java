package com.wzx.demo.consumerEnum;

/**
 * rocketmq 订阅tag topic头
 * @author wangzx
 * @date 2018/5/16 15:50:33
 */

public class  RocketMqEnum {
    public enum Tag{
        TRAD("share","汇票");

        private String code;
        private String value;

        Tag(String code,String value){
            this.code = code;
            this.value = value;
        }

        public String getCode(){
            return code;
        }
        public String getValue() {
            return value;
        }
    }

    public enum Topic{
        TYPE("upLimit","龙虎榜");

        String code;
        String value;

        Topic(String code,String value){
            this.code =code;
            this.value =value;
        }
        public String getCode(){
            return code;
        }

        public String getValue() {
            return value;
        }
    }
}
