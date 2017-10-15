package com.company.manages;

import com.company.utils.Process;

import java.util.ArrayList;
import java.util.Comparator;

public class SJFScheduling {


    public SJFScheduling() {
    }
    public void SJFCalculate(ArrayList<Process> processes){
        ArrayList<Process> workingList = new ArrayList<>();
        int size = processes.size();
        int currentTime =0;
        int sumWaitTime=0;

        do {
            for (Process p :processes) {
                if (currentTime ==  p.getArrivalTime()){
                    //keep process into workingList
                    workingList.add(p);
                }
            }

            // sort which process low burstTime can do first
            workingList.sort(new Comparator<Process>() {
                @Override
                public int compare(Process o1, Process o2) {
                    return Integer.valueOf(o1.getBurstTime()).compareTo(o2.getBurstTime());
                }
            });
            // process finish pop out from workingList
            if(!workingList.isEmpty()){
                System.out.println(workingList.get(0).getpName());
                sumWaitTime += workingList.get(0).getBurstTime();
                workingList.remove(workingList.get(0));
                size--;
            }
            currentTime++;
        }while (size != 0);
        float avg = sumWaitTime/processes.size();
        System.out.println("Avgerage of CPU :" + avg);
    }
}
