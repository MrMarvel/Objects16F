package com.vv.objects.Calculator;

import com.vv.objects.Animal;

public class Collision implements Comparable<Collision>{
    private Animal animal;
    private Animal animal2;
    private double t;

    public Animal getAnimal() {
        return animal;
    }

    public Animal getAnimal2() {
        return animal2;
    }

    public double getT() {
        return t;
    }

    public Collision(Animal animal, Animal animal2, double t) {
        this.animal = animal;
        this.animal2 = animal2;
        this.t = t;
    }

    @Override
    public int compareTo(Collision arg0) {
        if (animal == arg0.animal2 && animal2 == arg0.animal) return 0;
        if (t > arg0.t) return 1;
        return -1;
    }
}