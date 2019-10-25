# spring-openapi-example
Example for spring-openapi project usage. It contains simple REST API resources with model
and basic inheritance (using Jackson annotations). There are also generation interceptors
**com.github.jrcodeza.example.openapi.CustomSchemaFieldInterceptor** and 
**com.github.jrcodeza.example.openapi.CustomSchemaOperationInterceptor**. 
In this example you can see also example generation also using file resolver
**com.github.jrcodeza.example.openapi.CustomExampleResolver**.

This example demonstrates both ways of generation: code to spec and also spec to code.
For this purpose there are 2 plugins defines in pom.xml:

## Code to spec
```xml
<plugin>
    <groupId>com.github.jrcodeza</groupId>
    <artifactId>spring-openapi-schema-generator-plugin</artifactId>
    <dependencies>
        <dependency>
            <groupId>com.github.jrcodeza</groupId>
            <artifactId>spring-openapi-example</artifactId>
            <version>${project.version}</version>
        </dependency>
    </dependencies>
    <executions>
        <execution>
            <goals>
                <goal>generateOpenApi</goal>
            </goals>
            <phase>install</phase>
        </execution>
    </executions>
    <configuration>
        <title>Spring OpenAPI Example</title>
        <description>Demonstrational OpenAPI spec generated using Spring OpenAPI generator example project</description>
        <version>1.0.0-SNAPSHOT</version>
        <modelPackages>
            <modelPackage>com.github.jrcodeza.example.model.*</modelPackage>
        </modelPackages>
        <controllerBasePackages>
            <controllerBasePackage>com.github.jrcodeza.example.controller.*</controllerBasePackage>
        </controllerBasePackages>
        <outputDirectory>target/openapi-spec</outputDirectory>
        <schemaFieldInterceptors>
            <schemaFieldInterceptor>com.github.jrcodeza.example.openapi.CustomSchemaFieldInterceptor</schemaFieldInterceptor>
        </schemaFieldInterceptors>
        <operationInterceptors>
            <operationInterceptor>com.github.jrcodeza.example.openapi.CustomSchemaOperationInterceptor</operationInterceptor>
        </operationInterceptors>
        <generateExamples>true</generateExamples>
        <openApiExamplesResolver>com.github.jrcodeza.example.openapi.CustomExampleResolver</openApiExamplesResolver>
    </configuration>
</plugin>
```
I tried to show here also interceptors and example resolvers input

## Spec to code
```xml
<plugin>
    <groupId>com.github.jrcodeza</groupId>
    <artifactId>spring-openapi-client-generator-plugin</artifactId>
    <executions>
        <execution>
            <goals>
                <goal>generateClientFromOpenApi</goal>
            </goals>
            <phase>generate-sources</phase>
        </execution>
    </executions>
    <configuration>
        <schemaPath>src/main/resources/spec-for-client-generation/openapi.json</schemaPath>
        <outputPath>target/generated-sources</outputPath>
        <outputPackage>com.github.jrcodeza.client</outputPackage>
        <generateDiscriminatorProperty>false</generateDiscriminatorProperty>
        <generateResourceInterface>true</generateResourceInterface>
    </configuration>
</plugin>
```
