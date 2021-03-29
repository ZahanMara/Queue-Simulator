
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PrimitiveIterator;

public class Queue implements Runnable {

    private int queueID = 0;
    private Client client;
    private Clock clock;
    private Controller ctrl;

    public int waiting;


     public Queue(Client newClient, Clock clock, Controller ctrl) {

        this.client = newClient;
        this.clock = clock;
        this.ctrl = ctrl;
    }

    @Override
    public void run() {
        queueID = getQueueID(Thread.currentThread().getName()); // thread name is pool-1-thread-ID and that's why it takes the 3rd element which is ID
        if(clock.getCurrentTime() < client.getArrivingTime()) // if the client is not ready for being served
            whenClosed(client.getArrivingTime() - clock.getCurrentTime());
        waiting = clock.getCurrentTime() - client.getArrivingTime();
        whileOpen(client.getServiceTime()); // if the client is now served
    }


    // when the client is not ready for being served
    private void whenClosed(int time) {
        try {
            for(int i = 0; i < time; i++) {
                System.out.println("Queue " + queueID + ": closed");
                if(client.getArrivingTime() - clock.getCurrentTime() == 1) // when the client is almost ready to be served
                    this.ctrl.deleteClient(client);
                Thread.sleep(1005);
            }
        } catch (InterruptedException e) {
            System.out.println("ERROR!");
        }
    }

    // when the client is served
    private void whileOpen(int time) {
        this.ctrl.deleteClient(client);
        try {
            for(int i = 0; i < time; i++) {
                System.out.println("Queue " + queueID + ": " + client.displayClient());
                Thread.sleep(1005);
                client.decrementServTime(); // decrement in every moment while is served
            }
        }
        catch (InterruptedException e) {
            System.out.println("ERROR!");
        }
    }

    // this method returns the ID of the queue where the client was distributed
    private int getQueueID(String s) {
        String[] str = s.split("-");
        return Integer.parseInt(str[3]);
    }


}