import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader inputFile = new FileReader("in-test-1.txt"); // input data file
        //FileReader inputFile = new FileReader(args[0]);

        //System.out.println(args[0]);
        //System.out.println(args[1]);
        File outputFile = new File("out-test-1.txt");
        //File outputFile = new File(args[1]);
        FileOutputStream fos = new FileOutputStream(outputFile);
        PrintStream ps = new PrintStream(fos);
        System.setOut(ps);

        Controller app = new Controller(inputFile);

        System.out.println(inputFile.displayInputData());

        Clock myClock = new Clock(inputFile, app);
        app.setClock(myClock);

        app.simulate(inputFile);

        System.out.println("Average waiting time: " + app.getTotalWaitingTime()/inputFile.getNrOfClients());

    }
}
