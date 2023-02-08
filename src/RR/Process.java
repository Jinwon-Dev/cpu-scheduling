package RR;

class Process {
    int arrivalTime;
    int burstTime;
    int waitingTime;
    int turnAroundTime;

    public Process(int arrivalTime, int burstTime) {
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}