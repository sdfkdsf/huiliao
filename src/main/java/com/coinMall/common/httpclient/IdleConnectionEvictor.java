package com.coinMall.common.httpclient;

import org.apache.http.conn.HttpClientConnectionManager;
/**
 * 处理关闭连接的线程
 */
public class IdleConnectionEvictor extends Thread{
	
    private final HttpClientConnectionManager connManager;

    private volatile boolean shutdown;

    public IdleConnectionEvictor(HttpClientConnectionManager connManager) {
        this.connManager = connManager;
        this.start();
    }

    @Override
    public void run() {
        try {
            while (!shutdown) {
                synchronized (this) {
                    wait(5000);
                    connManager.closeExpiredConnections(); // 关闭失效的连接
                }
            }
        } catch (InterruptedException ex) {
            // 结束
        }
    }

    /**
     * 关闭清理无效连接的线程
     */
    public void shutdown() {
        shutdown = true;
        synchronized (this) {
            notifyAll();
        }
    }
}
