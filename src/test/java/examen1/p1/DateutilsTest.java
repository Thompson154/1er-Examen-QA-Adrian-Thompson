package examen1.p1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DateutilsTest {

    //Probar con hoy que es Lunes
    @Test
    public void testDateutilsToday2024() {
        DateUtils dateUtils = new DateUtils();
        String expectedResult  = "MONDAY";
        String actualResult = dateUtils.getDayOfWeek("2024-10-07");
        Assertions.assertEquals(expectedResult, actualResult);
    }


    @Test
    public void day0() {
        DateUtils dateUtils = new DateUtils();
        String expectedResult  = "INVALID";
        String actualResult = dateUtils.getDayOfWeek("2024-10-00");
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void dayNegative() {
        DateUtils dateUtils = new DateUtils();
        String expectedResult  = "INVALID";
        String actualResult = dateUtils.getDayOfWeek("2024--10-00");
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void otherMoth() {
        DateUtils dateUtils = new DateUtils();
        String expectedResult  = "INVALID";
        String actualResult = dateUtils.getDayOfWeek("2024-14-00");
        Assertions.assertEquals(expectedResult, actualResult);
    }


}
