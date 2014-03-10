package com.wyt.survayPark.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.wyt.survayPark.dao.BaseDao;

@Transactional()
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	@Autowired @Qualifier(value="sessionFactory")
	private SessionFactory sf;

	private Class<T> clazz;
	
	public BaseDaoImpl(){
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}
	
	public void saveEntity(T t) {
		sf.getCurrentSession().save(t);
	}

	public void updateEntity(T t) {
		sf.getCurrentSession().update(t);
	}

	public void saveOrUpdateEntity(T t) {
		sf.getCurrentSession().saveOrUpdate(t);
	}

	public void deleteEntity(T t) {
		sf.getCurrentSession().delete(t);
	}

	public void batchEntityByHQL(String hql, List<String> params) {
		
		Query query = sf.getCurrentSession().createQuery(hql);
		for(int i=0;i<params.size();i++){
			query.setParameter(i, params.get(i));
		}
		query.executeUpdate();
	}

	public T getEntity(String id) {
		return (T) sf.getCurrentSession().get(clazz, id);
	}

	public T loadEntity(String id) {
		return (T) sf.getCurrentSession().load(clazz, id);
	}

	public List<T> findEntityByHQL(String hql, List<String> params) {
		Query query = sf.getCurrentSession().createQuery(hql);
		for(int i=0;i<params.size();i++){
			query.setParameter(i, params.get(i));
		}
		return query.list();
	}

}
