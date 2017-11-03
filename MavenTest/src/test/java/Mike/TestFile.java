package Mike;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by User on 03.11.2017.
 */
public class TestFile {
    private static File file;

    @BeforeTest
    public void setupNewFile() throws IOException {
    file =File.createTempFile("tmp", ".txt", new File("C:/"));
    }

    public void setupNewFile() {
        file =File.createTempFile("tmp", ".txt", new File("C:/"));
    }

}
