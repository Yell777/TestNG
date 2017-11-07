package TestCourseNG;

import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

import static java.nio.file.Files.createTempDirectory;

/**
 * Created by User on 03.11.2017.
 */
public class TestFile extends TestBase {


    @Test(groups = "positive",priority = 1, dataProvider = "name")
    public void TestCreateNewFileTXT(String nameFile) throws IOException {
        String absoluteFilePath = path + "/" + nameFile + ".txt";

        file = new File(absoluteFilePath);
        Assert.assertTrue(file.createNewFile(),"Файл не создан или уже существует");
        System.out.println("Файл создан во временной директории :" + file);

    }
    @Test(groups = "positive",priority = 1 , dataProvider = "name")
    public void TestCreateFileDoc(String nameFile) throws IOException {
        String absoluteFilePath = path + "/" + nameFile + ".doc";

        file = new File(absoluteFilePath);
        Assert.assertTrue(file.createNewFile(),"Файл не создан или уже существует");
        System.out.println("Файл создан во временной директории :" + file);
    }
    @Test(groups = "positive" , priority = 1 , dataProviderClass = DataProviders.class, dataProvider = "loadUserFromFile")
    public void TestNewFileCSV(String test) throws IOException {
        String absoluteFilePath = path + "/" + test + ".csv";

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

}
