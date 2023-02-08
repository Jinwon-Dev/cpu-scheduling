package SJF;

import java.util.ArrayList;

public class Scheduler {
    private ArrayList<Process> processList;
    private int currentTime;

    public Scheduler(ArrayList<Process> processList) {
        this.processList = processList;
        this.currentTime = 0;
    }

    public void PreemptiveSJF() {
        processList.sort((p1, p2) -> {
            if (p1.getArrivalTime() != p2.getArrivalTime()) {
                return p1.getArrivalTime() - p2.getArrivalTime();
            } else {
                return p1.getBurstTime() - p2.getBurstTime();
            }
        });

        for (int i = 0; i < processList.size(); i++) {
            Process process = processList.get(i);
            if (currentTime < process.getArrivalTime()) {
                currentTime = process.getArrivalTime();
            }

            process.setWaitingTime(currentTime - process.getArrivalTime());
            currentTime += process.getBurstTime();
            process.setCompletionTime(currentTime);
        }
    }

    public void NonPreemptiveSJF() {
        processList.sort((p1, p2) -> {
            if (p1.getArrivalTime() != p2.getArrivalTime()) {
                return p1.getArrivalTime() - p2.getArrivalTime();
            } else {
                return p1.getBurstTime() - p2.getBurstTime();
            }
        });

        for (int i = 0; i < processList.size(); i++) {
            Process process = processList.get(i);
            if (currentTime < process.getArrivalTime()) {
                currentTime = process.getArrivalTime();
            }

            process.setWaitingTime(currentTime - process.getArrivalTime());
            currentTime += process.getBurstTime();
            process.setCompletionTime(currentTime);

            for (int j = i + 1; j < processList.size(); j++) {
                if (processList.get(j).getArrivalTime() <= currentTime) {
                    processList.get(j).setWaitingTime(currentTime - processList.get(j).getArrivalTime());
                } else {
                    break;
                }
            }
        }
    }

    public void calculateAverageWaitingTime() {
        int totalWaitingTime = 0;
        for (Process process : processList) {
            totalWaitingTime += process.getWaitingTime();
        }

        float averageWaitingTime = (float) totalWaitingTime / processList.size();
        System.out.println("평균 대기 시간: " + averageWaitingTime);
    }

    public void calculateAverageCompletionTime() {
        int totalCompletionTime = 0;
        for (Process process : processList) {
            totalCompletionTime += process.getCompletionTime();
        }

        float averageCompletionTime = (float) totalCompletionTime / processList.size();
        System.out.println("평균 총처리 시간: " + averageCompletionTime);
    }
}
