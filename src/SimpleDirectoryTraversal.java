import java.io.File;

public class SimpleDirectoryTraversal {
    public static void main(String[] args) {
        String directoryPath = "C:\\Users\\joao\\IdeaProjects\\WritingFIles";
        File directory = new File(directoryPath);
        File[] filesList = directory.listFiles();

        if (filesList != null){
            for  (File file : filesList){
                if (file.isFile()){
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()){
                    System.out.println("Directory: " + file);
                }
            }
        } else {
            System.out.println("The directory does not exist or isn't acessible");
        }
    }
}
