package RR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Scheduler {
    ArrayList<Process> processList;
    int quantum;
    int time;

    Scheduler(ArrayList<Process> processList, int quantum) {
        this.processList = processList;
        this.quantum = quantum;
        time = 0;
    }

    void run() {

        Collections.sort(processList, new Comparator<Process>() {

            @Override
            public int compare(Process p1, Process p2) {
                return p1.arrivalTime - p2.arrivalTime;
            }
        });

        int processIndex = 0;
        while (processIndex < processList.size()) {
            Process currentProcess = processList.get(processIndex);
            if (currentProcess.arrivalTime <= time) {
                currentProcess.waitingTime = time - currentProcess.arrivalTime;
                currentProcess.turnAroundTime = currentProcess.waitingTime + currentProcess.burstTime;
                time += Math.min(currentProcess.burstTime, quantum);
                processIndex++;
            } else {
                time++;
            }
        }
    }

    double getAvgWaitingTime() {

        int totalWaitingTime = 0;
        for (Process process : processList) {
            totalWaitingTime += process.waitingTime;
        }

        return (double) totalWaitingTime / processList.size();
    }

    double getAvgTurnAroundTime() {

        int totalTurnAroundTime = 0;
        for (Process process : processList) {
            totalTurnAroundTime += process.turnAroundTime;
        }

        return (double) totalTurnAroundTime / processList.size();
    }
}
