package microweb.sample.controller;

import com.ultraschemer.microweb.vertx.SimpleController;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

public class ImageCreateController extends SimpleController {
    public ImageCreateController() {
        super(500, "cb989df8-acf1-46a5-bf9b-75879ebb4abe");
    }

    @Override
    public void executeEvaluation(RoutingContext routingContext, HttpServerResponse httpServerResponse) throws Throwable {
        throw new Exception("Unimplemented");
    }
}
