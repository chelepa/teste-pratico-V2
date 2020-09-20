package br.com.deliver.testepratico;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DeliverTestePraticoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliverTestePraticoApplication.class, args);
	}
	
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }

}
