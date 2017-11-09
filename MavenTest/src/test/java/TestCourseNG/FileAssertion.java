package TestCourseNG;

import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;

import java.io.File;

/**
 * Created by User on 09.11.2017.
 */
public class FileAssertion extends Assertion {

    abstract private class FileAssert implements IAssert {
        private final String message;

        public FileAssert(String message) {
            this.message = message;
        }

        @Override
        public String getMessage() {
            return message;
        }

        @Override
        public Object getActual() {
            return null;
        }

        @Override
        public Object getExpected() {
            return null;
        }

        @Override
        abstract public void doAssert();
    }

    public void assertIsFileCreate(final String path) {
        doAssert(new FileAssert("There are no file located in " + path) {
            @Override
            public void doAssert() {
                assertTrue(new File(path).exists(),getMessage());
            }
        });
    }



}
