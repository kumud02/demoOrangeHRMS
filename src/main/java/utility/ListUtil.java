package utility;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListUtil {

    public static List sortAscendingOrder(List list) {
        Collections.sort(list);
        return list;
    }

    public static List sortDescendingOrder(List list) {
        Collections.sort(list,Collections.reverseOrder());
        return list;
    }

    public static boolean checkIfTwoListsEqual(List list1, List list2) {
        return list1.equals(list2);
    }

    public static void main(String[] args) {
        List<String> messages = Arrays.asList("Hello", "World!", "How", "Are", "You");
        List<String> messages2 = Arrays.asList("Hello", "World!", "How", "Are", "You");

        System.out.println(checkIfTwoListsEqual(messages,messages2));
    }


}
