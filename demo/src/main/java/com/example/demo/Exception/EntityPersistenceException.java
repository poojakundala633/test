package com.example.demo.Exception;

import jakarta.persistence.PersistenceException;

public class EntityPersistenceException extends PersistenceException {
    public EntityPersistenceException(String message){
            super(message);
        }
    }
