package cn.com.sparknet.malltiny01.service;


/**
 * redis操作Service,
 * 对象和数组都以json形式进行存储
 * Created by macro on 2018/8/7.
 */
public interface RedisService {

    void set(String key, String value);

    String get(String key);


    boolean expire(String key, long expire);


    void remove(String key);


    Long increment(String key, long delta);

}

