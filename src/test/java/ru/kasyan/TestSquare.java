package ru.kasyan;

import io.qameta.allure.Allure;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.socialquantum.testtasks.Square;
import ru.socialquantum.testtasks.SquareFactory;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Kasyanenko Konstantin
 * on 08.09.2017.
 */
@RunWith(value = Parameterized.class)
public class TestSquare {
    public double sideLengthForSquareTest;
    public double side=12.3;
    public TestSquare(Double sideLengthForSquareTest) {
        this.sideLengthForSquareTest = sideLengthForSquareTest;
    }

    @Parameterized.Parameters
    public static Collection<Double> square() {
        return Arrays.asList(0., -10.2);
    }

    @Test
    @DisplayName("Проверка квадрата ")
    public void checkSquare() {
        Allure.addDescription("Сторона квадрата = " + sideLengthForSquareTest);
        Exception ex = null;
        try {
            Square square = SquareFactory.newSquare(sideLengthForSquareTest);
        } catch (Exception e) {
            ex = e;
        }
        Assert.assertNotEquals("Здесь ожидался exception", ex, null);
    }

    @Test
    @DisplayName("Проверка квадрата")
    public void checkSquare1() {
        Allure.addDescription("Сторона квадрата = " + side);
        Exception ex = null;
        try {
            Square square = SquareFactory.newSquare(side);
        } catch (Exception e) {
            ex = e;
        }
        Assert.assertEquals("Здесь не дожно быть Exception", ex, null);
    }
}
