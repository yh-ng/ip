import java.util.Scanner;
import java.util.Arrays;


public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        Scanner in = new Scanner(System.in);

        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        String s = in.nextLine();
        while(!s.equals("bye")) {
            System.out.println(s);
            s = in.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");

    }
}
