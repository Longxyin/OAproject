package cn.itcast.oa.base;

import java.util.List;


public interface BaseDao<T> {
	
	/**
	 * save entity
	 * @param entity
	 */
	void save(T entity); //接收实体类型
	
	/**
	 * delete entity
	 * @param id
	 */
	void delete(Long id);
	
	/**
	 * update entity
	 * @param entity
	 */
	void Update(T entity);
	
	
	/**
	 * search by id
	 * @param id
	 * @return
	 */
	T getById(Long id);
	
	/**
	 * search by id
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Long[] ids);
	
	
	/**
	 * search all
	 * @return
	 */
	List<T> findAll();
	
	
}
