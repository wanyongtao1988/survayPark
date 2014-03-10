package com.wyt.survayPark.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.wyt.survayPark.dao.BaseDao;
import com.wyt.survayPark.service.BaseService;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

	
	private BaseDao dao;
	
	public BaseDao getDao() {
		return dao;
	}

	@Resource
	public void setDao(BaseDao dao) {
		this.dao = dao;
	}

	public void saveEntity(T t) {
		dao.saveEntity(t);
	}

	public void updateEntity(T t) {
		dao.updateEntity(t);
	}

	public void saveOrUpdateEntity(T t) {
		dao.saveOrUpdateEntity(t);
	}

	public void deleteEntity(T t) {
		dao.deleteEntity(t);
	}

	public void batchEntityByHQL(String hql, List<String> params) {
		dao.batchEntityByHQL(hql, params);
	}

	public T getEntity(String id) {
		return (T) dao.getEntity(id);
	}

	public T loadEntity(String id) {
		return (T) dao.loadEntity(id);
	}

	public List<T> findEntityByHQL(String hql, List<String> params) {
		return dao.findEntityByHQL(hql, params);
	}

	
}
