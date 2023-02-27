package com.cloudheathtech.redis

import com.cloudhealthtech.java.clients.impl.RedisUpdateClientImpl
import com.typesafe.config.ConfigFactory

object Main {

    def main(args: Array[String]): Unit = {
        val config = ConfigFactory.load()
        val redisHost = config.getString("redis_host")
        val redisKey = config.getString("redis_key")
        val values = config.getString("values").split(",").toList
        val redisUpdateClientImpl = new RedisUpdateClientImpl(redisHost)
        if(config.getString("values").isEmpty) {
            println("Deleting the key")
            redisUpdateClientImpl.del(redisKey)
            println(s"deleted the key: $redisKey")
            println(s"values: ${redisUpdateClientImpl.smembers(redisKey)}")
        }
        else {
            println(s"Value already set in redis for $redisKey is ${redisUpdateClientImpl.smembers(redisKey)}")
            redisUpdateClientImpl.sadd(redisKey, values: _*)
            println(s"Updated value in redis for $redisKey is ${redisUpdateClientImpl.smembers(redisKey)}")
        }

    }
}