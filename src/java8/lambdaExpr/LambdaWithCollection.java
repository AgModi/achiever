package java8.lambdaExpr;

import java.util.*;

public class LambdaWithCollection {

    public static void main(String[] args) {
        //tryListSorting();
        tryMapSorting();
    }

    private static void tryListSorting() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(6);
        list.add(2);
        list.add(7);
        list.add(1);

        System.out.println("List before sorting: "+ list);
        Collections.sort(list, (a,b)-> (a<b)? 1 : (a>b? -1:0));

        System.out.println("List After sorting: "+ list);
    }

    private static void tryMapSorting() {
        //Map<Integer, String> map = new TreeMap<>((a,b)-> a>b? -1: a<b? 1:0);
        Map<Integer, String> map = new TreeMap<>();
        map.put(1, "Akshay");
        map.put(6, "Mahesh");
        map.put(8, "Akshay");
        map.put(2, "PatilDJ");
        map.put(9, "Akshay");
        map.put(7, "Rohti");

        System.out.println("Already sorted map : "+ map);
    }
}
