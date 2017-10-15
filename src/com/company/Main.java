package com.company;

import com.company.manages.SJFScheduling;
import com.company.utils.Process;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Main {

    private static ArrayList<Process> processes = new ArrayList<>();
    private static int sumBurstTime =0;

    public static void main(String[] args) {
        // write your code here
        init();

        // sort ArrivalTime
        processes.sort(new Comparator<Process>() {
            @Override
            public int compare(Process o1, Process o2) {
                if (o1.getArrivalTime() == o2.getArrivalTime())
                    return Integer.valueOf(o1.getBurstTime()).compareTo(o2.getBurstTime());
                else
                    return Integer.valueOf(o1.getArrivalTime()).compareTo(o2.getArrivalTime());
            }

        });
        System.out.printf("%1s%15s%15s\n","Process","ArrivalTime","BurstTime");
        for (Process p : processes){
            System.out.printf("%-15s%-15d%-15d\n",p.getpName(),p.getArrivalTime(),p.getBurstTime());
        }
        System.out.printf("----------------------------------------\n");

        // SJF
        SJFScheduling sjfScheduling = new SJFScheduling();
        sjfScheduling.SJFCalculate(processes);
    }

    // init process
    private static void init(){
        for(int i=0; i<10 ;i++){
            Random random = new Random();
            Process process = new Process();
            process.setpName("P["+(i+1)+"]");
            process.setArrivalTime(random.nextInt(10)+1);
            process.setBurstTime(random.nextInt(10)+1);
            sumBurstTime += process.getBurstTime();
            processes.add(process);

        }
    }
}
