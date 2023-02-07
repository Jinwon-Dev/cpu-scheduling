package FCFS;

class Process {

    int pid;
    int burstTime;

    public Process(int pid, int burstTime) {
        this.pid = pid;
        this.burstTime = burstTime;
    }
}
