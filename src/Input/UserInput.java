package Input;

import java.util.Scanner;

/**
 * Created by Brandon on 2015-12-07.
 */
public class UserInput {
    public static final String ERROR_MESSAGE = "Invalid input.";
    public static final String LEAVE_MESSAGE = "Thanks for playing.";
    public static final String EXIT_STRING = "q";

    public static String inputString(String prompt) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(prompt);
            String s = sc.nextLine();
            if (s.equals(EXIT_STRING)) {
                System.out.println(LEAVE_MESSAGE);
                System.exit(1);
            } else if (!s.equals("")) {
                return s;
            } else {
                System.out.println(ERROR_MESSAGE);
            }
        }
    }

    public static int inputNum(String prompt, int low, int high) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(prompt);
            String s = sc.nextLine();
            if (s.equals(EXIT_STRING)) {
                System.out.println(LEAVE_MESSAGE);
                System.exit(1);
            }
            try {
                int i = Integer.valueOf(s);
                if (i >= low && i <= high) {
                    return i;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println(ERROR_MESSAGE);
            }
        }
    }
}
