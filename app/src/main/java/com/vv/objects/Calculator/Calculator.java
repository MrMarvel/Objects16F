package com.vv.objects.Calculator;

import com.vv.objects.Animal;
import com.vv.objects.MainActivity;
import com.vv.objects.WorldView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public final class Calculator {
    private final static List<Animal> animals = WorldView.animals;
    private final static double G = 6.177777777;


    public static void calca(int xi) {
        Animal animal = animals.get(xi);
        if (animal.stationar) return;
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
            //animal.fx = animal.x + animal.vx ;
            //animal.fy = animal.y + animal.vy;
        }
    }

    /*static int checks(int xi) {
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
    }*/

    public static void checks() {
        double t = 0;
        HashSet<Animal> clear = new HashSet<Animal>();
        for (Animal a : animals) {
            clear.add(a);
        }
        while (t < 1) {

            TreeSet<Collision> collisions = new TreeSet<Collision>();

            for (int xi = 0; xi < animals.size(); xi++) {
                Animal animal = animals.get(xi);

                for (int i = 0; i < animals.size(); i++) {
                    if (i != xi) {
                        Animal animal2 = animals.get(i);
                        if (!animal.type.equals(animal2.type)) {
                            double x = animal.fx - animal2.fx;
                            double y = animal.fy - animal2.fy;
                            double vx = animal.vx - animal2.vx;
                            double vy = animal.vy - animal2.vy;
                            double r = animal.R + animal2.R;

                            x -= vx; //Для проверки движения НА шар
                            y -= vy;

                            double a = vx*vx + vy*vy;
                            double b = 2*(x*vx + y*vy);
                            double c = x*x + y*y - r*r;

                            Function f = new Function(a, b, c);

                            if (f.всеПодходят) collisions.add(new Collision(animal, animal2, 0));
                            else if (f.вывестиКорни().size() > 0) {
                                if (f.вывестиКорни().get(0) <= 2 && f.вывестиКорни().get(0) >= 1) {
                                    collisions.add(new Collision(animal, animal2, f.вывестиКорни().get(0) - 1)); //-1 потому что мы сделали -vx, -vy
                                }
                            }
                        }
                        else {
                            double ax = animal2.fx - animal.fx;
                            double ay = animal2.fy - animal.fy;
                            double magn = Math.sqrt(ax * ax + ay * ay);

                            if (magn <= animal.R + animal2.R) {
                                if (magn < (animal.R + animal2.R)/2) {
                                    calcc(xi, i);
                                }
                            }
                        }
                    }
                }
            }
            if (!collisions.isEmpty()) {
                Collision collision = collisions.first();
                Animal animal = collision.getAnimal();
                Animal animal2 = collision.getAnimal2();

                clear.remove(animal);
                clear.remove(animal2);

                animal.fx += animal.vx*collision.getT()-t; //подъехать
                animal.fy += animal.vy*collision.getT()-t;
                calcs(animal, animal2); //изменить скорость
                t = collision.getT();
            }
            else t = 1;
        }

        for (Animal a : clear) {
            a.fx = a.x + a.vx;
            a.fy = a.y + a.vy;
        }


    }

    public static void calcc(int xi, int i) {
        //int c = 0;
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
            //if (i > xi) c = 1;
            //if (i < xi) c = 2;
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
            //c = -1;
        }

        /*animals.remove(i);
        if (i > xi) c = 1;
        if (i < xi) c = 2;*/

        /*animals.remove(xi);
        c = -1;*/
        //return c;
    }

    static void calcs(Animal animal, Animal animal2) {
        //Animal animal = animals.get(xi);
        //Animal animal2 = animals.get(i);

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
        /*double dx = animal2.fx - animal.fx;
        double dy = animal2.fy - animal.fy;
        double t = (animal.R+animal2.R - Math.sqrt(dx*dx+dy*dy)) / v1; //0 >= t <= 1*/

        //Движение до столкновения
        /*animal.fx = animal.fx - animal.vx*(1-t);
        animal.fy = animal.fy - animal.vy*(1-t);

        animal2.fx = animal2.fx - animal2.vx*(1-t);
        animal2.fy = animal2.fy - animal2.vy*(1-t);*/

        //Расчитывание скорости
        ax/=magn;
        ay/=magn;
        animal.vx += dv1 * ax;
        animal.vy += dv1 * ay;
        animal2.vx += dv2 * ax;
        animal2.vy += dv2 * ay;


        //Движение после столкновения
        /*animal.fx += animal.vx*(1-t);
        animal.fy += animal.vy*(1-t);

        animal2.fx += animal2.vx*(1-t);
        animal2.fy += animal2.vy*(1-t);*/

        //Проверка последующих столкновений
        //checks(xi);
        //checks(i);
    }

    public static void checkBorder(int xi) {
        Animal animal = animals.get(xi);
        if (animal.fx + animal.R > MainActivity.sizeOfScreen.x) {
            animal.vx = -Math.abs(animal.vx)*0.8;
        } else if (animal.fx - animal.R < 0) {
            animal.vx = Math.abs(animal.vx)*0.8;
        }
        if (animal.fy + animal.R > MainActivity.sizeOfScreen.y) {
            animal.vy = -Math.abs(animal.vy)*0.8;
        } else if (animal.fy - animal.R < 0) {
            animal.vy = Math.abs(animal.vy)*0.8;
        }
    }

}
