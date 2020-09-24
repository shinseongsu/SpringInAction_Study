package taco.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import taco.vo.Taco;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/login");
    }

    // 커스텀 링크를 스프링 데이터 REST 엔드포인터 추가
    @Bean
    public ResourceProcessor<PagedResources<Resource<Taco>>> tacoProcessor(EntityLinks links) {

        return new ResourceProcessor<PagedResources<Resource<Taco>>>() {
            @Override
            public PagedResources<Resource<Taco>> process(PagedResources<Resource<Taco>> resources) {
                resources.add(
                        links.linkFor(Taco.class)
                            .slash("recent")
                            .withRel("recents"));

                return resources;
            }
        };
    }

}
