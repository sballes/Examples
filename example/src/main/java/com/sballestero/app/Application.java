package com.sballestero.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages={"com.sballestero.rest"})
@EnableJpaRepositories(basePackages={"com.sballestero.repository"})
/**
 * @SpringBootApplication es igual que poner:
 * 
 * @Configuration -> Marca la clase como fuente de definición de Beans
 * @EnableAutoConfiguration -> Indica a Spring Boot que empiece a añadir beans basámdose en configuraciones de classpath, otros beans y propiedades
 * 
 * 
 * @EnableWebMvc -> No es necesario si se usa Spring Boot y existe spring-webmvc en el classpart. De esta forma la aplicación
 * 					se marca automaticamente como una aplicación web y se activan comportamientos clave como el seteo de un DispatcherServlet
 * 
 * @ComponentScan -> Indica a Spring que scanee el paquete actual para buscar otros componentes, configuraciones y servicios
 */
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
