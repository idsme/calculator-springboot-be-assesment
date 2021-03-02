package nl.thk.api.config;

import nl.thk.api.projections.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestConfig implements RepositoryRestConfigurer {

// https://www.baeldung.com/spring-data-rest-customize-http-endpoints point 5
//    Sometimes we need a finer-grained level of configuration to expose or restrict access to our HTTP methods. For example, POST on collection resources, as well as PUT and PATCH on item resources, all use the same save method.
//    Starting from Spring Data REST 3.1, and available with Spring Boot 2.1, we can change the exposure of a specific HTTP method through the ExposureConfiguration class. This particular configuration class exposes a lambda-based API to define both global and type-based rules.
//    For example, we can use ExposureConfiguration to restrict PATCH requests against the UserRepository:

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration repositoryRestConfiguration, CorsRegistry cors) {
        repositoryRestConfiguration.getProjectionConfiguration()
                .addProjection(PCalculationFEOverview.class);
    }
}
