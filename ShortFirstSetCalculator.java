import java.util.*;

public class ShortFirstSetCalculator {
    public static void main(String[] args) {
        // Define the grammar
        Map<String, List<String>> grammar = Map.of(
            "S", List.of("A", "B"),
            "A", List.of("aA", ""),
            "B", List.of("b")
        );

        Map<String, Set<String>> firstSets = new HashMap<>();
        for (String nonTerminal : grammar.keySet()) {
            firstSets.put(nonTerminal, new HashSet<>());
        }

        boolean changed;
        do {
            changed = false;
            for (Map.Entry<String, List<String>> entry : grammar.entrySet()) {
                String nt = entry.getKey();
                for (String prod : entry.getValue()) {
                    // Check for empty production
                    if (prod.isEmpty()) {
                        if (firstSets.get(nt).add("ε")) changed = true;
                    } else {
                        // Check the first character only if the production is not empty
                        char firstSymbol = prod.charAt(0);
                        if (Character.isLowerCase(firstSymbol)) { // Terminal
                            if (firstSets.get(nt).add(String.valueOf(firstSymbol))) {
                                changed = true;
                            }
                        }
                    }
                }
            }
        } while (changed);

        // Print the FIRST sets
        firstSets.forEach((nt, first) -> 
            System.out.println("FIRST(" + nt + ") = " + first));
    }
}
