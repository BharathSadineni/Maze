import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Logger {
    private static final String FILE_LOGGER_NAME = "StudentFileOutput.txt";

    static {

        /** TODO
         * create a new File object for FILE_LOGGER_NAME
         * if the file already exists, delete it first
         * use try/catch block
         */
        File File_1 = new File(FILE_LOGGER_NAME);
        if (File_1.delete()) {
        } else {
        }
        File File_2 = new File(FILE_LOGGER_NAME);
        boolean exists;
        try {
            exists = File_2.createNewFile();
            if (exists) {
            } else {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void log(String message) {
        /** TODO
         * create a new FileWriter in append mode
         * write the message to file
         * check the ExpectedOutput files
         * use try-with-resources/catch block
         */
        try{
            FileWriter output = new FileWriter(FILE_LOGGER_NAME, true);
            output.write(message+ "\n");
            output.close();
        }catch (IOException e){
            e.printStackTrace();}}
}
