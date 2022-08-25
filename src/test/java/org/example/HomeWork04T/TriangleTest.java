package org.example.HomeWork04T;

import org.example.HomeWork04.Triangle;
import org.example.HomeWork04.MyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TriangleTest {

    static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    int x = 4;
    int y = 4;
    int z = 6;
    boolean triangleExist = (x + y) > z || (x + z) > y || (y + z) > x; //сумма двух сторон треугольника должна быть больше третьей стороны

    @Test
    void simpleTest(){

        logger.info("simple test");
        assertTrue(triangleExist, "Не true");
    }

    @ParameterizedTest
    @CsvSource({"1, 1, 1, 0.4330127018922193"})
    void positiveTestWithCsvSource(int x, int y, int z, double s) throws MyException {
        logger.info("positive test");
        Triangle triangle = new Triangle();
        Assertions.assertEquals(s, triangle.area(x, y, z));
    }

    @ParameterizedTest
    @CsvSource({"1, 1, -1"})
    void negativeTestWithCsvSource(int x, int y, int z) throws MyException {
        logger.info("negative test");
        Triangle triangle = new Triangle();
        Assertions.assertThrows(MyException.class, () -> triangle.area(x, y, z));
    }



}
