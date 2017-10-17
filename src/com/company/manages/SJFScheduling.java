package com.company.manages;

import com.company.utils.Process;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SJFScheduling {


    public SJFScheduling() {
    }
    public void SJFCalculate(ArrayList<Process> processes){
        ArrayList<Process> workingList = new ArrayList<>();
        int size = processes.size();
        Process copy =new Process();
        boolean c = false;
        int currentTime =0;
        int sumWaitTime=0;
        int sumResponeTime =0;
        int sumTurnaroundTime=0;
        do {
            //Add process for working in cpu
            for (Process p :processes) {
                if (currentTime ==  p.getArrivalTime()){
                    workingList.add(p);
                }
            }

            // fix process is working
            if (!workingList.isEmpty()) {
                copy = workingList.get(0);
                workingList.remove(copy);
                c = true;
            }

            // sort to find burst time is low
            workingList.sort(new Comparator<Process>() {
                @Override
                public int compare(Process o1, Process o2) {
                    return Integer.valueOf(o1.getBurstTime()).compareTo(o2.getBurstTime());
                }
            });

            if(c) {
                workingList.add(0, copy);
                c = false;
            }

            // process was finished pop from workingList
            if (!workingList.isEmpty()) {
                workingList.get(0).setBurstTime(workingList.get(0).getBurstTime() - 1);
                if (!workingList.get(0).isRespone()){
                    workingList.get(0).setResponeTime(currentTime-workingList.get(0).getArrivalTime());
                    workingList.get(0).setRespone(true);
                }
                for (Process p : workingList){
                    if(p!= workingList.get(0)){
                        p.setWaitingTime(p.getWaitingTime()+1);
                    }
                }
            }

            // Show information
            if(!workingList.isEmpty() && workingList.get(0).getBurstTime() == 0){
                workingList.get(0).setTurnaroundTime(workingList.get(0).getOldBurstTime()+ workingList.get(0).getWaitingTime());
                System.out.printf("%5s waitingTime : %5d ResponeTime : %5d  TurnaroundTime : %5d\n",workingList.get(0).getpName(),
                        workingList.get(0).getWaitingTime(),
                        workingList.get(0).getResponeTime(),
                        workingList.get(0).getTurnaroundTime());
                sumTurnaroundTime += workingList.get(0).getTurnaroundTime();
                sumResponeTime += workingList.get(0).getResponeTime();
                sumWaitTime += workingList.get(0).getWaitingTime();
                workingList.remove(workingList.get(0));
                size--;
            }
            currentTime++;
        }while (size != 0);
        float avgBT = sumWaitTime/(float)processes.size();
        float avgRT = sumResponeTime/(float)processes.size();
        float avgTT = sumTurnaroundTime/(float)processes.size();
        System.out.printf("\nAvgerage of ฺ Burst Time : %.2f" , avgBT);
        System.out.printf("\nAvgerage of ฺ ResponeTime Time : %.2f" , avgRT);
        System.out.printf("\nAvgerage of ฺ Turnaround Time : %.2f" , avgTT);
    }
}
