package com.globant.restservice.cqrs.repositories;

public interface IRepository<T> {

    public T find(int id);

    public T save(T entity);
}
