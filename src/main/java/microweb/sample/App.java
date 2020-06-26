package microweb.sample;

import com.ultraschemer.microweb.controller.AuthorizationFilter;
import com.ultraschemer.microweb.controller.LoginController;
import com.ultraschemer.microweb.controller.LogoffController;
import com.ultraschemer.microweb.domain.RoleManagement;
import com.ultraschemer.microweb.domain.UserManagement;
import com.ultraschemer.microweb.persistence.EntityUtil;
import com.ultraschemer.microweb.vertx.WebAppVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;

public class App extends WebAppVerticle {
    static {
        // 1. Initialize default entity util here:
        EntityUtil.initialize();
    }

    @Override
    public void initialization() throws Exception {
        // 2. Verify the default user and the default role:
        UserManagement.initializeRoot();

        // 3. Initialize additional roles (if not using KeyCloak):
        RoleManagement.initializeDefault();

        // 4. Registra os filtros de inicialização:
        registerFilter(new AuthorizationFilter());

        // 5. Register the controllers:
        registerController(HttpMethod.POST, "/v0/login", new LoginController());
        registerController(HttpMethod.GET, "/v0/logoff", new LogoffController());
    }

    public static void main(String[] args) {
        // 6. Create an Application Vertx instance. Vert.x is, to Microweb, the entire application component container:
        Vertx vertx = Vertx.vertx();

        // 7. Deploy the WebAppVerticle:
        vertx.deployVerticle(new App());
    }
}
