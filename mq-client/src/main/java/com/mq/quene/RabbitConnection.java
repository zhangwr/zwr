package com.mq.quene;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * 
 * 封装rabbitmq的连接,采用连接池
 */
public class RabbitConnection {

	/**
	 * 连接
	 */
	private Connection conn;

	/**
	 * 管道
	 */
	private Channel channel;

	/**
	 * 服务器地址
	 */
	@SuppressWarnings("unused")
	private String hostAddr;

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public String getHostAddr() {
		return this.hostAddr = conn.getAddress().getHostAddress();
	}

	public void setHostAddr(String hostAddr) {
		this.hostAddr = hostAddr;
	}

	@Override
	public String toString() {
		return "server: " + this.getHostAddr();
	}

}
