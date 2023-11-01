package com.nova.dataservice.utils;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NovaModelMapper {

	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
