package net.mtgsaber.lib.sets.data;

import java.util.HashSet;
import java.util.Set;

/**
 * Finished, TODO: Test
 * @param <T>
 */
public class TypedSet<T> {
    private final Class<T> TYPE;
    private final Set<T> VAL;

    public TypedSet(Class<T> type, Set<T> val) {
        TYPE = type;
        VAL = val;
    }

    public Class<T> type() {
        return TYPE;
    }

    public Set<T> set() {
        return new HashSet<>(VAL);
    }
}
