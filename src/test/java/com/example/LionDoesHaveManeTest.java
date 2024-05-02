package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionDoesHaveManeTest {
    String lionSex;
    boolean doesHaveMane;

    public LionDoesHaveManeTest(String lionSex, boolean doesLionHasMane) throws Exception {
        this.lionSex = lionSex;
        this.doesHaveMane = doesLionHasMane;
    }

    // пол и наличие гривы
    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {null, true}
        };
    }

    // если лев самец, то грива есть
    // если самка, то гривы нет
    // если пол не передан, ловим выброс исключения
    @Test (expected = Exception.class)
    public void lionMaleTest() throws Exception {
        Lion lion = new Lion(lionSex, new Feline());
            assertEquals(lion.doesHaveMane(), doesHaveMane);
        throw new Exception();
    }

}
