package vasyurin.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class CustomDataSource {

    private final BlockingQueue<Connection> pool;

    public CustomDataSource(String url, String username, String password, int poolSize) throws SQLException {
        this.pool = new ArrayBlockingQueue<>(poolSize);

        for (int i = 0; i < poolSize; i++) {
            Connection connection = DriverManager.getConnection(url, username, password);

            ProxyConnection proxyConnection = new ProxyConnection(connection,pool);
            pool.add(proxyConnection);
        }
        System.out.println("Custom DataSource initialized");
    }

    public Connection getConnection() throws InterruptedException {
        Connection connection = pool.take();
        System.out.println("Connection take from pool " + pool.size());
        return connection;
    }


}
