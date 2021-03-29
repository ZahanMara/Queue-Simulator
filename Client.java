public class Client {

    private int ID;
    private int arrivingTime;
    private int serviceTime ;

    public Client() {} // empty constructor

    //  display the data of a client
    public String displayClient() { // for printing the client
        return "(" + this.ID + ", " + this.arrivingTime + ", " + this.serviceTime + ")\n";
    }

    // this method decreases the variable at each moment, starting from the moment the client gets served
    public void decrementServTime() { this.setServiceTime(getServiceTime() - 1);}

    public int getArrivingTime() {
        return this.arrivingTime;
    }

    public int getServiceTime() {
        return this.serviceTime;
    }

    public void setID(int ID) { this.ID = ID; }

    public void setArrivingTime(int arrivingTime) { this.arrivingTime = arrivingTime; }

    public void setServiceTime(int serviceTime) { this.serviceTime = serviceTime; }


}
