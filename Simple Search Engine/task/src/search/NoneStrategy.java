package search;

import java.util.*;

public class NoneStrategy implements StrategyInterface {

    private Map<String, List<Integer>> map;
    private String search;
    private String data[];


    public NoneStrategy(Map<String, List<Integer>> map, String search, String[] data) {
        this.map = map;
        this.search = search;
        this.data = data;
    }


    @Override
    public void find() {
        List<String> result = new LinkedList<>(Arrays.asList(data));

        for (int i = 0; i < search.split(" ").length; i++) {
            List<Integer> list = map.get(search.split(" ")[i]);
            if (list != null) {
                for (int n : list) {
                    if (result.contains(data[n]))
                        result.remove(data[n]);
                }
            }
        }

        if (result.size() != 0) {
            System.out.println();
            System.out.println(result.size() + " persons found:");
            for (String s : result
            ) {
                System.out.println(s.trim());
            }

            System.out.println();
        } else {
            System.out.println("No matching people found.");
            System.out.println();
        }

    }
}
