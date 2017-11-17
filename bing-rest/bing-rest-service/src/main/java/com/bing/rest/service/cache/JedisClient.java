package com.bing.rest.service.cache;

import java.util.Set;

import org.springframework.stereotype.Service;

/**
 * 
* @ClassName: JedisClient 
* @Description:  redis缓存接口
* @author shenke  
* @date 2017年8月8日 下午1:24:18
 */

public interface JedisClient {
	
	String get(String key);

	String set(String key, String value);

	String hget(String hkey, String key);

	long hset(String hkey, String key, String value);

	long incr(String key);

	long expire(String key, int second);//设置有效期 

	long ttl(String key);//查询有效期

	Long hdel(String key, String value);
	
	//删除
	Long del(String key);

	byte[] get(byte[] key);

	void dels(String pattern);

	Set<byte[]> keys(String pattern);

	Long dbSize();

	void flushDB();

	void del(byte[] key);

	byte[] set(byte[] key, byte[] value, int expire);

	byte[] set(byte[] key, byte[] value);
	
}
