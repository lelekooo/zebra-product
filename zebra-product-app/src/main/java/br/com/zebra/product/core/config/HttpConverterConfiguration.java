package br.com.zebra.product.core.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;
import java.util.List;

@Configuration
@Import({ConverterConfiguration.class, IPFilter.class})
public class HttpConverterConfiguration extends WebMvcConfigurerAdapter {

    private final ObjectMapper objectMapper;

    @Autowired
    private IPFilter ipFilter;

    @Autowired
    public HttpConverterConfiguration(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        converters.add(jacksonMessageConverter(objectMapper));
        super.configureMessageConverters(converters);
    }

    private MappingJackson2HttpMessageConverter jacksonMessageConverter(ObjectMapper objectMapper){
        MappingJackson2HttpMessageConverter httpMessageConverter = new MappingJackson2HttpMessageConverter();
        httpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.ALL));
        httpMessageConverter.setObjectMapper(objectMapper);
        return httpMessageConverter;
    }

    @Bean
    public FilterRegistrationBean loggingFilter(){
        FilterRegistrationBean registrationBean
                = new FilterRegistrationBean();

        registrationBean.setFilter(ipFilter);
        registrationBean.addUrlPatterns("/product/*");

        return registrationBean;
    }
}
