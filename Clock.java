public class Clock implements Runnable{

    private Thread thread;
    private boolean running;
    private int currentTime;
    private int totalSimulationTime;
    private Controller ctrl;

    public Clock(FileReader inputFile, Controller c) {
        this.thread = new Thread(this);
        this.currentTime = 1;
        this.running = false;
        this.totalSimulationTime = inputFile.getSimulationTime();
        this.ctrl = c;
    }

    public void startSimulation() {
        running = true;
        thread.start();
    }

    public void stopSimulation() {
        this.running = false;
    }

    public int getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(int currentTime) {
        this.currentTime = currentTime;
    }

    @Override
    public void run() {


        while (running) {

            try {

                while (currentTime <= totalSimulationTime) { // simulation is not finished
                    System.out.println("\nTime " + getCurrentTime() + "\n");
                    System.out.println(ctrl.displayListOfClients()); // display the waiting list of clients
                    Thread.sleep(1000);
                    setCurrentTime(currentTime + 1);
                }
                stopSimulation(); // stop simulation
            } catch (InterruptedException e) {
                System.out.println("Clock Error!");
            }
        }
    }
}
