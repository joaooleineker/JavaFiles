import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EfficientLogger {
    public static void main(String[] args) {

        String filePath = "user_activity.log";
        String newLog = "User sent a message at " + System.currentTimeMillis() + "\n";

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true))){
            bufferedWriter.write(newLog);
            System.out.println("Log entry added efficiently");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
