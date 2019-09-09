package net.mtgsaber.lib.sets.nonset;

import java.util.*;

public class NonSetOps {
    /**
     * exhaustive approach to finding the common elements of two arrays.
     * Duplicates are treated as "unique" elements, such that each instance of a duplicate
     * value is counted separately.
     * Time Complexity, m = smaller array length, n = larger array length:
     *  - Sigma(mn)
     *  - Theta(mn)
     *  - Omega(m)
     * @param l1 is to be an array in non-decreasing order
     * @param l2 is to be an array in non-decreasing order
     * @param comparator to compare l1 against l2
     * @param <T> the type of the arrays
     * @return all common elements. ex.: ({1, 2, 3, 3, 3}, {0, 2, 3, 3, 5}) -> {2, 3, 3}
     */
    public static <T> T[] intersection(T[] l1, T[] l2, Comparator<T> comparator) {
        // take care of all trivial cases
        if (l1 == null || l2 == null) // null -> null
            return null;
        if (l1.length == 0 || l2.length == 0) // empty -> empty
            return Arrays.copyOf(l1, 0);
        if (l1.length == 1) { // trivial
            if (Arrays.binarySearch(l2, l1[0]) > -1)
                return Arrays.copyOf(l1, 1);
            else
                return null;
        }
        if (l2.length == 1) { // trivial
            if (Arrays.binarySearch(l1, l2[0]) > -1)
                return Arrays.copyOf(l2, 1);
            else
                return null;
        }

        /* *** GENERAL CASE *** */
        // decide which array is bigger
        int count = 0;
        T[] a, b;
        if (l1.length >= l2.length) {
            a = l1;
            b = l2;
        } else {
            a = l2;
            b = l1;
        }

        // flag the positions of all members of the intersection
        boolean[] flags = new boolean[b.length];
        for (T o : a)
            for (int j=0; j < b.length; j++) {
                if (comparator.compare(o, b[j]) < 0) // leave early
                    break;
                if (comparator.compare(o, b[j]) == 0 && !flags[j]) {
                    flags[j] = true;
                    count++;
                    break;
                }
            }

        // use flags to copy over members of the intersection
        ArrayList<T> retTemp = new ArrayList<>(count);
        for (int i=0; i < flags.length; i++)
            if (flags[i])
                retTemp.add(b[i]);

        // convert back to array
        return retTemp.toArray(Arrays.copyOf(b, 0));
    }


}
