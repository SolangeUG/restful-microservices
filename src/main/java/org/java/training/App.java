package org.java.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;
import java.util.Properties;

/**
 * Spring Boot application to manage a company's employees
 * via Java based RESTful microservices.
 *
 * @author Solange U. Gasengayire
 */
@SpringBootApplication
public class App {

    // Get HOST and PORT from environment or set default
    private static final Optional<String> host;
    private static final Optional<String> port;
    private static final Properties appProps = new Properties();

    static {
        host = Optional.ofNullable(System.getenv("HOSTNAME"));
        port = Optional.ofNullable(System.getenv("PORT"));
    }

    public static void main( String[] args ) {

        // set application properties
        appProps.setProperty("server.address", host.orElse("localhost"));
        appProps.setProperty("server.port", port.orElse("8080"));

        SpringApplication app = new SpringApplication(App.class);
        app.setDefaultProperties(appProps);
        app.run(args);
    }
}
