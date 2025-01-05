import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BanzhafMeasure {

    // Алгоритм
    public static double banzhafMeasure(Voter v, List<Voter> others, int quota, Voter[] allVoters, int numTries) {
        int criticalCount = 0;
        int tryCount = 0;

        while (tryCount < numTries) {
            List<Voter> coalition = randomSubset(others);
            int coalitionVotes = 0;

            for (Voter member : coalition) {
                coalitionVotes += lookupWeight(allVoters, member.getName());
            }

            if (coalitionVotes < quota && coalitionVotes + v.getWeight() >= quota) {
                criticalCount++;
            }

            tryCount++;
        }

        return (double) criticalCount / numTries;
    }

    private static int lookupWeight(Voter[] voters, String name) {
        for (Voter voter : voters) {
            if (voter.getName().equals(name)) {
                return voter.getWeight();
            }
        }
        return 0;
    }

    private static List<Voter> randomSubset(List<Voter> voters) {
        List<Voter> subset = new ArrayList<>(voters);
        Collections.shuffle(subset);
        int size = new Random().nextInt(subset.size() + 1);
        return subset.subList(0, size);
    }

    static class Voter {
        private final String name;
        private final int weight;

        public Voter(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }

        public String getName() {
            return name;
        }

        public int getWeight() {
            return weight;
        }
    }
}
