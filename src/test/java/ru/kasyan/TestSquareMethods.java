package ru.kasyan;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.model.Label;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.socialquantum.testtasks.Square;
import ru.socialquantum.testtasks.SquareFactory;
import ru.socialquantum.testtasks.SquareI;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Kasyanenko Konstantin
 * on 06.09.2017
 */

@RunWith(value = Parameterized.class)
public class TestSquareMethods {

    public Double sideLength;

    public TestSquareMethods(Double param) {
        this.sideLength = param;
    }

    @Parameterized.Parameters
    public static Collection<Double> length() {
        return Arrays.asList(5.6, 15.3, 24.8, 35.0, 100.);
    }

    @Test
    @DisplayName("Проверка метода sideLength")
    public void checkSideLength() {
        Square square = SquareFactory.newSquare(sideLength);
        Allure.addDescription("Ожидаемый параметр:" + sideLength.toString() +
                "\nВозвращенный парметр:" + square.sideLength());
        Assert.assertTrue("Не совпала ожидаемая сторона квадрата", sideLength == square.sideLength());
    }


    @Test
    @DisplayName("Проверка метода equalsSquare")
    public void checkEqualsSquare() {
        Square square = SquareFactory.newSquare(sideLength);
        Allure.addDescription("Сторона квадрата = " + sideLength);
        Assert.assertTrue("Внимание, метод еквивалентности квадратов работает не верно!",
                square.equalsSquare(new SquareI(sideLength)));
    }


    @Test
    @DisplayName("Проверка возведения в квадрат")
    public void checkmMethodSquare() {
        Square square = SquareFactory.newSquare(sideLength);
        double sq = sideLength * sideLength;
        Allure.addDescription("Сторона квадрата = " + sideLength);
        Assert.assertTrue("Квадрат не соврпал: ожидалось " + sq + ", вернулось " + square.square(), square.square() == (sideLength * sideLength));
    }


}
