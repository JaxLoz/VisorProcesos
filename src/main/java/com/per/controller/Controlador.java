package com.per.controller;

import com.per.dao.procesoDao;
import com.per.model.InfoProcess;
import com.per.vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.jutils.jprocesses.JProcesses;
import org.jutils.jprocesses.model.ProcessInfo;
import com.per.exception.DoubleSelectionException;
import com.per.poolConnection.connectionFactory;

public class Controlador implements ActionListener{
  
    private Vista vista;
    private procesoDao procesoDAO;
    private connectionFactory conFactory; 
   
    public Controlador (Vista vista){
        this.vista = vista;
        conFactory = new connectionFactory();
        this.procesoDAO = new procesoDao(conFactory.obtenerDataSource());
    }
    
    public void IniciarControlador (){
        vista.setActionListener(this);
    }
    
    public String nombreCatalogo (){
        return vista.nombreCatalogo();
    }
    
    public int cantidadProcesos (){
        return vista.cantidadDeProcesos();
    }
    
     public boolean porUsoMemoria (){
        return vista.seleccionadoUsoMemoria();
    }
    
    public boolean porUsoCpu (){
        return vista.seleccionadoUsoCpu();
    }
    
    public List<InfoProcess> crearListaProcesos (){
        
        List<ProcessInfo> procesoslista = JProcesses.getProcessList();
        List<InfoProcess> listProcess = new ArrayList<>();
        
        for(ProcessInfo proceso : procesoslista){
            InfoProcess infoProceso = new InfoProcess();
            
            infoProceso.setPid(Integer.parseInt(proceso.getPid()));
            infoProceso.setName(proceso.getName());
            infoProceso.setUser(proceso.getUser());
            infoProceso.setVirtualMemory(proceso.getVirtualMemory());
            infoProceso.setPhysicalMemory(Integer.parseInt(proceso.getPhysicalMemory()));
            infoProceso.setCpuUsage(proceso.getCpuUsage());
            infoProceso.setStartTime(proceso.getStartTime());
            infoProceso.setPriority(Integer.parseInt(proceso.getPriority()));
            infoProceso.setCommand(proceso.getCommand());
            
            listProcess.add(infoProceso);
        }
        
        return listProcess;
    }
    
    
    
    public List<InfoProcess> listaProcesos (List<InfoProcess> lista){
        
        List<InfoProcess> ListProcessMemory = new ArrayList<>();
        int cantidadProcesos = vista.cantidadDeProcesos();
        
        for (int i = 0; i < cantidadProcesos; i++){
            ListProcessMemory.add(i, lista.get(i));
        }
        
        return ListProcessMemory;
    }
    
    public void CargarListaProcesos (){
        
        System.out.println("la lista de procesos del nuevo modelo tiene: "+crearListaProcesos().size());
        vista.cargarTodosLosProcesos(crearListaProcesos());
    }
    
    
    public List<InfoProcess> OrdenarListaProcesosPorGastoMemory (){
        List<InfoProcess> ProcessMemory =  crearListaProcesos().stream()
                .sorted((a, b) -> b.getPhysicalMemory() - a.getPhysicalMemory())
                .collect(Collectors.toList());
        
        List<InfoProcess> ListProcessMemory = listaProcesos(ProcessMemory);
        return ListProcessMemory;
    }
    
    public List<InfoProcess> OrdenarListaProcesosPorGastoCpu (){
        List<InfoProcess> ListProcessCpu = crearListaProcesos().stream()
                .sorted((a, b) -> b.getCpuUsage() - a.getCpuUsage())
                .collect(Collectors.toList());
        
         List<InfoProcess> ListaProcessCpu = listaProcesos(ListProcessCpu);
         return ListaProcessCpu;
    }
    
    
    public void cargarListaProcesosGastoMemory (){
        vista.cargarProcesos(this.OrdenarListaProcesosPorGastoMemory());
    }
    
    public void cargarListaProcesosGastoCpu (){
        vista.cargarProcesos(this.OrdenarListaProcesosPorGastoCpu());
    }
   
    
    public void GuardarCatalogo (){
        
        String nombreCatalogo = nombreCatalogo();
        int idCatalogo = procesoDAO.registrarCatalogo(nombreCatalogo);
        
        List<InfoProcess> listaProcesos = vista.obtenerProcesosListados();
        
        for(InfoProcess proceso: listaProcesos){
            procesoDAO.guardadProcesos(proceso, nombreCatalogo, idCatalogo);
        }
        
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String command = e.getActionCommand();
        
        if(command.equals("Escanear") && !porUsoMemoria() && !porUsoCpu()){
            System.out.println("Se esta precionando el boton de escanear");
            this.CargarListaProcesos();
        }else if(command.equals("Escanear") && porUsoMemoria() && !porUsoCpu()){
            this.cargarListaProcesosGastoMemory();
        
        }else if(command.equals("Escanear") && porUsoCpu() && !porUsoMemoria()){
            this.cargarListaProcesosGastoCpu();
        
        }else if(command.equals("Escanear") && porUsoCpu() && porUsoMemoria()){
            throw new DoubleSelectionException("Esta seleccionando los filtros Uso de CPU y uso de memoria al mismo tiempo");
        }else if(command.equals("Guardar")){
            this.GuardarCatalogo();
        }
        
    }
    
    
}
