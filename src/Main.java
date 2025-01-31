import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the name of the file: ");
        String fileName = keyboard.next();
        keyboard.close();

        File file = new File("src/" + fileName + ".txt");
        */
        //usingFileClass(file, fileName);
        //usingFileOutputStream(file, fileName);
        //writingWithBufferedWriter(file);
        writeUTF8();
        readUTF8();
    }
    /*
    public static void usingFileClass(File file, String fileName){
        try {
            boolean isFileCreated = file.createNewFile();
            if (isFileCreated) {
                System.out.println("File \"" + fileName + ".txt\" created succesfully");
            }
        } catch (IOException ioException) {
            System.err.println("I/O Exception ocurred!");
            System.err.println(ioException.getMessage());
        }
    }


    public static void usingFileOutputStream(File file, String fileName){
        try (FileOutputStream outputStream = new FileOutputStream(file)){
            String fileContents = "Sample description for the file";
            byte[] fileContentsBytes = fileContents.getBytes();
            outputStream.write(fileContentsBytes);
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File not found!");
        } catch (IOException ioException){
            System.err.println(ioException.getMessage());
        }
    }

    public static void writingWithBufferedWriter(File file){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            writer.write("This is a sample string content for the file");
            System.out.println("Data written to file succesfully");
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File not found!");
        } catch (IOException ioException){
            System.err.println(ioException.getMessage());
        }
    }
    */

    public static void writeUTF8(){
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("patientRecords.txt"), StandardCharsets.UTF_8)){
            writer.write("José Alvarez\n");
            writer.write("Müller\n");
            writer.write("特点\n");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void readUTF8(){
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream("patientRecords.txt"), StandardCharsets.UTF_8)){
            int data;
            while ((data = reader.read()) != -1){
                System.out.print((char) data);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}