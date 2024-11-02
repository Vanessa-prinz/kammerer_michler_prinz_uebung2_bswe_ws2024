package at.fh_burgenland.bswe.algo;

import java.util.Arrays;
import java.util.Objects;

public class ListProcessor {

    public static int[] getList(String userInput) {
        userInput = userInput.replaceAll(" ", "");
        if (listInputValid(userInput)) {
            String[] stringValues = userInput.split(",");
            int[] values = new int[stringValues.length];
            for (int i = 0; i < stringValues.length; i++) {
                try {
                    values[i] = Integer.parseInt(stringValues[i]);
                } catch (NumberFormatException e) {
                    System.out.println("Value can not be parsed!");
                    return null;
                }

            }
            return values;
        } else {
            System.out.println("Invalid format!");
            return null;
        }
    }

    public static int[] getSortedList(String userInput) {
        if (getList(userInput) == null) {
            return null;
        } else {
            return Arrays.stream(Objects.requireNonNull(getList(userInput))).sorted().toArray();
        }
    }

    public static int[] getSortedList(int[] list) {
        if (list == null) {
            return null;
        } else {
            return Arrays.stream(Objects.requireNonNull(list)).sorted().toArray();
        }
    }

    private static boolean listInputValid(String userInput) {
        return userInput.matches("^\\d+(,\\d+)*$");

    }

    public static boolean isSortedAscending(int[] values) {
        for (int i = 1; i < values.length; i++) {
            if (values[i - 1] > values[i]) {
                return false;
            }
        }
        return true;
    }
}
