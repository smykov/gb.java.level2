package ru.gb.smykov.level2.HW5;

import java.util.Arrays;

public class App {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        new App().start();
    }

    private void start() {
        firstMethod();
        SecondMethod();
    }

    private void firstMethod() {
        float[] arr = initArray();
        long startTime = System.currentTimeMillis();
        fillArrayCalculatedData(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("First thread time: " + (endTime - startTime) + " ms.");
    }

    private void SecondMethod() {
        float[] arr = initArray();

        float[] leftHalf = new float[HALF];
        float[] rightHalf = new float[HALF];

        long startTime = System.currentTimeMillis();

        cutArray(arr, leftHalf, rightHalf);

        Thread threadLeftHalf = new Thread(() -> fillArrayCalculatedData(leftHalf));
        Thread threadRightHalf = new Thread(() -> fillArrayCalculatedData(rightHalf));

        threadLeftHalf.start();
        threadRightHalf.start();

        try {
            threadRightHalf.join();
            threadLeftHalf.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mergeArray(arr, leftHalf, rightHalf);

        long endTime = System.currentTimeMillis();
        System.out.println("Second thread time: " + (endTime - startTime) + " ms.");
    }

    private static float[] initArray() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);
        return arr;
    }

    private static void mergeArray(float[] arr, float[] leftHalf, float[] rightHalf) {
        long startTime = System.currentTimeMillis();
        System.arraycopy(leftHalf, 0, arr, 0, HALF);
        System.arraycopy(rightHalf, 0, arr, HALF, HALF);
        System.out.println("Merge array time:" + (System.currentTimeMillis() - startTime + " ms."));

    }

    private static void cutArray(float[] arr, float[] leftHalf, float[] rightHalf) {
        long startTime = System.currentTimeMillis();
        System.arraycopy(arr, 0, leftHalf, 0, HALF);
        System.arraycopy(arr, HALF, rightHalf, 0, HALF);
        System.out.println("Split array time:" + (System.currentTimeMillis() - startTime + " ms."));
    }

    private static void fillArrayCalculatedData(float[] arr) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5.0f) * Math.cos(0.2f + i / 5.0f) * Math.cos(0.4f + i / 2.0f));
        }
        System.out.println("Calculate array time:" + (System.currentTimeMillis() - startTime + " ms."));
    }
}
