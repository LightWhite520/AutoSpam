package com.sparkle;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Sparkle_A on 2022/3/8
 */
public class RandomUtils {
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    public static int nextInt(int min, int max) {
        return (int) nextDouble(min, max);
    }

    public static float nextFloat(float min, float max) {
        return (float) nextDouble(min, max);
    }

    public static double nextDouble(double min, double max) {
        if (min == max) return max;
        return min > max ? random.nextDouble(max, min) : random.nextDouble(min, max);
    }
}
