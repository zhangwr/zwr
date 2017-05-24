package com.mq.quene;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * rabbitMQ 连接池
 * 
 */
public class RabbitConnPooledObjectFactory extends BasePooledObjectFactory<RabbitConnection> {

	/**
	 * 连接工厂
	 */
	private ConnectionFactory connectionFactory;

	public RabbitConnPooledObjectFactory(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	@Override
	public RabbitConnection create() throws Exception {
		RabbitConnection conn = new RabbitConnection();
		Connection origalConn = connectionFactory.newConnection();
		conn.setConn(origalConn);
		conn.setChannel(origalConn.createChannel());
		return conn;
	}

	@Override
	public PooledObject<RabbitConnection> wrap(RabbitConnection obj) {
		return new DefaultPooledObject<RabbitConnection>(obj);
	}

	@Override
	public void destroyObject(PooledObject<RabbitConnection> p) throws Exception {
		RabbitConnection wrapConn = p.getObject();
		Channel channel = wrapConn.getChannel();
		if (channel != null) {
			try {
				channel.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (wrapConn != null) {
			try {
				wrapConn.getConn().close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
