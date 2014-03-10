package com.wyt.survayPark.dao;

import java.util.List;

public interface BaseDao<T> {

	public void saveEntity(T t);
	public void updateEntity(T t);
	public void saveOrUpdateEntity(T t);
	public void deleteEntity(T t);
	public void batchEntityByHQL(String hql,List<String> params);
	
	public T getEntity(String id);
	public T loadEntity(String id);
	public List<T> findEntityByHQL(String hql,List<String> params);
	
	
}
