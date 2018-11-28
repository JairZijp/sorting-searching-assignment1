package nl.hva.ict.ss;

import sun.awt.image.ImageWatched;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class AdvancedSorts {

    /**
     * Implement quicksort using LinkedList only! Usage of anything but LinkedList will result in failing the
     * assignment!
     *
     * @param unsorted
     * @param <E>
     *
     * @return
     */
    public static <E extends Comparable<E>> LinkedList<E> quickSort(LinkedList<E> unsorted) {
        shuffle(unsorted);
        if (unsorted.size() <= 1) return unsorted;

        LinkedList<E> low = new LinkedList<>();
        LinkedList<E> high = new LinkedList<>();

        Iterator<E> iterator = unsorted.iterator();
        E pivot = iterator.next();

        do {
            E item = iterator.next();
            if (item.compareTo(pivot) < 0) low.add(item);
            else high.add(item);
        } while (iterator.hasNext());

        low = quickSort(low);
        high = quickSort(high);

        LinkedList<E> sorted = new LinkedList<>();
        sorted.addAll(low);
        sorted.add(pivot);
        sorted.addAll(high);
        return sorted;
    }

    /**
     * Implement quicksort using arrays only! Usage of anything but arrays will result in failing the assignment!
     *
     * @param unsorted
     * @param <E>
     *
     * @return
     */
    public static <E extends Comparable<E>> E[] quickSort(E[] unsorted) {
        shuffle(unsorted);
        int low = 0, high = unsorted.length;
        quickSort(unsorted, low, high - 1);

        return unsorted;
    }

    private static void quickSort(Comparable[] unsorted, int low, int high) {
        if (high <= low) return;
        int j = partition(unsorted, low, high);
        quickSort(unsorted, low, j - 1);
        quickSort(unsorted, j + 1, high);
    }

    private static int partition(Comparable[] a, int low, int high) {
        int i = low;
        int j = high + 1;
        Comparable v = a[low];
        while (true) {
            // find item on low to swap
            while (less(a[++i], v)) {
                if (i == high) break;
            }

            // find item on high to swap
            while (less(v, a[--j])) {
                if (j == low) break;      // redundant since a[low] acts as sentinel
            }

            // check if pointers cross
            if (i >= j) break;

            exch(a, i, j);
        }

        // put partitioning item v at a[j]
        exch(a, low, j);

        // now, a[low .. j-1] <= a[j] <= a[j+1 .. high]
        return j;
    }

    private static boolean less(Comparable v, Comparable w) {
        if (v == w) return false;   // optimization when reference equals
        return v.compareTo(w) < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // exchange a[i] and a[j]
    private static <E extends Comparable<E>> void exch(LinkedList<E> a, int i, int j) {
        E swap = a.get(i);
        a.set(i, a.get(j));
        a.set(j, swap);
    }

    static <E extends Comparable<E>> void shuffle(E[] ar) {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            E a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    static <E extends Comparable<E>> void shuffle(LinkedList<E> ar) {
        Collections.shuffle(ar);
    }
}
