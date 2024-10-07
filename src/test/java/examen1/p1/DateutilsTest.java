package examen1.p1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DateutilsTest {

    //Probar con hoy que es Lunes
    @Test
    public void testDateutilsToday2024() {
        DateUtils dateUtils = new DateUtils();
        String expectedResult  = "MONDAY";
        String actualResult = dateUtils.getDayOfWeek("2024-07-10");
        Assertions.assertEquals(expectedResult, actualResult);
    }

    //Probar con un año anterior
    @Test
    public void testDateutils2023() {
        DateUtils dateUtils = new DateUtils();
        String expectedResult  = "TUESDAY";
        String actualResult = dateUtils.getDayOfWeek("2023-07-11");
        Assertions.assertEquals(expectedResult, actualResult);
    }


    @Test
    public void testDateutils2028() {
        DateUtils dateUtils = new DateUtils();
        String expectedResult  = "TUESDAY";
        String actualResult = dateUtils.getDayOfWeek("2028-07-11");
        Assertions.assertEquals(expectedResult, actualResult);
    }

    //El metodo DateUtils solo funciona cada 5años bien delante o detras
    @Test
    public void testDateutils2033() {
        DateUtils dateUtils = new DateUtils();
        String expectedResult  = "TUESDAY";
        String actualResult = dateUtils.getDayOfWeek("2028-07-11");
        Assertions.assertEquals(expectedResult, actualResult);
    }


    @Test
    public void day0() {
        DateUtils dateUtils = new DateUtils();
        String expectedResult  = "INVALID";
        String actualResult = dateUtils.getDayOfWeek("2024-07-00");
        Assertions.assertEquals(expectedResult, actualResult);
    }


}
