package com.turtlebot.operation.service.redis;

import redis.clients.jedis.Jedis;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 描述:
 *
 * @outhor didonglin
 * @create 2018-03-19 16:57
 */
public class RedisServer {

    private static String redisIP;

    static {
        InputStream inputStream = RedisServer.class.getResourceAsStream("/redis.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            redisIP = properties.getProperty("redis.ip");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRedisIP() {
        return redisIP;
    }

    public void setRedisIP(String redisIP) {
        this.redisIP = redisIP;
    }



    public void redisStartTest() {

        //连接本地的 Redis 服务
        //System.out.println(this.getRedisIP());
        Jedis jedis = new Jedis(this.getRedisIP());
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
    }

    public static void main(String[] args) {
        new RedisServer().redisStartTest();
    }
}