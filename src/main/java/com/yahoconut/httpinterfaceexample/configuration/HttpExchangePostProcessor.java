package com.yahoconut.httpinterfaceexample.configuration;

import com.yahoconut.httpinterfaceexample.HttpExchangeInterface;
import org.reflections.Reflections;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;


@Component
public class HttpExchangePostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        WebClient client = (WebClient) beanFactory.getBean("client");
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();

        Reflections ref = new Reflections("com.yahoconut.httpinterfaceexample");

        for (Class<?> cl : ref.getTypesAnnotatedWith(HttpExchangeInterface.class)) {
            Object bean = httpServiceProxyFactory.createClient(cl);
            beanFactory.registerSingleton(cl.getSimpleName(), bean);
        }
    }
}
