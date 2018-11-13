package com.mmall.concurrency.example.syncContainer;

import com.mmall.concurrency.annoations.NotThreadSafe;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-11-13
 * Time: 下午3:20
 */
@NotThreadSafe
public class VectorExample2 {

    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {

        while (true) {

            for (int i = 0; i < 10; i++) {
                vector.add(i);

                Thread thread1 = new Thread() {
                    public void run() {
                        for (int i = 0; i < vector.size(); i++) {
                            vector.remove(i);
                        }
                    }

                };

                Thread thread2 = new Thread() {
                    public void run() {
                        for (int i = 0; i < vector.size(); i++) {
                            vector.get(i);
                        }
                    }
                };

                thread1.start();
                thread2.start();
            }

        }
    }
}
