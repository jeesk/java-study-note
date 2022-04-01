package com.shanjiancaofu.annotion.typeparameters;

import java.lang.reflect.ParameterizedType;


public class Demo {
	public static void main(String[] args) {

		UserDao userDao = new UserDao();
		Class<String> actualType = userDao.getActualType();
		System.out.println(actualType.getName());
	}


} class AbstractDao<T> {
	public Class<T> getActualType() {
		ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
		return (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}
}

class UserDao extends AbstractDao<String> {

}
