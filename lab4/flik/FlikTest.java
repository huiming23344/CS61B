package flik;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertTrue;

public class FlikTest {

    @Test
    public void FlikTest1(){
        int a = 128;
        int b = 128;
        boolean c = Flik.isSameNumber(a, b);
        assertTrue(c);
    }
}
