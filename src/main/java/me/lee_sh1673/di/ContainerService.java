package me.lee_sh1673.di;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ContainerService {

	public static <T> T getObject(Class<T> classType) {
		T newInstance = createNewInstance(classType);

		Arrays.stream(classType.getDeclaredFields()).forEach(field ->  {
			Inject annotation = field.getAnnotation(Inject.class);

			// If current field has annotation which name is `@Inject`.
			if (annotation != null) {
				Object fieldInstance = createNewInstance(field.getType());
				field.setAccessible(true);
				try {
					field.set(newInstance, fieldInstance);
				} catch (IllegalAccessException e) {
					throw new RuntimeException(e);
				}
			}
		});
		return newInstance;
	}

	private static <T> T createNewInstance(Class<T> classType) {
		try {
			return classType.getConstructor(null).newInstance();
		} catch (InstantiationException | IllegalAccessException |
				 InvocationTargetException | NoSuchMethodException e) {
			throw new RuntimeException(e);
		}
	}
}
