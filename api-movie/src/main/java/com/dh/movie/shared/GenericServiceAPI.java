package com.dh.movie.shared;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

public interface GenericServiceAPI<T, ID extends Serializable> {

    T save(T entity);

    void delete(ID id);

    T getOne(ID id);

    List<T> getAll();

    JpaRepository<T, ID> getRepository();
}
