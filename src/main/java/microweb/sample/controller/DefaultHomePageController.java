package microweb.sample.controller;

import com.ultraschemer.microweb.vertx.SimpleController;
import freemarker.template.Template;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;
import microweb.sample.view.FtlHelper;

public class DefaultHomePageController extends SimpleController {
    // C.1: Create a static instance of the default home page template variable, to store and cache it:
    private static Template homePageTemplate = null;

    // C.2: Initialize the template defined above, suitably:
    static {
        try {
            homePageTemplate = FtlHelper.getConfiguration().getTemplate("homePage.ftl");
        } catch(Exception e) {
            // This error should not occur - so print it in screen, so the developer can see it, while
            // creating the project
            e.printStackTrace();
        }
    }

    // C.3: Define the default controller constructor:
    public DefaultHomePageController() {
        super(500, "a37c914b-f737-4a73-a226-7bd86baac8c3");
    }

    @Override
    public void executeEvaluation(RoutingContext routingContext, HttpServerResponse httpServerResponse) throws Throwable {
        // C.4: In the controller evaluation routine, render the template:
        routingContext
                 .response()
                 .putHeader("Content-type", "text/html")
                 .end(FtlHelper.processToString(homePageTemplate, null));
    }
}