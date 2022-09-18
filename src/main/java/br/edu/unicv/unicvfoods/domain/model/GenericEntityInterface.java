package br.edu.unicv.unicvfoods.domain.model;

public interface GenericEntityInterface<T> {

    void update(T entity);

    long getId();

    T createNewInstance();

}
