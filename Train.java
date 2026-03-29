import java.util.ArrayList;
import java.util.List;

public class Train {
    private int trainNumber;
    private String trainName;
    private String source;
    private String destination;
    private int totalCapacity;
    private int currentPassengers;
    private List<Passenger> passengers;

    public Train(int trainNumber, String trainName, String source, String destination) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.totalCapacity = 50;  // Default capacity of 50
        this.currentPassengers = 0;
        this.passengers = new ArrayList<>();
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public int getCurrentPassengers() {
        return currentPassengers;
    }

    public void setCurrentPassengers(int currentPassengers) {
        this.currentPassengers = currentPassengers;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public boolean addPassenger(Passenger passenger) {
        if (currentPassengers < totalCapacity) {
            passengers.add(passenger);
            currentPassengers++;
            return true;
        }
        return false;  // Train is full
    }

    public boolean removePassenger(Passenger passenger) {
        if (passengers.remove(passenger)) {
            currentPassengers--;
            return true;
        }
        return false;
    }

    public boolean hasCapacity() {
        return currentPassengers < totalCapacity;
    }

    public int getAvailableSeats() {
        return totalCapacity - currentPassengers;
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainNumber=" + trainNumber +
                ", trainName='" + trainName + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", totalCapacity=" + totalCapacity +
                ", currentPassengers=" + currentPassengers +
                ", availableSeats=" + getAvailableSeats() +
                '}';
    }
}
