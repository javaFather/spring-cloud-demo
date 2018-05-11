import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 * @author YM10174
 * @date 2018/5/8 14:47:33
 */
@Component
public class JedisLock {
    /**返回状态**/
    private static final String LOCK_SUCCESS="OK";
    /**如果key不存在就插入**/
    private static final String SET_IF_NOT_EXIST ="NX";
    /**设置生效时间 与time配合使用**/
    private static final String SET_WITH_EXPIRE_TIME ="PX";
    /**解锁成功标识**/
    private static final Long RELEASE_SUCCESS = 1L;
    @Bean
    @Primary //系统中有多个jedis实例以这个为主
    public Jedis getJedis(){
        Jedis jedis = new Jedis("172.16.235.131",6379);
        return jedis;
    }


    /**
     * 分布式锁,加锁
     * @param
     * @author wangzx
     * @date 2018/5/8 18:04
     */

    private boolean lock(String key, String requestId, int time){
        String result = (this.getJedis()).set(key, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, time);
        if(LOCK_SUCCESS.equals(result)){
            return true;
        }
        return false;
    }

    /**
     * 解锁
     * @param jedis
     * @param key
     * @param requestId
     * @return
     */
    private boolean unLock(Jedis jedis,String key,String requestId){
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = (this.getJedis()).eval(script, Collections.singletonList(key), Collections.singletonList(requestId));
        if(RELEASE_SUCCESS.equals(result)){
            return true;
        }
        return false;
    }

}
