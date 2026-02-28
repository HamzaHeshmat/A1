import java.util.Scanner ;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("\n===== MENU =====");
            System.out.println("Choose :");
            System.out.println("1- Stop watch");
            System.out.println("2- Soon ");
            System.out.println("0-Exit");

            int choice = scanner.nextInt();
            scanner.nextLine() ;

            switch (choice) {
                case 1:
                    runLiveStopWatch(scanner);
                    break;
                case 2:
                    System.out.println("Soon will be add ");
                    break;
                case 0 :
                    System.out.println("Goodbye !");
                    return;
                default:
                    System.out.println("Invalid choice .");
            }
        }
    }
    private static void runLiveStopWatch(Scanner scanner) {
        LiveStopWatch LiveStopWatch  = new LiveStopWatch();

        LiveStopWatch.Start();

        System.out.println("Stopwatch running ... ");
        System.out.println("Type p to Pause" );
        System.out.println("Type r to Resume " );
        System.out.println("Type 0 to return to menu" );

        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("p")){
                LiveStopWatch.Paused();
            }
            else if (command.equalsIgnoreCase("r")){
                LiveStopWatch.resume();
            }
            else if (command.equalsIgnoreCase("0")){
                LiveStopWatch.stop();
                break;
            }

        }
    }
}
