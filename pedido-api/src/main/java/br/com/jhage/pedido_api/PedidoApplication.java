package br.com.jhage.pedido_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PedidoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedidoApplication.class);
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurerAdapter() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/produto").allowedOrigins("http://localhost:8080");
//			}
//		};
//	}

}
