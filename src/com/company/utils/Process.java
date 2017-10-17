package com.company.utils;

public class Process {
    private String pName;
    private int burstTime;
    private int arrivalTime;
    private int waitingTime = 0;
    private int ResponeTime;
    private int TurnaroundTime;
    private int oldBurstTime;

    public int getOldBurstTime() {
        return oldBurstTime;
    }

    public void setOldBurstTime(int oldBurstTime) {
        this.oldBurstTime = oldBurstTime;
    }

    public int getTurnaroundTime() {
        return TurnaroundTime;
    }

    public void setTurnaroundTime(int turnaroundTime) {
        TurnaroundTime = turnaroundTime;
    }

    private boolean isRespone = false;

    public boolean isRespone() {
        return isRespone;
    }

    public void setRespone(boolean respone) {
        isRespone = respone;
    }

    public int getResponeTime() {
        return ResponeTime;
    }

    public void setResponeTime(int responeTime) {
        ResponeTime = responeTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }
}
