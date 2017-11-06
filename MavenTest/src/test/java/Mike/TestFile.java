package Mike;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.*;

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


    @BeforeClass(alwaysRun = true)
    public void setupNewDirTemp() {
        try {
            path = Files.createTempDirectory("myFile");
        } catch (IOException e) {
            System.out.println("Диреткория не создана ");
        }
    }

    @Test(groups = "positive",priority = 1)
    public void TestCreateNewFileTXT() throws IOException {
        String absoluteFilePath = path + "/file.txt";

        file = new File(absoluteFilePath);
        Assert.assertTrue(file.createNewFile(),"Файл не создан или уже существует");
        System.out.println("Файл создан во временной директории :" + file);

    }
    @Test(groups = "positive",priority = 1)
    public void TestCreateFileDoc() throws IOException {
        String absoluteFilePath = path + "/file.doc";

        file = new File(absoluteFilePath);
        Assert.assertTrue(file.createNewFile(),"Файл не создан или уже существует");
        System.out.println("Файл создан во временной директории :" + file);
    }
    @Test(groups = "positive" , priority = 1)
    public void TestNewFileCSV() throws IOException {
        String absoluteFilePath = path + "/file.csv";

        file = new File(absoluteFilePath);
        Assert.assertTrue(file.createNewFile(),"Файл не создан или уже существует");
        System.out.println("Файл создан во временной директории :" + file);
    }

    @Test(groups = "negative", priority = 2)
    public void TestCreateNewFileErorr() throws IOException {
        String absoluteFilePath = null;
        try {
            file = new File(absoluteFilePath);
            Assert.assertTrue(file.createNewFile(),"Файл не создан или уже существует");
        }catch (Exception e){
            System.out.println(e);
        }


    }

    @AfterClass(alwaysRun = true)
    public void deleteTempDir()  {
        try {
            FileUtils.deleteDirectory(path.toFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
