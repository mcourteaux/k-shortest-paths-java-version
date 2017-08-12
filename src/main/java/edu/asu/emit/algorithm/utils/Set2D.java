package edu.asu.emit.algorithm.utils;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author martijn
 */
public class Set2D<T1, T2> {

    private final int initialCap = 1024;
    private final Map<T1, Set<T2>> map = new HashMap<T1, Set<T2>>(initialCap);

    public Set2D() {
    }

    public void clear() {
        map.clear();
    }

    public boolean add(T1 t1, T2 t2) {
        Set<T2> l1 = map.get(t1);
        if (l1 == null) {
            l1 = new HashSet<T2>(initialCap);
            map.put(t1, l1);
        }
        return l1.add(t2);
    }

    public boolean contains(T1 t1, T2 t2) {
        Set<T2> l1 = map.get(t1);
        if (l1 == null) {
            return false;
        }
        return l1.contains(t2);
    }

    public boolean remove(T1 t1, T2 t2) {
        Set<T2> l1 = map.get(t1);
        if (l1 == null) {
            return false;
        }
        return l1.remove(t2);
    }

}
