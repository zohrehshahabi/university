package com.hib.repository;

import com.hib.model.Person;

public interface PersonReps<E> {
    public E createPerson(E p);
}
