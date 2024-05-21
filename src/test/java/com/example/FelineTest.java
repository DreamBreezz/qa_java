package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    Feline feline = new Feline();

    @Test
    public void getKittensNoArgsReturnOneTest() {
        assertEquals(feline.getKittens(), 1);
    }

    @Test
    public void getKittensSomeArgsReturnArgsTest() {
        assertEquals(feline.getKittens(2), 2);
    }

    @Test
    public void eatMeatReturnFoodListTest() throws Exception {
        assertEquals(feline.eatMeat(), List.of("Животные", "Птицы", "Рыба"));
    }

    @Test
    public void getFamilyReturnArtsTest() {
        assertEquals(feline.getFamily(), "Кошачьи");
    }

    @Mock
    Feline felineMock;
    // тесты, что все методы запускабельные

    @Test
    public void eatMeatRunsTest() throws Exception {
        felineMock.eatMeat();
        verify(felineMock).eatMeat();
    }

    @Test
    public void getFamilyRunsTest() {
        felineMock.getFamily();
        verify(felineMock).getFamily();
    }

    @Test
    public void getKittensRunsTest() {
        felineMock.getKittens();
        verify(felineMock).getKittens();
    }

    @Spy
    Feline felineSpy;

    // отслеживаем, что при запуске без аргументов есть запуск с аргументом 1
    @Test
    public void getKittensWithoutArgsRunsGetKittensWithArgTest() {
        felineSpy.getKittens();
        verify(felineSpy).getKittens(1);
    }
}