package PRIORITY;

class Process {
    int arrivalTime;
    int burstTime;
    int priority;

    public Process(int arrivalTime, int burstTime, int priority) {
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
    }
}