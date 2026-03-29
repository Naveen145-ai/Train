public class Ticket {
    private int ticketId;
    private int trainNumber;
    private String source;
    private String destination;
    private double fare;
    private String status;  // BOOKED, CANCELLED
    private Payment payment;

    public Ticket(int ticketId, int trainNumber, String source, String destination, 
                  double fare, String status, Payment payment) {
        this.ticketId = ticketId;
        this.trainNumber = trainNumber;
        this.source = source;
        this.destination = destination;
        this.fare = fare;
        this.status = status;
        this.payment = payment;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
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

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", trainNumber=" + trainNumber +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", fare=" + fare +
                ", status='" + status + '\'' +
                ", payment=" + payment +
                '}';
    }
}
