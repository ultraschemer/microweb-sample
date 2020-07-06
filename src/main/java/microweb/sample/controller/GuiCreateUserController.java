package microweb.sample.controller;

import com.ultraschemer.microweb.vertx.SimpleController;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

public class GuiCreateUserController extends SimpleController {
    public GuiCreateUserController() {
        super(500, "63ccb2ee-3c99-4b20-91d4-bb521f4945dd");
    }

    @Override
    public void executeEvaluation(RoutingContext routingContext, HttpServerResponse httpServerResponse) throws Throwable {
        throw new Exception("Unimplemented");
    }
}
