package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;
    Feline feline; // добавил инъекцию зависимости через конструктор

    public Lion(String sex, Feline feline) throws Exception {

        this.feline = feline; // инъекция через конструктор

        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самей или самка");
        }
    }

    //Feline feline = new Feline(); - убрал зависимость

    public int getKittens() {
        return feline.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}
