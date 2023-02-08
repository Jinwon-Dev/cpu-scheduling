package MLQ;

class Process {

    int processId;
    int burstTime;
    int priority;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
    }
}
