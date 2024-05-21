package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionDoesHaveManeTest {
    private String lionSex;
    private boolean hasMane;

    public LionDoesHaveManeTest(String lionSex, boolean doesLionHasMane) {
        this.lionSex = lionSex;
        this.hasMane = doesLionHasMane;
    }

    // пол и наличие гривы
    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false} // только валидные параметры
        };
    }

    // если лев самец, то грива есть
    // если самка, то гривы нет
    // если пол передан невалидный, выброс исключения ловим в LionTest.class
    @Test
    public void lionManeTest() throws Exception {
        Lion l = new Lion(lionSex, new Feline());
        assertEquals(l.doesHaveMane(), hasMane);
    }
}


