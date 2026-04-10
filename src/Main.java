import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    private String type;
    private int capacity;

    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type + " (" + capacity + ")";
    }
}

public class Main {

    public static void main(String[] args) {

        List<Bogie> bogies = generateBogies(100000);

        long loopStart = System.nanoTime();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                loopResult.add(b);
            }
        }

        long loopEnd = System.nanoTime();
        long loopTime = loopEnd - loopStart;

        long streamStart = System.nanoTime();

        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        long streamEnd = System.nanoTime();
        long streamTime = streamEnd - streamStart;

        System.out.println("Loop Result Count   : " + loopResult.size());
        System.out.println("Stream Result Count : " + streamResult.size());

        System.out.println("\nExecution Time:");
        System.out.println("Loop Time   : " + loopTime + " ns");
        System.out.println("Stream Time : " + streamTime + " ns");

        if (loopResult.size() == streamResult.size()) {
            System.out.println("\nResults are matching.");
        } else {
            System.out.println("\nResults mismatch!");
        }
    }

    private static List<Bogie> generateBogies(int size) {
        List<Bogie> list = new ArrayList<>();
        Random random = new Random();

        String[] types = {"Sleeper", "AC Chair", "First Class"};

        for (int i = 0; i < size; i++) {
            String type = types[random.nextInt(types.length)];
            int capacity = 30 + random.nextInt(100);
            list.add(new Bogie(type, capacity));
        }
        return list;
    }
}