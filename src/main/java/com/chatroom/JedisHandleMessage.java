package com.chatroom;
import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisHandleMessage {
	// 此範例key的設計為(發送者名稱:接收者名稱)，實際應採用(發送者會員編號:接收者會員編號)

	private static JedisPool pool = JedisPoolUtil.getJedisPool();
	public static List<String> getHistoryMsg(String sender, String receiver) {
		String key = new StringBuilder(sender).append(":").append(receiver).toString();
		if(key.length()==0 || key == null)
		{
			return null;
		}
		Jedis jedis = pool.getResource();
		
		System.out.println(jedis);
		List<String> historyData = jedis.lrange(key, 0, -1);
System.out.println(historyData);
for(String liStr:historyData)
{
	System.out.println(liStr);
}
		jedis.close();
		return historyData;
	}

	public static void saveChatMessage(String sender, String receiver, String message) {
		// 對雙方來說，都要各存著歷史聊天記錄
		String senderKey = new StringBuilder(sender).append(":").append(receiver).toString();
		String receiverKey = new StringBuilder(receiver).append(":").append(sender).toString();
		Jedis jedis = pool.getResource();
		jedis.rpush(senderKey, message);
		jedis.rpush(receiverKey, message);

		jedis.close();
	}

}
