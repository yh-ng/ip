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
        Task[] list = new Task[100];
        int listCounter = 0;
        while(!input.equals("bye")) {
            if(input.equals("list")){
                System.out.println("Here are the tasks in your list:");
                for(int i = 0; i < listCounter; i++){
                    System.out.println(Integer.toString(i+1) + ". " + list[i].print());
                }
            }


            else if(validDoneInput(input,listCounter)){
                int itemNumber = Integer.parseInt(input.substring(input.indexOf(' ') + 1));
                list[itemNumber - 1].markDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(list[itemNumber - 1].print());
            }
            else{
                list[listCounter] = new Task(input);
                System.out.println("added: " + input);
                listCounter++;
            }
            input = in.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");

    }

    public static boolean validDoneInput(String s, int n) {
        if(s.length() < 6){ // check if string is long enough
            return false;
        }
        else if(!s.substring(0,4).equals("done")){ // check if string is "done ..."
            return false;
        }
        int m = 0;
        try {
            m = Integer.parseInt(s.substring(5));
        } catch(Exception e) {
            return false;
        }

        if(m>n){
            return false;
        }
        else return true;
    }
}
