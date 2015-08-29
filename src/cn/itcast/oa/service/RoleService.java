package cn.itcast.oa.service;

import java.util.List;

import cn.itcast.oa.domain.Role;

public interface RoleService {
	//find all
	List<Role> findAll();

	void delete(Long id);

}
