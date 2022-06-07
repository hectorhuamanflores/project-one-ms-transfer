package pe.com.bootcamp.microservice.transfer.kafka.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Setter
@Getter
@ConfigurationProperties(prefix = "bootcoin-api")
public class BootcoinApiProperties {
  private String baseUrl;
}
