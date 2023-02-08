package PRIORITY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("프로세스의 개수: ");
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "번째 " + "프로세스의 도착 시간: ");
            int arrivalTime = Integer.parseInt(br.readLine());

            System.out.print((i + 1) + "번째 " + "프로세스의 버스트 타임: ");
            int burstTime = Integer.parseInt(br.readLine());

            System.out.print((i + 1) + "번째 " + "프로세스의 우선 순위: ");
            int priority = Integer.parseInt(br.readLine());
            Scheduler.addProcess(new Process(arrivalTime, burstTime, priority));
        }

        Scheduler.schedule();
    }
}
