package Music;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {
    @Bean
    MusicServiceTest musicServiceTest() {
        return new MusicServiceTest();
    }
}
