package com.targetindia.dao;

import org.springframework.stereotype.Component;

@Component
public class DummyEmployeeDao implements EmployeeDao {

	@Override
	public long count() throws DaoException {
		return 9999;
	}

}
