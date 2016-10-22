package spittr.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.FileSystemResource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.
        InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import javax.annotation.Resources;
import java.io.IOException;

/**
 * Created by root on 12.10.16.
 */

@Configuration
@EnableWebMvc
@ComponentScan("spittr.web")
public class WebConfig
        extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

    /**
     * Standart multipart resolver
     */
//    @Bean
//    public MultipartResolver multipartResolver(){
//        return new StandardServletMultipartResolver();
//    }

    @Bean
    public MultipartResolver multipartResolver(){
//        try {
//            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//            multipartResolver.setUploadTempDir(new FileSystemResource("/tmp/spittr/uploads"));
//            multipartResolver.setMaxUploadSize(2097152);
//            multipartResolver.setMaxInMemorySize(0);
//            return multipartResolver;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return new CommonsMultipartResolver();
        return  new StandardServletMultipartResolver();
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("ValidationMessages");
        messageSource.addBasenames("Messages");
        return messageSource;
    }

    /**
     * Thymeleaf
     */
    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }
    @Bean
    public SpringTemplateEngine templateEngine(TemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        templateEngine.addDialect(new SpringSecurityDialect());
        return templateEngine;
    }
    @Bean
    public TemplateResolver templateResolver() {
        TemplateResolver templateResolver =
                new ServletContextTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        return templateResolver;
    }


    /**
     * This for Apache tiles And JSP
     *
     */

//    @Bean
//    public TilesConfigurer tilesConfigurer(){
//        TilesConfigurer tilesConfigurer = new TilesConfigurer();
//        tilesConfigurer.setDefinitions("/WEB-INF/layout/tiles.xml");
//        tilesConfigurer.setCheckRefresh(true);
//        return tilesConfigurer;
//    }
//
//    @Bean
//    public ViewResolver viewResolver(){
//        return new TilesViewResolver();
//    }
    


    @Bean
    public LocalValidatorFactoryBean validatorFactory() {
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        factoryBean.setValidationMessageSource(messageSource());
        return factoryBean;
    }

    @Override
    public Validator getValidator() {
        return validatorFactory();
    }

//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver resolver =
//                new InternalResourceViewResolver();
//        resolver.setViewClass(JstlView.class);
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        resolver.setExposeContextBeansAsAttributes(true);
//        return resolver;
//    }
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}