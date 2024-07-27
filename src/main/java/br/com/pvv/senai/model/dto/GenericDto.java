package br.com.pvv.senai.model.dto;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import br.com.pvv.senai.model.IEntity;

public abstract class GenericDto<T extends IEntity> implements IEntity {
	
	protected abstract Class<T> getType();
	
	public T makeEntity() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, SecurityException {
		T entity = (T) getType().getConstructors()[0].newInstance();
		Field[] fields = this.getClass().getFields();
		
		for (Field field : fields) {
			boolean access = field.canAccess(entity);
			field.setAccessible(true);
			field.set(entity, field.get(this));
			field.setAccessible(access);
		}
		
		return entity;
	}

}
