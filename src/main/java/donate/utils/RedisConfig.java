package donate.utils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    @Bean
    public StringRedisTemplate getRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisSerializer serializer = new StringRedisSerializer();
        StringRedisTemplate template = new StringRedisTemplate(redisConnectionFactory);
        template.setKeySerializer(serializer);
        template.setValueSerializer(serializer);
        return template;
    }
}

