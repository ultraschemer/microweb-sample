package microweb.sample.controller;

import com.ultraschemer.microweb.vertx.SimpleController;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

public class GuiAssignRoleController extends SimpleController {
    public GuiAssignRoleController() {
        super(500, "0d75c820-7650-41cd-be63-01c91bf2e4ea");
    }

    @Override
    public void executeEvaluation(RoutingContext routingContext, HttpServerResponse httpServerResponse) throws Throwable {
        throw new Exception("Unimplemented");
    }
}
