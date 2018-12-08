package com.vv.objects;

import java.util.List;

final class Calculator {
    private static List<Animal> animals = WorldView.animals;
    private static final double G = 6.177777777;


    static void calca(int xi) {
        Animal animal = animals.get(xi);
        for (int i = 0; i < animals.size(); i++) {
            if (i != xi) {
                Animal animal2 = animals.get(i);
                double ax = animal2.x - animal.x;
                double ay = animal2.y - animal.y;
                double magn = Math.sqrt(ax*ax+ay*ay);
                ax/=magn;
                ay/=magn;
                double g = G*animal2.m/magn/magn;
                ax*=g;
                ay*=g;
                animal.vx = animal.vx + ax;
                animal.vy = animal.vy + ay;
            }
            animal.fx = animal.x + animal.vx;
            animal.fy = animal.y + animal.vy;
        }
    }

    static int checks(int xi) {
        Animal animal = animals.get(xi);
        int c = 0;
        for (int i = 0; i < animals.size(); i++) {
            if (i != xi) {
                Animal animal2 = animals.get(i);
                double ax = animal2.fx - animal.fx;
                double ay = animal2.fy - animal.fy;
                double magn = Math.sqrt(ax * ax + ay * ay);

                if (magn <= animal.R + animal2.R) {
                    if (animal == animal2) {
                        if (magn < (animal.R + animal2.R)/2) {
                            c = calcc(xi, i);
                            break;
                        }
                    }
                    else {
                        calcs(xi, i);
                        break;
                    }
                }
            }
        }
        return c;
    }

    static int calcc(int xi, int i) {
        int c = 0;
        Animal animal = animals.get(xi);
        Animal animal2 = animals.get(i);


        if(animal.m >= animal2.m) {
            animal.R += animal2.R/10;
            double dx = animal.vx;
            double dy = animal.vy;
            animal.vx = animal.m*animal.vx + animal2.m*animal2.vx;
            animal.vy = animal.m*animal.vy + animal2.m*animal2.vy;
            animal.m += animal2.m;
            animal.vx /= animal.m;
            animal.vy /= animal.m;
            dx = animal.vx - dx;
            dy = animal.vy - dy;
            animal.fx += dx;
            animal.fy += dy;
            animals.remove(i);
            if (i > xi) c = 1;
            if (i < xi) c = 2;
        }
        else {
            animal2.R += animal.R/10;
            double dx = animal2.vx;
            double dy = animal2.vy;
            animal2.vx = animal2.m*animal2.vx + animal.m*animal.vx;
            animal2.vy = animal2.m*animal2.vy + animal.m*animal.vy;
            animal2.m += animal.m;
            animal2.vx /= animal2.m;
            animal2.vy /= animal2.m;
            dx = animal2.vx - dx;
            dy = animal2.vy - dy;
            animal2.fx += dx;
            animal2.fy += dy;
            animals.remove(xi);
            c = -1;
        }

        /*animals.remove(i);
        if (i > xi) c = 1;
        if (i < xi) c = 2;*/

        /*animals.remove(xi);
        c = -1;*/
        return c;
    }

    static void calcs(int xi, int i) {
        Animal animal = animals.get(xi);
        Animal animal2 = animals.get(i);

        double ax = animal2.fx - animal.fx;
        double ay = animal2.fy - animal.fy;
        double magn = Math.sqrt(ax*ax+ay*ay);

        //светло-серый вектор
        double dvx = animal.vx-animal2.vx;
        double dvy = animal.vy-animal2.vy;
        //красный вектор
        double v1 = (dvx*ax+dvy*ay)/magn;
        double v2 = 0;

        // Расчёт изменившийся скорости
        double u1 = (v1*(animal.m-animal2.m)+2*animal2.m*v2)/(animal.m+animal2.m);
        double u2 = (v2*(animal2.m-animal.m)+2*animal.m*v1)/(animal2.m+animal.m);

        //изменение скоростей
        double dv1 = u1 - v1;
        double dv2 = u2 - v2;


        //Время движения до столкновения
        double dx = animal2.fx - animal.fx;
        double dy = animal2.fy - animal.fy;
        double t = (animal.R+animal2.R - Math.sqrt(dx*dx+dy*dy)) / v1; //0 >= t <= 1

        //Движение до столкновения
        animal.fx = animal.fx - animal.vx*(1-t);
        animal.fy = animal.fy - animal.vy*(1-t);

        animal2.fx = animal2.fx - animal2.vx*(1-t);
        animal2.fy = animal2.fy - animal2.vy*(1-t);

        //Расчитывание скорости
        ax/=magn;
        ay/=magn;
        animal.vx += dv1 * ax;
        animal.vy += dv1 * ay;
        animal2.vx += dv2 * ax;
        animal2.vy += dv2 * ay;


        //Движение после столкновения
        animal.fx += animal.vx*(1-t);
        animal.fy += animal.vy*(1-t);

        animal2.fx += animal2.vx*(1-t);
        animal2.fy += animal2.vy*(1-t);

        //Проверка последующих столкновений
        checks(xi);
        checks(i);
    }

}
