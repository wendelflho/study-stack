package setsHashSets;

import java.util.*;

public class SetAndHashSet {

    public static void main(String[] args) {
//        Set<String> names = new HashSet<>();
//        Set<String> names = new TreeSet<>(); // Ordem natural dos elementos (no caso ordem alfabética)
        Set<String> names = new LinkedHashSet<>(); // Ordem em que os elementos foram inseridos
        /*
        * Um HashSet é muito mais rápido que um TreeSet
        * Logo, TreeSet deve somente ser usado em casos
        * que a ordem natural dos elementos deve ser mantida.
        *
        * Um LinkedHashSet é quase tão rápido quanto um HashSet        *
        * */
        names.add("Clark");
        names.add("Bruce");
        names.add("Diana");
        names.add("Barry");
        names.add("J'onn J'onzz");

//        for(String name : names) {
//            System.out.println(name);
//        }

        names.forEach(System.out::println);

//        Iterator<String> namesIterator = names.iterator();
//        while (namesIterator.hasNext()) {
//            System.out.println(namesIterator.next());
//        }

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(1);

        Set<Integer> integerSet = new HashSet<>();
        integerSet.addAll(integers);

//        Set<Integer> integerSet = new HashSet<>(integers); forma resumida

        System.out.println(integerSet);
    }
}
