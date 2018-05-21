package com.wzx.demo.rocketmq.common;

import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.function.Function;

/**
 * @author YM10174
 * @date 2018/5/8 14:47:33
 */
public class JedisLock {
    /**
     * 返回状态
     **/
    private static final String LOCK_SUCCESS = "OK";
    /**
     * 如果key不存在就插入
     **/
    private static final String SET_IF_NOT_EXIST = "NX";
    /**
     * 设置生效时间 与time配合使用
     **/
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    /**
     * 解锁成功状态码
     **/
    private static final Long RELEASE_SUCCESS = 1L;

    private static final String LOCK_PREFIX = "LOCK_";

    /**
     * 分布式锁,上锁
     *
     * @param
     * @author wangzx
     * @date 2018/5/8 18:04
     */

    public boolean lock(Jedis jedis, String key, String requestId, Integer time) {
        String result = jedis.set(LOCK_PREFIX + key, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, time);
        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }

    /**
     * 解锁
     *
     * @param jedis
     * @param key
     * @param requestId
     * @return
     */
    public boolean unLock(Jedis jedis, String key, String requestId) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(LOCK_PREFIX + key), Collections.singletonList(requestId));

        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }

    /**
     * 如果已经存在锁，不阻塞
     *
     * @param callback
     * @param key
     * @param time
     * @param <R>
     * @return
     */
    public <R> R tryLock(Function<Boolean, R> callback, String key, int time) {
        //之前没锁
        Boolean isLocked = lock(null, key, "", time);
        try {
            return callback.apply(!isLocked);
        } catch (Exception e) {
            throw new RuntimeException("xx");
        } finally {
            // 本次上锁
            if (isLocked) {
                unLock(null, key, null);
            }
        }


    }

    public <R> R tryLock(Function<Boolean, R> callback, String key) {
        return tryLock(callback, key, 5000);
    }

    public static void main(String[] args) {

    }
    public int newUpdate(){
        return tryLock((isLocked)->{
            if(isLocked){
                //如果上锁成功
                return 1;
            }
            return 2;
        },"key");
    }
    public int newUpdate2(){
        return tryLock(new Function<Boolean, Integer>() {
            @Override
            public Integer apply(Boolean isLocked) {
                if(isLocked){
                    //如果上锁成功
                    return 1;
                }
                return 2;
            }
        },"key");
    }

    public int update() {
        lock(null, "key", "", 0);
        int result;
        // TODO: 2018/5/9
        result = 9;
        unLock(null, "key", "");

        return result;
    }

}
