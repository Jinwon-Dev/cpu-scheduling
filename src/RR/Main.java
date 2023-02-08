package RR;

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

        System.out.print("시간 할당량: ");
        int quantum = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "번째 " + "프로세스의 도착 시간: ");
            int arrivalTime = Integer.parseInt(br.readLine());

            System.out.print((i + 1) + "번째 " + "프로세스의 버스트 타임: ");
            int burstTime = Integer.parseInt(br.readLine());
            processList.add(new Process(arrivalTime, burstTime));
        }

        Scheduler scheduler = new Scheduler(processList, quantum);
        scheduler.run();

        System.out.println("평균 대기 시간: " + scheduler.getAvgWaitingTime());
        System.out.println("평균 총처리 시간: " + scheduler.getAvgTurnAroundTime());
    }
}