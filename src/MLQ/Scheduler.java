package MLQ;

import java.util.ArrayList;

class Scheduler {
    ArrayList<Process> processList;

    public Scheduler() {
        processList = new ArrayList<>();
    }

    public void addProcess(Process process) {
        processList.add(process);
    }

    public void schedule() {

        ArrayList<Process> level1 = new ArrayList<>();
        ArrayList<Process> level2 = new ArrayList<>();
        ArrayList<Process> level3 = new ArrayList<>();

        for (Process process : processList) {
            switch (process.priority) {
                case 1 -> level1.add(process);
                case 2 -> level2.add(process);
                case 3 -> level3.add(process);
            }
        }

        int currentTime = 0;
        int waitingTime = 0;
        int totalBurstTime = 0;

        for (Process process : level1) {
            currentTime += process.burstTime;
            waitingTime += currentTime - process.burstTime;
            totalBurstTime += process.burstTime;
        }

        for (Process process : level2) {
            currentTime += process.burstTime;
            waitingTime += currentTime - process.burstTime;
            totalBurstTime += process.burstTime;
        }

        for (Process process : level3) {
            currentTime += process.burstTime;
            waitingTime += currentTime - process.burstTime;
            totalBurstTime += process.burstTime;
        }

        System.out.println("Average Waiting Time: " + (double) waitingTime / processList.size());
        System.out.println("Average Total Burst Time: " + (double) totalBurstTime / processList.size());
    }
}
