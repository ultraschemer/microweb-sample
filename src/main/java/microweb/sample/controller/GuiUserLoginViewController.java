package microweb.sample.controller;

import com.ultraschemer.microweb.vertx.SimpleController;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

public class GuiUserLoginViewController extends SimpleController {
    public GuiUserLoginViewController() {
        super(500, "85c2c7d9-eab9-4b6e-9ebd-271966722124");
    }

    @Override
    public void executeEvaluation(RoutingContext routingContext, HttpServerResponse httpServerResponse) throws Throwable {
        throw new Exception("Unimplemented");
    }
}
