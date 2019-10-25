package com.github.jrcodeza.example.openapi;

import java.lang.reflect.Method;

import com.github.jrcodeza.example.annotations.AsyncOperation;
import com.github.jrcodeza.schema.generator.interceptors.OperationInterceptor;

import io.swagger.v3.oas.models.Operation;

public class CustomSchemaOperationInterceptor implements OperationInterceptor {

	@Override
	public void intercept(Method method, Operation transformedOperation) {
		if (method.getAnnotation(AsyncOperation.class) != null) {
			transformedOperation.setDescription("This operation is asynchronous.");
		}
	}

}
