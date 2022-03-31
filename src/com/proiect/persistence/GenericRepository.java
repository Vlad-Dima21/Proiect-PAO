package com.proiect.persistence;

import java.util.List;

public interface GenericRepository<T> {
    public void add(T entity);

    public T get(int id);

    public void update(T entity);

    public void delete(T entity);

    public int getSize();

    public List<T> getAll();
}
