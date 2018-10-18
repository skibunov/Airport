package com.blisse.repository.common;

import java.util.List;

public interface GetRepository<T> {
    List<T> getAll();

    T getById(Long id);
}
