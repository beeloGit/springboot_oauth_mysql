package com.oauth2.oaut2demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket restFullApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.oauth2.oaut2demo.controller"))
                .paths(PathSelectors.regex(".*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Oauth2 Demo Web Api's",
                "Swagger",
                "1.0",
                "Terms of Service",
                new Contact("Hassan Naseer",
                        "localhost:8080",
                        "Hassannaseer52@gmail.com"),
                "Apache License 2.0",
                "https:www.apache.org/license.org",
                new List<VendorExtension>() {
                    @Override
                    public int size() {
                        return 0;
                    }

                    @Override
                    public boolean isEmpty() {
                        return false;
                    }

                    @Override
                    public boolean contains(Object o) {
                        return false;
                    }

                    @Override
                    public Iterator<VendorExtension> iterator() {
                        return null;
                    }

                    @Override
                    public Object[] toArray() {
                        return new Object[0];
                    }

                    @Override
                    public <T> T[] toArray(T[] a) {
                        return null;
                    }

                    @Override
                    public boolean add(VendorExtension vendorExtension) {
                        return false;
                    }

                    @Override
                    public boolean remove(Object o) {
                        return false;
                    }

                    @Override
                    public boolean containsAll(Collection<?> c) {
                        return false;
                    }

                    @Override
                    public boolean addAll(Collection<? extends VendorExtension> c) {
                        return false;
                    }

                    @Override
                    public boolean addAll(int index, Collection<? extends VendorExtension> c) {
                        return false;
                    }

                    @Override
                    public boolean removeAll(Collection<?> c) {
                        return false;
                    }

                    @Override
                    public boolean retainAll(Collection<?> c) {
                        return false;
                    }

                    @Override
                    public void clear() {

                    }

                    @Override
                    public VendorExtension get(int index) {
                        return null;
                    }

                    @Override
                    public VendorExtension set(int index, VendorExtension element) {
                        return null;
                    }

                    @Override
                    public void add(int index, VendorExtension element) {

                    }

                    @Override
                    public VendorExtension remove(int index) {
                        return null;
                    }

                    @Override
                    public int indexOf(Object o) {
                        return 0;
                    }

                    @Override
                    public int lastIndexOf(Object o) {
                        return 0;
                    }

                    @Override
                    public ListIterator<VendorExtension> listIterator() {
                        return null;
                    }

                    @Override
                    public ListIterator<VendorExtension> listIterator(int index) {
                        return null;
                    }

                    @Override
                    public List<VendorExtension> subList(int fromIndex, int toIndex) {
                        return null;
                    }
                });
        return apiInfo;
    }
}

