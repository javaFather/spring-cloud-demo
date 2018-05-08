import redis.clients.jedis.Jedis;

/**
 * @author YM10174
 * @date 2018/5/8 14:47:33
 */
public class JedisLock {
    /**返回状态**/
    private static final String LOCK_SUCCESS="OK";
    /**如果key不存在就插入**/
    private static final String SET_IF_NOT_EXIST ="NX";
    /**设置生效时间 与time配合使用**/
    private static final String SET_WITH_EXPIRE_TIME ="PX";

    /**
     * 分布式锁
     * @param
     * @author wangzx
     * @date 2018/5/8 18:04
     */

    public boolean lock( String key, String requestId, int time){
        Jedis jedis = new Jedis("172.16.235.131",6379);
        String result = jedis.set(key, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, time);
        if(LOCK_SUCCESS.equals(result)){
            return true;
        }
        return false;
    }

}
