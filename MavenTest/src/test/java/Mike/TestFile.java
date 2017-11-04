package Mike;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.Files.createTempDirectory;

/**
 * Created by User on 03.11.2017.
 */
public class TestFile {
    private static Files dir;
    private static Path path;
    private static File file;


    @BeforeTest
    public void setupNewDirTemp() {
        try {
            path = Files.createTempDirectory("myFile");
        } catch (IOException e) {
            System.out.println("Диреткория не создана ");
        }
    }

    @Test
    public void TestCreateNewFileTXT() throws IOException {
        String absoluteFilePath = path + "/file.txt";

        file = new File(absoluteFilePath);
        if (file.createNewFile()) {
            System.out.println(absoluteFilePath + " Файл создан");
        } else {
            System.out.println("Файл " + absoluteFilePath + " уже существует");
        }
    }
    @Test
    public void TestCreateFileDoc() throws IOException {
        String absoluteFilePath = path + "/file.doc";

        file = new File(absoluteFilePath);
        if (file.createNewFile()) {
            System.out.println(absoluteFilePath + " Файл создан");
        } else {
            System.out.println("Файл " + absoluteFilePath + " уже существует");
        }
    }
    @Test
    public void TestNewFileCSV() throws IOException {
        String absoluteFilePath = path + "/file.csv";

        file = new File(absoluteFilePath);
        if (file.createNewFile()) {
            System.out.println(absoluteFilePath + " Файл создан");
        } else {
            System.out.println("Файл " + absoluteFilePath + " уже существует");
        }
    }
    @Test
    public void TestCreateNewFileErorr() throws IOException {
        String absoluteFilePath = null;
        try {
            file = new File(absoluteFilePath);
            file.createNewFile();
        }catch (Exception e){
            System.out.println(e);
        }


    }
    
    @AfterTest
    public void deleteTempDir()  {
        try {
            FileUtils.deleteDirectory(path.toFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
