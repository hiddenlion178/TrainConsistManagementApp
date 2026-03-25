import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void display() {
        System.out.println("Bogie: " + name + " | Capacity: " + capacity);
    }
}

public class TrainConsistApp {
    public static void main(String[] args) {

        // Step 1: Create Bogie List (reuse from previous UC)
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("Sleeper", 70));     // Duplicate type
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("AC Chair", 60));    // Duplicate type

        // Step 2: Group using Stream + groupingBy
        Map<String, List<Bogie>> groupedBogies = bogieList.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        // Step 3: Display Grouped Result
        System.out.println("Grouped Bogies by Type:\n");

        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("Type: " + entry.getKey());

            for (Bogie b : entry.getValue()) {
                b.display();
            }
            System.out.println();
        }

        // Step 4: Verify Original List
        System.out.println("Original Bogie List (Unchanged):");
        for (Bogie b : bogieList) {
            b.display();
        }
    }
}