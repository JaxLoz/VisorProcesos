package com.per.visor_procesos;

import com.per.controller.Controlador;
import java.util.List;
import org.jutils.jprocesses.*;
import org.jutils.jprocesses.model.ProcessInfo;
import com.per.vista.Vista;


public class Visor_Procesos {

    public static void main(String[] args) {
        System.out.println("El usuario de la maquina es: "+System.getProperty("user.name"));
        
        Vista vista = new Vista();
        Controlador controller = new Controlador(vista);
        vista.setActionListener(controller);
        vista.setVisible(true);
        
       
         
           List<ProcessInfo> processesList = JProcesses.getProcessList();
           System.out.println(processesList.size());
    
    for (final ProcessInfo processInfo : processesList) {
        System.out.println("Process PID: " + processInfo.getPid());
        System.out.println("Process Name: " + processInfo.getName());
        System.out.println("Process Time: " + processInfo.getTime());
        System.out.println("User: " + processInfo.getUser());
        System.out.println("Virtual Memory: " + processInfo.getVirtualMemory());
        System.out.println("Physical Memory: " + processInfo.getPhysicalMemory());
        System.out.println("CPU usage: " + processInfo.getCpuUsage());
        System.out.println("Start Time: " + processInfo.getStartTime());
        System.out.println("Priority: " + processInfo.getPriority());
        System.out.println("Full command: " + processInfo.getCommand());
        System.out.println("------------------");
    }
      
    }
}
