/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.npuzzle.logic.astar;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections.buffer.PriorityBuffer;

/**
 *
 * @author thiago
 */
public class BinaryList<E extends Comparable> implements List<E> {

    private PriorityBuffer list = new PriorityBuffer();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean add(E e) {
        boolean rtr = list.add(e);
        return rtr;
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addAll(Collection<? extends E> clctn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addAll(int i, Collection<? extends E> clctn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean removeAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean retainAll(Collection<?> clctn) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public E get(int i) {
        if(i==0){
            /*Object[] arr = new Object[list.size()];
            arr = list.toArray(arr);
            return (E) arr[0];*/
            return (E) list.iterator().next();
        }
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public E set(int i, E e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(int i, E e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public E remove(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ListIterator<E> listIterator(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<E> subList(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
