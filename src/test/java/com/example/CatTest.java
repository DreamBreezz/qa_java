package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    public CatTest() {}
    Feline feline = new Feline();
    Cat cat = new Cat(feline);

    // кошка издаёт звук "мяу"
    @Test
    public void getSoundTest() {
        assertEquals(cat.getSound(), "Мяу");
    }

    // кошка ест еду хищника - "Животные", "Птицы", "Рыба"
    @Test
    public void getFoodTest() throws Exception {
        assertEquals(cat.getFood(), List.of("Животные", "Птицы", "Рыба"));
    }


    // мокируем feline и cat
    @Mock
    Feline felineMock;

    @Mock
    Cat catMock = new Cat(felineMock);

    @Test
    public void getSoundMockedTest() {
        catMock.getSound();
        verify(catMock).getSound();
    }

    @Test
    public void getFoodMockTest() throws Exception {
        catMock.getFood();
        verify(catMock).getFood();
    }
}