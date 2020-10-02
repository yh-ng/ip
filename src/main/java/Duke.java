import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;


public class Duke {
    public static void main(String[] args) throws IOException {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        ArrayList<Task> list = new ArrayList<>();
        int listCounter = 0;

        String FilePath = "taskList.txt";
        File file = new File(FilePath);
        file.createNewFile();
        Scanner fileScanner = new Scanner(file);
        while ( fileScanner.hasNextLine() ) {
            String fileInput = fileScanner.nextLine();
            list.add(listCounter,taskType(fileInput));
            listCounter++;
        }

        Scanner in = new Scanner(System.in);

        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        String input = in.nextLine();

        while(!input.equals("bye")) {
            String[] inputArray = input.split(" ");
            String commandWord = inputArray[0];
            System.out.println(commandWord);
            if(!( commandWord.equals("todo") || commandWord.equals("deadline") || commandWord.equals("event") || commandWord.equals("done")
                    || commandWord.equals("list") || commandWord.equals("delete") || commandWord.equals("find")  )  ) {
                System.out.println("Sorry I don't understand :(");
            } else if(commandWord.equals("delete")) {
                int deletionIndex = Integer.parseInt(inputArray[1])-1;
                System.out.println(" Noted. I've removed this task:");
                System.out.println(list.get(deletionIndex).toString());
                list.remove(deletionIndex);
                listCounter--;
                System.out.println("Now you have " + listCounter + " tasks in the list.");

                /*
                After deleting item from list, we clear the taskList.txt file.
                Then we fill up the taskList.txt file again using the new list with deleted task.
                 */
                FileWriter clearFile = new FileWriter(FilePath);
                clearFile.append("");
                FileWriter taskToFile = new FileWriter(FilePath,true);
                for (Task taskItem : list) {
                    taskToFile.append(taskItem.formatInput());
                    taskToFile.append("\n");
                    taskToFile.close();
                }



            } else if(input.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for(int i = 0; i < listCounter; i++) {
                    System.out.println(Integer.toString(i+1) + ". " + list.get(i).toString());
                }
            } else if(validDoneInput(input,listCounter)) {
                int itemNumber = Integer.parseInt(input.substring(input.indexOf(' ') + 1));
                list.get(itemNumber - 1).markDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(list.get(itemNumber - 1).toString());
            } else if(commandWord.equals("find")) {
                String searchWord = inputArray[1];
                int candidateListCount = 0;
                ArrayList<Task> candidateList = new ArrayList<>();

                for (Task myTask : list) {
                    if(myTask.getDescription().contains(searchWord)) {
                        candidateList.add(candidateListCount,myTask);
                        candidateListCount++;
                    }
                }
                System.out.println("Here are the matching tasks in your list:");
                for(int i = 0; i < candidateListCount; i++) {
                    System.out.println(Integer.toString(i+1) + ". " + candidateList.get(i).toString());
                }

            } else if(commandWord.equals("done")) {
                    System.out.println("done index out of range");
            } else if(inputArray.length<2) {
                System.out.println("item cannot be empty");
            } else {
                list.add(listCounter, taskType(input));
                System.out.println("Got it. I've added this task:" + "\n" + list.get(listCounter).toString());
                listCounter++;
                System.out.println("Now you have " + Integer.toString(listCounter) + " tasks in the list.");
                FileWriter taskToFile = new FileWriter(FilePath,true);
                taskToFile.append(input);
                taskToFile.append("\n");
                taskToFile.close();

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

        if(m>n) {
            return false;
        } else return true;
    }

    public static Task taskType(String s) {
        String[] splitted = s.split(" ");
        switch(splitted[0]) {
            case "todo":
                return new Todo(s);
                // Fallthrough
            case "deadline":
                return new Deadline(s);
                // Fallthrough
            case "event":
                return new Event(s);
                // Fallthrough
            default:
                return new Task(s);
                // Fallthrough
        }
    }




}
