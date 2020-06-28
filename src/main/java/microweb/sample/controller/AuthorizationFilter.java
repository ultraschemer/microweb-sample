package microweb.sample.controller;

public class AuthorizationFilter extends com.ultraschemer.microweb.controller.AuthorizationFilter {
    public AuthorizationFilter() {
        super();
        this.addUnfilteredPath("/");
        this.addUnfilteredPath("/v0");
    }
}
