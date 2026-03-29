import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private int id;
    private String name;
    private int age;
    private String aadhar;
    private List<Ticket> tickets;

    public Passenger(int id, String name, int age, String aadhar) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.aadhar = aadhar;
        this.tickets = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", aadhar='" + aadhar + '\'' +
                ", ticketCount=" + tickets.size() +
                '}';
    }
}
