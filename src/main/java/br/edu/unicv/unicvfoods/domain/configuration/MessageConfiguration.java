package br.edu.unicv.unicvfoods.domain.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Configuration
@ConfigurationProperties("unicvfoods")
@PropertySource("classpath:/messages.properties")
@Validated
@Getter
@Setter
public class MessageConfiguration {

    @NotBlank
    private String entityNotFoundMessage;

    @NotBlank
    private String departmentNotFoundMessage;

    @NotBlank
    private String brandNotFoundMessage;

    @NotBlank
    private String measurementUnitNotFoundMessage;

    @NotBlank
    private String categoryNotFoundMessage;

}