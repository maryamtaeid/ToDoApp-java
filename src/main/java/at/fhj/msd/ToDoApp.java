package at.fhj.msd;
import java.util.ArrayList;
import java.util.Scanner;


public class ToDoApp {
    static ArrayList<String> tasks = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1.Add Task\n2.show Tasks\n3.Remove Task\n4.Exit");
            String choice = input.nextLine();
            
            switch (choice) {
                case "1" -> addTask();
                case "2" -> showTasks();
                case "3" -> removeTask();
                case "4" -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Invalid choice. ");
            }
        }
    }
  static void addTask() {
        System.out.print("Enter task: ");
        tasks.add(input.nextLine());
  }
    static void showTasks() {
        System.out.println("\nYour tasks:");
       for (int i=0; i<tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
    static void removeTask(){
        showTasks();
        System.out.print("Enter task number to remove: ");
        int index = Integer.parseInt(input.nextLine()) - 1;
        if (index >= 0 && index < tasks.size()){
            tasks.remove(index);
            System.out.println("Task removed.");
        }
        else {
            System.out.println("Invalid task number.");
        }
    }
}
