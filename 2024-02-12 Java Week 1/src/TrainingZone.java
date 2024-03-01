import java.util.Scanner;

public class TrainingZone {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = Integer.parseInt(keyboard.next()); 
        System.out.print("Enter your heartrate: ");
        int BPM = Integer.parseInt(keyboard.next()); 

        double maxBPM = 208 - (0.7 * age);

        String trainingType;

        if (BPM >= 0.9 * maxBPM) {
            trainingType = "Interval training";
        } else if (BPM >= 0.7 * maxBPM) {
            trainingType = "Threshold training";
        } else if (BPM >= 0.5 * maxBPM) {
            trainingType = "Aerobic training";
        } else {
            trainingType = "Couch potato";
        }

        System.out.println("Your training zone is: " + trainingType);

        keyboard.close();
    }

    
}
