package com.per.poolConnection;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;


public class connectionFactory {
    
    private DataSource poolConnection;
    
    public connectionFactory(){
        
        ComboPooledDataSource poolDataSource = new ComboPooledDataSource();
        poolDataSource.setJdbcUrl("jdbc:mysql://localhost/db_procesos?userTimeZone=true&serverTimeZone=UTC");
        poolDataSource.setUser("root");
        poolDataSource.setPassword("Cr@fteo12");
        poolDataSource.setMaxPoolSize(10);
        this.poolConnection = poolDataSource;
    }
    
    public DataSource obtenerDataSource (){
        return poolConnection;
    }
}
