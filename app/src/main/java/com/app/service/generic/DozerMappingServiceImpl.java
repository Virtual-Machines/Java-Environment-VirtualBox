package com.app.service.generic;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

/**
 * Implementation of service that obtains mappings using Dozer
 * @author David García Prados
 *
 */
@Service
public class DozerMappingServiceImpl implements DozerMappingService {

	private final Mapper dozerMapper = DozerBeanMapperBuilder.buildDefault();

	@Override
	public <T, U> U mapOne(T sourceObject, Class<U> destinationClass) {
		return dozerMapper.map(sourceObject, destinationClass);
	}

	@Override
	public <T, U> List<U> mapList(List<T> sourceObjectList, Class<U> destinationClass) {
		List<U> result = new LinkedList<>();
		for (T elemSource : sourceObjectList) {
			result.add(dozerMapper.map(elemSource, destinationClass));
		}
		return result;
	}
}
