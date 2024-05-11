package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
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
                {"Самка", false},
                {"Slimak", true}, // если не "Самец" и не "Самка", второй аргумент не имеет значения
                {"Абырвалг", false}
        };
    }

    // если лев самец, то грива есть
    // если самка, то гривы нет
    // если пол не передан, ловим выброс исключения
    @Test
    public void lionMaleTest() throws Exception {
        if (lionSex.equals("Самец") | lionSex.equals("Самка")) {
            Lion l = new Lion(lionSex, new Feline());
            assertEquals(l.doesHaveMane(), hasMane);
        } else {
            assertThatExceptionOfType(Exception.class).isThrownBy(() -> {
                Lion l = new Lion(lionSex, new Feline());
                assertEquals(l.doesHaveMane(), hasMane);
            });
        }
    }
}


