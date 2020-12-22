package com.mashibing.juc.c03;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 *  阶段
 */
public class T03_09_Phaser {

    static Random r = new Random();

    static Phaser phaser = new MarriagePhaser();


    public static void main(String[] args) {
        phaser.bulkRegister(7);

        for (int i=0; i< 5; i++) {
            new Thread(new Person("宾客" + i)).start();
        }

        new Thread(new Person("新郎")).start();
        new Thread(new Person("新娘")).start();

    }

    static void millisleep(int mill) {
        try {
            TimeUnit.MILLISECONDS.sleep(mill);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private static class Person implements Runnable {
        String name;
        public Person() {
        }

        public Person(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            arrived();
            eat();
            leave();
            hug();
        }

        private void arrived() {
            millisleep(r.nextInt(1000));
            System.out.printf("%s, 到达现场 \n", name);
            phaser.arriveAndAwaitAdvance();
        }

        private void eat() {
            millisleep(r.nextInt(1000));
            System.out.printf("%s, 吃完饭了 \n", name);
            phaser.arriveAndAwaitAdvance();
        }

        private void leave() {
            millisleep(r.nextInt(1000));
            System.out.printf("%s, 离开了 \n", name);
            phaser.arriveAndAwaitAdvance();
        }

        private void hug() {
            if ("新郎".equals(name) || "新娘".equals(name)) {
                millisleep(r.nextInt(1000));
                System.out.printf("%s, 洞房 \n", name);
                phaser.arriveAndAwaitAdvance();
            } else {
                phaser.arriveAndDeregister();
            }
        }


    }


    private static class MarriagePhaser extends Phaser {
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase) {
                case 0:
                    System.out.println("所有人都到齐了，" + registeredParties);
                    System.out.println();
                    return false;
                case 1:
                    System.out.println("所有人都吃完饭了，" + registeredParties);
                    System.out.println();
                    return false;
                case 2:
                    System.out.println("所有人都离开了，" + registeredParties);
                    System.out.println();
                    return false;
                case 3:
                    System.out.println("新郎新娘抱抱，婚礼结束" + registeredParties);
                    System.out.println();
                    return true;
                default:
                    return true;
            }
        }
    }
}
