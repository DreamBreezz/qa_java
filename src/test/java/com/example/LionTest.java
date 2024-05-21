package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    public LionTest() throws Exception {
    }
    Lion lion = new Lion("Самка", new Feline());

    // у льва 1 котёнок
    @Test
    public void lionGetKittensTest() {
        assertEquals(lion.getKittens(), 1);
    }

    // еда льва - "Животные", "Птицы", "Рыба"
    @Test
    public void lionGetFoodTest() throws Exception {
        assertEquals(lion.getFood(), List.of("Животные", "Птицы", "Рыба"));
    }

    // лев выбрасывает ошибку, если ему подсунуть не "Самец" или "Самка"
    @Test (expected = Exception.class)
    public void lionThrowsExceptionTest() throws Exception {
        Lion l = new Lion("Абырвалг", new Feline());
    }


    // льва внутри тестов можно создавать с любыми параметрами
    // feline мокируем
    @Mock
    Feline felineMock;

    @Test
    public void lionGetKittensMockedTest() throws Exception {
        Lion l = new Lion("Самка", felineMock);
        l.getKittens();
        verify(felineMock).getKittens();
    }

    @Test
    public void lionGetFoodMockedTest() throws Exception {
        Lion l = new Lion("Самец", felineMock);
        l.getFood();
        verify(felineMock).getFood("Хищник");
    }
}