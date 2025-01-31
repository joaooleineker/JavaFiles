import java.io.IOException;
import java.nio.file.*;

public class FileManager {
    public static void createFile(String filePath) {
        Path path = Paths.get(filePath);
        try {
            Files.createFile(path);
            System.out.println("File created at: " + path.toString());
        } catch (FileAlreadyExistsException e){
            System.out.println("File already exists.");
        } catch (AccessDeniedException e) {
            System.out.println("Access denied: Unable to create the file");
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    public static void deleteFile(String filePath) {
        Path path = Paths.get(filePath);
        try {
            Files.delete(path);
            System.out.println("File deleted at: " + path.toString());
        } catch (FileAlreadyExistsException e){
            System.out.println("File already exists.");
        } catch (AccessDeniedException e) {
            System.out.println("Access denied: Unable to delete the file");
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    public static void renameFile(String oldFilePath, String newFilePath){
        Path oldPath = Paths.get(oldFilePath);
        Path newPath = Paths.get(newFilePath);
        try {
            Files.move(oldPath, newPath);
            System.out.println("File renamed from " + oldPath + " to " + newPath);
        } catch (FileAlreadyExistsException e){
            System.out.println("File already exists.");
        } catch (AccessDeniedException e) {
            System.out.println("Access denied: Unable to rename the file");
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    public static void copyFile(String sourcePath, String targetPath){
        Path source = Paths.get(sourcePath);
        Path target = Paths.get(targetPath);
        try{
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Creating a copy of " + source + " at " + target);
        } catch (FileAlreadyExistsException e){
            System.out.println("File already exists.");
        } catch (AccessDeniedException e) {
            System.out.println("Access denied: Unable to copy the file");
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}
