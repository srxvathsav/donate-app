package donate.auth;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class LoginController {

    private TokenService tokenService;
    public LoginController(TokenService tokenService){
        this.tokenService = tokenService;
    }

    @GetMapping("/login")
    public String login(Principal principal) {
        return "redirect:/oauth2/authorization/google";
    }

    @GetMapping("/user")
    public String user (@AuthenticationPrincipal OAuth2User principal, @RegisteredOAuth2AuthorizedClient("google")  OAuth2AuthorizedClient authClient){
        String accessToken = authClient.getAccessToken().getTokenValue();

        tokenService.saveToken(principal.getName(),accessToken, authClient.getAccessToken().getExpiresAt());
        return "Token for user "+principal.getName() + " is "+ accessToken + ", expires in " + authClient.getAccessToken().getExpiresAt();
    }

}
