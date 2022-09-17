package br.edu.unicv.unicvfoods.domain.model;

public interface GenericEntity<T> {

    void update(T entity);

    T createNewInstance();

}
