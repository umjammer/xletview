package net.beiker.xletview.util;

public class ArraySorter {
    /*
     * * Sort in the same array
     */
    public static void sort(Object[] a, Comparer comparer) {
        sort(a, null, 0, a.length - 1, true, comparer);
    }

    /*
     * * Sort a and b, using a as the reference
     */
    public static void sort(Object[] a, Object[] b, int from, int to, boolean ascending, Comparer comparer) {
        // No sort
        if (a == null || a.length < 2)
            return;

        // sort using Quicksort
        int i = from, j = to;
        Object center = a[(from + to) / 2];
        do {
            if (ascending) {
                while ((i < to) && (comparer.compare(center, a[i]) > 0))
                    i++;
                while ((j > from) && (comparer.compare(center, a[j]) < 0))
                    j--;
            } else {
                // Decending sort
                while ((i < to) && (comparer.compare(center, a[i]) < 0))
                    i++;
                while ((j > from) && (comparer.compare(center, a[j]) > 0))
                    j--;
            }
            if (i < j) {
                // Swap elements
                Object temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                // Swap in b array if needed
                if (b != null) {
                    temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                }
            }
            if (i <= j) {
                i++;
                j--;
            }
        }
        while (i <= j);
        // Sort the rest
        if (from < j)
            sort(a, b, from, j, ascending, comparer);
        if (i < to)
            sort(a, b, i, to, ascending, comparer);
    }
}