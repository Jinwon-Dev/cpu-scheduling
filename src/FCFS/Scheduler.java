package FCFS;

import java.util.ArrayList;

public class Scheduler {

    ArrayList<Process> processList;

    public Scheduler() {

        processList = new ArrayList<>();
    }

    public void addProcess(int pid, int burstTime) {

        processList.add(new Process(pid, burstTime));
    }

    public void schedule() {

        int currentTime = 0;
        for (Process p : processList) {
            currentTime += p.burstTime;
            System.out.println("프로세스 ID: " + p.pid + " | 시작 시간: " + (currentTime - p.burstTime) + " | 마감 시간: " + currentTime);
        }
    }
}
