import java.util.Scanner;

/**
 * Created by Marci on 2017.06.01..
 */
public class Main {

    public static void main(String[] args) {
        ThreadHandler threadHandler = new ThreadHandler();
        Scanner scanner = new Scanner(System.in);
        String result;
        String[] command;
        do {
            System.out.printf("Command?\n");
            result = scanner.nextLine();
            command = result.split(" ");
            if (command[0].equals("start")){
                threadHandler.startTimer(command[1]);
            }else if(command[0].equals("check")&&command.length>1){
                threadHandler.checkTime(command[1]);
            }else if(command[0].equals("check")){
                threadHandler.checkTime();

            }else if(command[0].equals("stop")&&command.length>1){
                threadHandler.stopTimer(command[1]);
            }else {
                System.out.println("Wrong input");
            }
        }while (result != "exit");
    }
}
