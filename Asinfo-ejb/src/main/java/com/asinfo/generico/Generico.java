/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asinfo.generico;

import java.util.Iterator;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import lombok.Getter;

/**
 *
 * @author Marco
 */
public class Generico<T> {

    @PersistenceContext(unitName = "ASINFO_UP")

    @Getter
    private EntityManager entityManager;

    public void create(T entity) {
        try {
            auxConstraintValidationsDetected(entity);
            getEntityManager().persist(entity);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void edit(T entity) {
        if (!constraintValidationsDetected(entity)) {
            getEntityManager().merge(entity);

        }
    }

    private boolean constraintValidationsDetected(T entity) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(entity);
        if (constraintViolations.size() > 0) {
            Iterator<ConstraintViolation<T>> iterator = constraintViolations.iterator();
            while (iterator.hasNext()) {
                ConstraintViolation<T> cv = iterator.next();
                System.err.println(cv.getMessage());
            }
            return true;
        } else {
            return false;
        }
    }

    private void auxConstraintValidationsDetected(T entity) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(entity);
        if (constraintViolations.size() > 0) {
            Iterator<ConstraintViolation<T>> iterator = constraintViolations.iterator();
            while (iterator.hasNext()) {
                ConstraintViolation<T> cv = iterator.next();
                System.err.println(cv.getMessage());
            }

        }
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(T entity, Object id) {
        return (T) getEntityManager().find(entity.getClass(), id);
    }

}
