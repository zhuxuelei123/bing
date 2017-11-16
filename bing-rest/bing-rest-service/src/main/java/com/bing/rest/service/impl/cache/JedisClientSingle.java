package com.bing.rest.service.impl.cache;

import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bing.rest.service.cache.JedisClient;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


/**
 * 
* @ClassName: JedisClientSingle 
* @Description:  redis缓存实现
* @author shenke  
* @date 2017年8月8日 下午1:24:05
 */
@Service
public class JedisClientSingle implements JedisClient{

	@Autowired
	private JedisPool jedisPool;

	@Override
	public String get(String key) {
		Jedis jedis = jedisPool.getResource();
		String msg = "";
		try {
			msg = jedis.get(key);
		} finally {
			jedis.close();
		}
		return msg;
	}

	@Override
	public String set(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		String msg = "";
		try {
			msg = jedis.set(key, value);
		} finally {
			jedis.close();
		}
		return msg;
	}

	public String set(String key, String value, int expire) {
		Jedis jedis = jedisPool.getResource();
		String msg = "";
		try {
			msg = jedis.set(key, value);
			if (expire != 0) {
				jedis.expire(key, expire);
			}
		} finally {
			jedis.close();
		}
		return msg;
	}

	@Override
	public String hget(String hkey, String key) {
		Jedis jedis = jedisPool.getResource();
		String msg = "";
		try {
			msg = jedis.hget(hkey, key);
		} finally {
			jedis.close();
		}
		return msg;
	}

	@Override
	public long hset(String hkey, String key, String value) {
		Jedis jedis = jedisPool.getResource();
		Long result = 0l;
		try {
			result = jedis.hset(hkey, key, value);
		} finally {
			jedis.close();
		}
		return result;
	}

	@Override
	public long incr(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = 0l;
		try {
			result = jedis.incr(key);
		} finally {
			jedis.close();
		}
		return result;
	}

	@Override
	public long expire(String key, int second) {
		Jedis jedis = jedisPool.getResource();
		Long result = 0l;
		try {
			result = jedis.expire(key, second);
		} finally {
			jedis.close();
		}
		return result;
	}

	@Override
	public long ttl(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = 0l;
		try {
			result = jedis.ttl(key);
		} finally {
			jedis.close();
		}
		return result;
	}

	@Override
	public Long hdel(String key, String fields) {
		Jedis jedis = jedisPool.getResource();
		Long result = 0l;
		try {
			result = jedis.hdel(key, fields);
		} finally {
			jedis.close();
		}
		return result;

	}

	@Override
	public Long del(String key) {
		Jedis jedis = jedisPool.getResource();
		Long result = 0l;
		try {
			result = jedis.del(key);
		} finally {
			jedis.close();
		}

		return result;
	}

	@Override
	public byte[] get(byte[] key) {
		byte[] value = null;
		Jedis jedis = jedisPool.getResource();
		value = jedis.get(key);
		jedis.close();
		return value;
	}

	@Override
	public byte[] set(byte[] key, byte[] value) {
		Jedis jedis = jedisPool.getResource();
		String msg = "";
		try {
			msg = jedis.set(key, value);
		} finally {
			jedis.close();
		}
		return msg.getBytes();
	}

	@Override
	public byte[] set(byte[] key, byte[] value, int expire) {
		Jedis jedis = jedisPool.getResource();
		String msg = "";
		try {
			msg = jedis.set(key, value);
			if (expire != 0) {
				jedis.expire(key, expire);
			}
		} finally {
			jedis.close();
		}
		return msg.getBytes();
	}

	@Override
	public void del(byte[] key) {
		Jedis jedis = jedisPool.getResource();
		try {
			jedis.del(key);
		} finally {
			jedis.close();
		}
	}

	@Override
	public void flushDB() {
		Jedis jedis = jedisPool.getResource();
		try {
			jedis.flushDB();
		} finally {
			jedis.close();
		}
	}

	/**
	 * size
	 */
	@Override
	public Long dbSize() {
		Jedis jedis = jedisPool.getResource();
		Long dbSize = 0L;
		try {
			dbSize = jedis.dbSize();
		} finally {
			jedis.close();
		}
		return dbSize;
	}

	@Override
	public Set<byte[]> keys(String pattern) {
		Jedis jedis = jedisPool.getResource();
		Set<byte[]> keys = null;
		try {
			keys = jedis.keys(pattern.getBytes());
		} finally {
			jedis.close();
		}
		return keys;
	}

	@Override
	public void dels(String pattern) {
		Set<byte[]> keys = null;
		Jedis jedis = jedisPool.getResource();
		try {
			keys = jedis.keys(pattern.getBytes());
			Iterator<byte[]> ito = keys.iterator();
			while (ito.hasNext()) {
				jedis.del(ito.next());
			}
		} finally {
			jedis.close();
		}
	}

}
