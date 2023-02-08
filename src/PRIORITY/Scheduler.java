package PRIORITY;

import java.util.ArrayList;

class Scheduler {
    static ArrayList<Process> processes = new ArrayList<>();

    static void addProcess(Process p) {
        processes.add(p);
    }

    static void schedule() {
        processes.sort((p1, p2) -> {
            if (p1.priority == p2.priority) {
                return Integer.compare(p1.arrivalTime, p2.arrivalTime);
            } else {
                return Integer.compare(p1.priority, p2.priority);
            }
        });

        int currentTime = 0;
        int waitTime = 0;
        int totalTime = 0;

        for (Process p : processes) {
            if (currentTime < p.arrivalTime) {
                currentTime = p.arrivalTime;
            }

            waitTime += currentTime - p.arrivalTime;
            currentTime += p.burstTime;
            totalTime += currentTime - p.arrivalTime;
        }

        System.out.println();
        System.out.println("평균 대기 시간: " + (double) waitTime / processes.size());
        System.out.println("평균 총처리 시간: " + (double) totalTime / processes.size());
    }
}