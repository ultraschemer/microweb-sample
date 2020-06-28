package microweb.sample;

import com.ultraschemer.microweb.controller.LoginController;
import com.ultraschemer.microweb.controller.LogoffController;
import com.ultraschemer.microweb.domain.RoleManagement;
import com.ultraschemer.microweb.domain.UserManagement;
import com.ultraschemer.microweb.persistence.EntityUtil;
import com.ultraschemer.microweb.vertx.WebAppVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.handler.StaticHandler;
import microweb.sample.controller.AuthorizationFilter;
import microweb.sample.controller.DefaultHomePageController;
import microweb.sample.controller.GuiUserLoginProcessController;
import microweb.sample.controller.GuiUserLoginViewController;

// 1. Specialize WebAppVerticle:
public class App extends WebAppVerticle {
    static {
        // 2. Initialize default entity util here:
        EntityUtil.initialize();
    }

    @Override
    public void initialization() throws Exception {
        // 3. Verify the default user and the default role:
        UserManagement.initializeRoot();

        // 4. Initialize additional roles (if not using KeyCloak):
        RoleManagement.initializeDefault();

        // This is added to serve static files to project - All static files are
        // to be stored at src/main/java/resources/webroot directory, which will be
        // packed with the application Jar file
        getRouter().route("/static/*").handler(StaticHandler.create());

        // 5. Register authorization filter:
        registerFilter(new AuthorizationFilter());

        // 6. Register controllers:
        registerController(HttpMethod.POST, "/v0/login", new LoginController());
        registerController(HttpMethod.GET, "/v0/logoff", new LogoffController());

        // Controllers used to manage User Login:
        // L.1: Login default presentation:
        registerController(HttpMethod.GET, "/v0/gui-user-login", new GuiUserLoginViewController());
        // L.2: Login submission handling:
        registerController(HttpMethod.POST, "/v0/gui-user-login", new GuiUserLoginProcessController());

        // L.3:  Default system home page handling:
        registerController(HttpMethod.GET, "/v0", new DefaultHomePageController());
        registerController(HttpMethod.GET, "/", new DefaultHomePageController());
    }

    public static void main(String[] args) {
        // 7. Create the Application Vertx instance:
        Vertx vertx = Vertx.vertx();

        // 8. Deploy the WebAppVerticle:
        vertx.deployVerticle(new App());
    }
}
