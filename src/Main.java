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

        // Step 1: Reuse Bogie List (from UC7)
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));

        // Step 2: Convert to Stream and Apply Filter
        List<Bogie> filteredBogies = bogieList.stream()
                .filter(b -> b.getCapacity() > 60) // Condition
                .collect(Collectors.toList());

        // Step 3: Display Filtered Bogies
        System.out.println("Filtered Bogies (Capacity > 60):");
        for (Bogie b : filteredBogies) {
            b.display();
        }

        // Step 4: Verify Original List is Unchanged
        System.out.println("\nOriginal Bogie List:");
        for (Bogie b : bogieList) {
            b.display();
        }
    }
}