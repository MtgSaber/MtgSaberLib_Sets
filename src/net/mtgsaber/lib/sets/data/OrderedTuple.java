package net.mtgsaber.lib.sets.data;

/**
 * FINISHED; TODO: test
 */
public class OrderedTuple {
    private final int CARDINALITY;
    private final Class[] TYPES;
    private Object[] VALS;

    public OrderedTuple(Object... vals) {
        if (vals == null)
            CARDINALITY = 0;
        else
            CARDINALITY = vals.length;
        if (CARDINALITY != 0) {
            TYPES = new Class[CARDINALITY];
            VALS = new Object[CARDINALITY];
            for (int i=0; i<CARDINALITY; i++) {
                TYPES[i] = vals[i].getClass();
                VALS[i] = vals[i].getClass();
            }
        } else {
            TYPES = new Class[0];
            VALS = new Object[0];
        }
    }

    public int cardinality() {
        return CARDINALITY;
    }

    public Class[] types() {
        Class[] ret = new Class[CARDINALITY];
        for (int i=0; i<CARDINALITY; i++)
            ret[i] = TYPES[i];
        return ret;
    }

    public Object[] vals() {
        Object[] ret = new Object[CARDINALITY];
        for (int i=0; i<CARDINALITY; i++)
            ret[i] = VALS[i];
        return ret;
    }

    Class[] refTypes() {
        return TYPES;
    }

    Object[] refVals() {
        return VALS;
    }
}
