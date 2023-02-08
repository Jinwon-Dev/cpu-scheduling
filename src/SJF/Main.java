package SJF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Process> processList = new ArrayList<>();

        System.out.print("프로세스의 개수: ");
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "번째 " + "프로세스의 도착 시간: ");
            int arrivalTime = Integer.parseInt(br.readLine());

            System.out.print((i + 1) + "번째 " + "프로세스의 버스트 타임: ");
            int burstTime = Integer.parseInt(br.readLine());
            processList.add(new Process(i + 1, burstTime, arrivalTime));
        }

        System.out.print("1. 선점 | 2. 비선점: ");
        int choice = Integer.parseInt(br.readLine());

        Scheduler scheduler = new Scheduler(processList);
        if (choice == 1) {
            scheduler.PreemptiveSJF();
        } else {
            scheduler.NonPreemptiveSJF();
        }

        scheduler.calculateAverageWaitingTime();
        scheduler.calculateAverageCompletionTime();
    }
}
