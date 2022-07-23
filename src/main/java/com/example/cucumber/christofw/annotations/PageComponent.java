package com.example.cucumber.christofw.annotations;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Lazy
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PageComponent {
}
