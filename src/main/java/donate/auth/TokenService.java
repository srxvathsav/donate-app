package donate.auth;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;


import java.time.Duration;
import java.time.Instant;

@Service
public class TokenService {

    private final StringRedisTemplate redisTemplate;

    // ✅ Constructor injection ensures redisTemplate is not null
    public TokenService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveToken(String userName, String accessToken, Instant ttl) {
        Duration ttlValue = Duration.between(Instant.now(), ttl);
        redisTemplate.opsForValue().set(userName, accessToken, ttlValue);
    }
}

