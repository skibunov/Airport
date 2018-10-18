package com.blisse.repository.common;

public interface CrudRepository<T> extends GetRepository<T> {
    public void delete(Long id);
    public void update(T t);
    public T create(T t);
}
