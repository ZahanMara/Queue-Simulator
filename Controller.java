import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Controller implements Runnable {

    private FileReader input;
    public static ArrayList<Client> totalListOfClients;
    private Clock clock;

    private float totalWaitingTime;

    private ExecutorService executor;

    public Controller(FileReader input) {
        this.input = input;
    }

    public void setClock(Clock clock) {
        this.clock = clock;
    }

    // remove client from the waiting list if he/she is now served or was already served
    public void deleteClient(Client clientToRemove) {
        totalListOfClients.remove(clientToRemove);
    }

    // display the list of clients who are still waiting
    public String displayListOfClients() {
        String str = "Waiting list of clients: \n";
        if(totalListOfClients.size() != 0) { // if there are any more clients waiting to be served
            for (Client client : totalListOfClients) {
                str += client.displayClient();
            }

        }
        else str = "";
        return str;
    }

    public void run() {
        for(Client client : totalListOfClients) {
            Queue newQ = new Queue(client, this.clock, this);
            executor.execute(newQ);
            this.totalWaitingTime += newQ.waiting;
        }
        executor.shutdown();
    }


    public float getTotalWaitingTime() {
        return this.totalWaitingTime;
    }

    public void simulate(FileReader inputFile) {
        ClientGenerator c = new ClientGenerator();
        totalListOfClients = c.generateListOfClients(inputFile); // generate a random list of clients
        this.clock.startSimulation();
        for(Client client : totalListOfClients) {
            this.totalWaitingTime += client.getServiceTime();
        }
        this.executor = Executors.newFixedThreadPool(input.getNrOfQueues());
        this.run();
    }

}


