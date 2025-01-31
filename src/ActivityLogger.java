import java.io.FileWriter;
import java.io.IOException;

public class ActivityLogger {
    public static void main(String[] args) {
        String filePath = "user_activity.log";
        String newLog = "User logged in at " + System.currentTimeMillis() + "\n";

        try (FileWriter fw = new FileWriter(filePath, true)) {
            fw.write(newLog);
            System.out.println("Log entry added");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
