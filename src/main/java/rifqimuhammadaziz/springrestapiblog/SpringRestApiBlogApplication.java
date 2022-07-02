package rifqimuhammadaziz.springrestapiblog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import rifqimuhammadaziz.springrestapiblog.utils.AuditorAwareImpl;

@SpringBootApplication
@EnableWebMvc
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class SpringRestApiBlogApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareImpl();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringRestApiBlogApplication.class, args);
    }



}
