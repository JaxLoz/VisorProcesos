package com.per.dao;

import com.per.model.InfoProcess;
import java.sql.*;
import com.per.poolConnection.connectionFactory;
import javax.sql.DataSource;


public class procesoDao {
    
    final private DataSource dataSource;
    
    public procesoDao(DataSource dataSource){
        this.dataSource = dataSource;
    }
    
    public int registrarCatalogo (String nombreCatalogo){
        
        String sql = "INSERT INTO catalogo (nombre_catalogo) values (?)";
        int idCatalogo = 0;
        
        try(Connection con = dataSource.getConnection()){
            PreparedStatement preStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            try(preStatement){
               preStatement.setString(1, nombreCatalogo);
               preStatement.execute();
               
               ResultSet resulset = preStatement.getGeneratedKeys();
               
               try(resulset){
                   while(resulset.next()){
                       idCatalogo = resulset.getInt(1);
                   }
               }
            }
            
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        
        System.out.println("se registro el catalogo con el ID:" + idCatalogo);
        return idCatalogo;
    }
    
    public void guardadProcesos (InfoProcess proceso, String nombreCatalogo, int idcatalogo){
        
        int idCatalogo = idcatalogo;
        
        String sql = "INSERT INTO proceso (pid, nombre, usuario, descripcion, prioridad, uso_memoria, uso_cpu, catalogo_idcatalogo) values (?,?,?,?,?,?,?,?)";
        
        try(Connection con = dataSource.getConnection()){
           
            PreparedStatement preStatemen = con.prepareStatement(sql);
            
            try(preStatemen){
            
                preStatemen.setInt(1, proceso.getPid());
                preStatemen.setString(2, proceso.getName());
                preStatemen.setString(3, proceso.getUser());
                preStatemen.setString(4, proceso.getCommand());
                preStatemen.setInt(5, proceso.getPriority());
                preStatemen.setInt(6, proceso.getPhysicalMemory());
                preStatemen.setInt(7, proceso.getCpuUsage());
                preStatemen.setInt(8, idCatalogo);
                preStatemen.execute();
            
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        
    
    
        
        
    }
}
