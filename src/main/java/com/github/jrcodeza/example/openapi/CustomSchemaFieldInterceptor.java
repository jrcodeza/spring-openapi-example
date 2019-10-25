package com.github.jrcodeza.example.openapi;

import java.lang.reflect.Field;

import com.github.jrcodeza.example.annotations.ReadOnly;
import com.github.jrcodeza.example.annotations.VisibleInReport;
import com.github.jrcodeza.schema.generator.interceptors.SchemaFieldInterceptor;

import io.swagger.v3.oas.models.media.Schema;

public class CustomSchemaFieldInterceptor implements SchemaFieldInterceptor {

	@Override
	public void intercept(Class<?> clazz, Field field, Schema<?> transformedFieldSchema) {
		VisibleInReport visibleInReport = field.getAnnotation(VisibleInReport.class);
		if (visibleInReport != null) {
			transformedFieldSchema.setDescription("This field will be visible in report.");
		}

		ReadOnly readOnly = field.getAnnotation(ReadOnly.class);
		if (readOnly != null) {
			transformedFieldSchema.setReadOnly(true);
			transformedFieldSchema.setDescription("This field is read only.");
		}
	}

}
