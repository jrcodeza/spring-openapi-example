package com.github.jrcodeza.example.openapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.github.jrcodeza.schema.generator.interceptors.examples.OpenApiExampleResolver;

public class CustomExampleResolver implements OpenApiExampleResolver {

	@Override
	public String resolveExample(String exampleKey) {
		try {
			System.out.println("Getting example for " + exampleKey);
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(exampleKey + ".json");
			BufferedReader buf = new BufferedReader(new InputStreamReader(inputStream));
			String line = buf.readLine();
			StringBuilder sb = new StringBuilder();
			while (line != null) {
				sb.append(line).append("\n");
				line = buf.readLine();
			}
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return "";
	}

}
