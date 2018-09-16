package com.project.service;

import java.util.List;
import java.util.Optional;

public interface CRUD<T> {

    List<T> findAll();

    T findById(Integer id);

    void create(T obj);

    void update(T obj);

    void delete(Integer id);
}
