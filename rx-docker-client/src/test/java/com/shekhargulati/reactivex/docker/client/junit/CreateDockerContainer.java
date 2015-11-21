package com.shekhargulati.reactivex.docker.client.junit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface CreateDockerContainer {

    /**
     * Name for containers
     *
     * @return container names
     */
    public String[] containers();

}
