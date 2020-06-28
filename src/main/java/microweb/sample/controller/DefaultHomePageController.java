package microweb.sample.controller;

import com.ultraschemer.microweb.vertx.SimpleController;
import freemarker.template.Template;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;
import microweb.sample.view.FtlHelper;

public class DefaultHomePageController extends SimpleController {
    private static Template homePageTemplate = null;

    static {
        try {
            homePageTemplate = FtlHelper.getConfiguration().getTemplate("homePage.ftl");
        } catch(Exception e) {
            // This error should not occur - so print it in screen, so the developer can see it, while
            // creating the project
            e.printStackTrace();
        }
    }

    public DefaultHomePageController() {
        super(500, "a37c914b-f737-4a73-a226-7bd86baac8c3");
    }

    @Override
    public void executeEvaluation(RoutingContext routingContext, HttpServerResponse httpServerResponse) throws Throwable {
        routingContext
                .response()
                .putHeader("Content-type", "text/html")
                .end(FtlHelper.processToString(homePageTemplate, null));
    }
}