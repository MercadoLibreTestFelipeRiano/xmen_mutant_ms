package com.xmen.xmen_mutant_ms.generator;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.lang.reflect.Type;

public class ObjectGenerator {

    public static <T> T createObject(Class<T> objectClass, Type... types) {
        PodamFactory factory = new PodamFactoryImpl();

        return factory.manufacturePojo(objectClass, types);
    }
}
