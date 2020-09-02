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
        String input = in.nextLine();
        String[] list = new String[100];
        int listCounter = 0;
        while(!input.equals("bye")) {
            if(input.equals("list")){
                for(int i = 0; i < listCounter; i++){
                    System.out.println(Integer.toString(i+1) + ". " + list[i]);
                }
                input = in.nextLine();
            }
            else{
                list[listCounter] = input;
                System.out.println("added: " + input);
                input = in.nextLine();
                listCounter++;
            }

        }
        System.out.println("Bye. Hope to see you again soon!");

    }
}
