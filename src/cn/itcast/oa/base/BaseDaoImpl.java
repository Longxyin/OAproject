package cn.itcast.oa.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {

	@Resource // 注入SessionFactory, 但是这样不能注入，要放到容器里去
	private SessionFactory SessionFactory;
	private Class<T> clazz; //有问题 需要用到下面代码。 
	
	public BaseDaoImpl() {
		//使用反射技术得到T的真实类型
			//获得当前new的对象的泛型的父类类型
		ParameterizedType pt = (ParameterizedType)this.getClass().getGenericSuperclass(); 
		this.clazz = (Class<T>)pt.getActualTypeArguments()[0]; //获取第一个类型参数的真实类型
		System.out.println("clazz ---> " + clazz);	
	}
	
	

	/**
	 * 获取当前可用session对象，子类(UserDaoImpl..)会有自己的特有的方法要实现也需要session
	 * 
	 * @return
	 */
	protected Session getSession() {
		return SessionFactory.getCurrentSession();
	}

	public void save(T entity) {
		/*Session session = SessionFactory.getCurrentSession();
		session.save(entity);*/
		getSession().save(entity);

	}
	public void delete(Long id) {
		Object obj = getById(id);
		if (obj != null) {
			getSession().delete(obj);
		}
	}
	public void Update(T entity) {
		getSession().update(entity);
	}
	public T getById(Long id) {
		return (T) getSession().get(clazz, id);
	}
	public List<T> getByIds(Long[] ids) {
		return getSession().createQuery(//
				"FROM User WHERE id IN (:ids)")//
				.setParameterList("ids", ids)//
				.list();
	}
	public List<T> findAll() {
		return getSession().createQuery(//
				"FROM " + clazz.getSimpleName())//
				.list();
	}

}
