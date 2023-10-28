package com.per.model;


public class InfoProcess implements Comparable<InfoProcess>{
    
    private int pid;
    private String time;
    private String name;
    private String user;
    private String virtualMemory;
    private int physicalMemory;
    private int cpuUsage;
    private String startTime;
    private int priority;
    private String command;

    public InfoProcess(int pid, String time, String name, String user, String virtualMemory, int physicalMemory, int cpuUsage, String startTime, int priority, String command) {
        this.pid = pid;
        this.time = time;
        this.name = name;
        this.user = user;
        this.virtualMemory = virtualMemory;
        this.physicalMemory = physicalMemory;
        this.cpuUsage = cpuUsage;
        this.startTime = startTime;
        this.priority = priority;
        this.command = command;
    }
    
   public InfoProcess(){
       
   }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getVirtualMemory() {
        return virtualMemory;
    }

    public void setVirtualMemory(String virtualMemory) {
        this.virtualMemory = virtualMemory;
    }

    public int getPhysicalMemory() {
        return physicalMemory;
    }

    public void setPhysicalMemory(int physicalMemory) {
        this.physicalMemory = physicalMemory;
    }

    public int getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(String cpuUsage) {
        if  (cpuUsage == null){
            this.cpuUsage = 0;
        }else{
            this.cpuUsage = Integer.parseInt(cpuUsage);
        }
        
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
       
        if (this.getUser() != null){
            
            if(this.getUser().equals("SYSTEM")){
            this.priority = 1;
            }else if (this.getUser().equals(System.getProperty("user.name"))){
            this.priority = 0;
            }
        }
        
        //this.priority = priority;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public int compareTo(InfoProcess otroProceso) {
        return this.getPhysicalMemory() - otroProceso.getPhysicalMemory();
    }
 
    
    
}
