package microweb.sample.controller;

import com.ultraschemer.microweb.vertx.SimpleController;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

public class UserReadManagementController extends SimpleController {
    public UserReadManagementController() {
        super(500, "2a6fedd0-b7c2-44f3-9aa1-f3281c574f56");
    }

    @Override
    public void executeEvaluation(RoutingContext routingContext, HttpServerResponse httpServerResponse) throws Throwable {
        throw new Exception("Unimplemented.");
    }
}
