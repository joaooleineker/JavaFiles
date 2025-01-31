import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class SafeLogger {
    public static void main(String[] args) {
        Path filePath = Path.of("user_activity.log");
        String newLog = "User logged in at " + System.currentTimeMillis() + "\n";

        try (FileChannel channel = FileChannel.open(filePath, StandardOpenOption.WRITE, StandardOpenOption.APPEND)){
            FileLock lock = channel.lock();
            try {
                ByteBuffer buffer = ByteBuffer.wrap(newLog.getBytes());
                while (buffer.hasRemaining()){
                    channel.write(buffer);
                }
                System.out.println("Log entry added with safe concurrent access");
            } finally {
                lock.release();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
