package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> {
            for (String s : list) {
                if (s.isEmpty() || !Character.isUpperCase(s.charAt(0))) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            List<Integer> temporary = new ArrayList<>();
            for (Integer i : list) {
                if (i % 2 == 0) {
                    temporary.add(i);
                }
            }
            list.addAll(temporary);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> filteredValues = new LinkedList<>();
            for (String s : values) {
                if (!s.isEmpty() && Character.isUpperCase(s.charAt(0))
                        && s.endsWith(".")
                        && s.split("\\s+").length > 3) {
                    filteredValues.add(s);
                }
            }
            values.clear();
            values.addAll(filteredValues);
            return values;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> {
            Map<String, Integer> map = new LinkedHashMap<>();
            for (String s : list) {
                if (!s.isEmpty()) {
                    map.put(s, s.length());
                }
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> new ArrayList<>() {{ addAll(list1); addAll(list2); }};
    }
}
