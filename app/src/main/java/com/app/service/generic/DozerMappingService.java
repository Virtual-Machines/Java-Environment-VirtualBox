package com.app.service.generic;

import java.util.List;

/**
 * Service that obtains mappings using Dozer
 * 
 * @author David García Prados
 *
 */
public interface DozerMappingService {
	/**
	 * Map One sourceObject to destinationObject
	 * 
	 * @param <T>
	 * @param <U>
	 * @param sourceObject
	 * @param destinationClass
	 * @return U
	 */
	public <T, U> U mapOne(T sourceObject, Class<U> destinationClass);

	/**
	 * Map sourceObjectList to destinationObjectList
	 * 
	 * @param <T>
	 * @param <U>
	 * @param sourceObjectCollection
	 * @param destinationClass
	 * @return List<U>
	 */
	public <T, U> List<U> mapList(List<T> sourceObjectList, Class<U> destinationClass);

}
