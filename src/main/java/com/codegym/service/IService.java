package com.codegym.service;

import java.util.List;

public interface IService<T> {
    List<T> getAll();
    T save(T model);
    T getOne(Long id);
    void remove(Long id);
}
