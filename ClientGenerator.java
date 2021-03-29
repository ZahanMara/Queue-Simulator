import java.util.*;

public class ClientGenerator {

    private static int id = 1;
    Random random = new Random();

    // empty constructor
    public ClientGenerator() { }

    // this method generates a list of clients with random data, sorted by the arriving time in ascending order
    public ArrayList<Client> generateListOfClients(FileReader file) {
        ArrayList<Client> listOfClients = new ArrayList<Client>();
        for(int i = 0; i < file.getNrOfClients(); i++) {
            Client newClient = generateClientData(file);
            try {
                listOfClients.add(newClient);
            }
            catch (Exception e) {
                System.out.println("Error at adding a client in the list!");
            }
        }
        if(listOfClients != null) {
            listOfClients.sort(new Comparator<Client>() {
                // sort all the clients in ascending order depending on the arriving time
                @Override
                public int compare(Client client1, Client client2) {
                    if (client1.getArrivingTime() > client2.getArrivingTime()) {
                        return 1;
                    } else if (client1.getArrivingTime() < client2.getArrivingTime()) {
                        return -1;
                    }
                    return 0;
                }
            });}
        // generate IDs for each client
        for(Client eachClient : listOfClients) {
            eachClient.setID(id);
            id++;
        }
        return listOfClients;
    }

        // generate random data(with respect to the restrictions imposed in the file with input data) for one client (without ID)
        private Client generateClientData(FileReader file) {
            Client newClient = new Client();
            newClient.setArrivingTime((int)(random.nextInt(file.getMaxArrTime() - file.getMinArrTime() + 1) + file.getMinArrTime()));
            newClient.setServiceTime((int)(random.nextInt(file.getMaxServTime() - file.getMinServTime() + 1) + file.getMinServTime()));
            return newClient;

        }

}
