/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asu.emit.algorithm.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author martijn
 */
public class Map2D<K1, K2, V> {

    private int initialCapacity = 4192 *4;
    private final Map<K1, Map<K2, V>> map = new HashMap<K1, Map<K2, V>>(initialCapacity);

    public void setInitialCapacity(int initialCapacity) {
        this.initialCapacity = initialCapacity;
    }

    public void clearBoth() {
        map.clear();
    }

    public void clearLevel1() {
        for (Map<K2, V> m : map.values()) {
            m.clear();
        }
    }

    public boolean containsKey(K1 k1, K2 k2) {
        Map<K2, V> l1 = map.get(k1);
        if (l1 == null) {
            return false;
        }
        return l1.containsKey(k2);
    }

    public V remove(K1 k1, K2 k2) {
        Map<K2, V> l1 = map.get(k1);
        if (l1 == null) {
            return null;
        }
        return l1.remove(k2);
    }

    public V get(K1 k1, K2 k2) {
        Map<K2, V> l1 = map.get(k1);
        if (l1 == null) {
            return null;
        }
        return l1.get(k2);
    }

    public void put(K1 k1, K2 k2, V value) {
        Map<K2, V> l1 = map.get(k1);
        if (l1 == null) {
            l1 = new HashMap<K2, V>(initialCapacity);
            map.put(k1, l1);
        }
        l1.put(k2, value);
    }

    public void putAll(Map2D<K1, K2, V> m) {
        for (Map.Entry<K1, Map<K2, V>> m1 : m.map.entrySet()) {
            Map<K2, V> l1 = map.get(m1.getKey());
            if (l1 == null) {
                l1 = new HashMap<K2, V>(initialCapacity);
                map.put(m1.getKey(), l1);
            }
            l1.putAll(m1.getValue());
        }
    }

    public Set<K1> level0KeySet() {
        return map.keySet();
    }

    public Set<K2> level1KeySet(K1 k1) {
        Map<K2, V> l1 = map.get(k1);
        if (l1 == null) {
            return Collections.emptySet();
        }
        return l1.keySet();
    }

}
