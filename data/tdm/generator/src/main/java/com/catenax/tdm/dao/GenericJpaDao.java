package com.catenax.tdm.dao;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Transactional 
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenericJpaDao<T extends Serializable> extends AbstractJpaDao<T> implements IGenericDao<T> {
    //
}