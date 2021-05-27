package by.epam.springbootmvc.config;

import by.epam.springbootmvc.convertors.StringToEnumConvertor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan("by.epam.springbootmvc")
public class ApplicationConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**", "/images/**")
                .addResourceLocations("classpath:/static/css/", "classpath:/static/images/");
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    /**
     * Override this method to add custom {@link Converter} and/or {@link Formatter}
     * delegates to the common {@link FormattingConversionService}.
     *
     * @param registry
     * @see #mvcConversionService()
     */
    @Override
    protected void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToEnumConvertor());
    }

    /**
     * Override this method to configure asynchronous request processing options.
     *
     * @param configurer
     * @see AsyncSupportConfigurer
     */
    @Override
    protected void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setDefaultTimeout(5000);
        configurer.setTaskExecutor(mvcTaskExecutor());
    }

    @Bean(name = "applicationTaskExecutor")
    public AsyncTaskExecutor mvcTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setThreadNamePrefix("hplus-thread-");
        return threadPoolTaskExecutor;
    }
}
