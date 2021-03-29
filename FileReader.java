import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class FileReader {

    private Path path;
    private int nrOfClients;
    private int nrOfQueues;
    private int simulationTime;
    private int minArrTime;
    private int maxArrTime;
    private int minServTime;
    private int maxServTime;

    public FileReader() { // empty constructor
    }

    public FileReader(String fileName) {  // constructor which create the path to the desired file
        try {
            this.path = Paths.get(fileName);
            System.out.println(path);
            /*setSimulationTime();
            setNrOfClients();*/
        }
        catch(Exception e) {
            System.out.println("File not found!"); // if it does not find the file, it will print a warning
        }
    }


    // this method stores all the values given in the input text file within an array
    private List<Integer> loadData() {

        List<Integer> arr = new ArrayList<>();

        try {
            Files.lines(path).forEach(line -> {  // this command reads the values separated by a comma (e.g. 2,30 -> Minimum and maximum arrival time
                List<String> values = Arrays.asList(line.split(","));


                if(values.size() == 1) // if there is just one element on a line
                    arr.add(Integer.parseInt(values.get(0)));
                if(values.size() == 2) { // if there are two elements on a line
                    arr.add(Integer.parseInt(values.get(0)));
                    arr.add(Integer.parseInt(values.get(1)));
                }

            });
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return arr;
    }

    public String displayInputData() {

        return "Number of clients: " + getNrOfClients() + "\n" + "Number of queues: " + getNrOfQueues() + "\n" + "Simulation interval: " + getSimulationTime() + "\n" + "Minimum arrival time: " + getMinArrTime() + "\n" + "Maximum arrival time: " + getMaxArrTime() + "\n" + "Minimum service time: " + getMinServTime() + "\n" + "Maximum service time: " + getMaxServTime() + "\n";
    }

    // split the stored data in the array to properly distribute the data in variables
    public void setNrOfClients() {
        this.nrOfClients = (int)loadData().get(0);
    }
    public void setNrOfQueues() {
        this.nrOfQueues = (int)loadData().get(1);
    }
    public void setSimulationTime() {
        this.simulationTime = (int)loadData().get(2);
    }
    public void setMinArrTime() {
        this.minArrTime = (int)loadData().get(3);
    }
    public void setMaxArrTime() { this.maxArrTime = (int)loadData().get(4); }
    public void setMinServTime() {
        this.minServTime =(int)loadData().get(5);
    }
    public void setMaxServTime() {
        this.maxServTime = (int)loadData().get(6);
    }


    public int getNrOfClients() {
        setNrOfClients();
        return this.nrOfClients;
    }

    public int getNrOfQueues() {

        setNrOfQueues();
        return this.nrOfQueues;
    }

    public int getSimulationTime() {
        setSimulationTime();
        return this.simulationTime;
    }

    public int getMinArrTime() {

        setMinArrTime();
        return this.minArrTime;
    }

    public int getMaxArrTime() {

        setMaxArrTime();
        return this.maxArrTime;
    }

    public int getMinServTime() {

        setMinServTime();
        return this.minServTime;
    }

    public int getMaxServTime() {

        setMaxServTime();
        return this.maxServTime;
    }


}
