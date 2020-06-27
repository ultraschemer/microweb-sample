package microweb.sample.controller;

import com.ultraschemer.microweb.vertx.SimpleController;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

public class GuiUserLoginProcessController extends SimpleController {
    public GuiUserLoginProcessController() {
        super(500, "7f65217b-a95e-4b0c-8161-5ab116b49dea");
    }

    @Override
    public void executeEvaluation(RoutingContext routingContext, HttpServerResponse httpServerResponse) throws Throwable {
        throw new Exception("Unimplemented");
    }
}