package br.com.zebra.product.core.config;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties
@ComponentScan(basePackages = {"br.com.zebra"})
@EnableAutoConfiguration(exclude = {FreeMarkerAutoConfiguration.class})
public class ModuleConfiguration {
}
