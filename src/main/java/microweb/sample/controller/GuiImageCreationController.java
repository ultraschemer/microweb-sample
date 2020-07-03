package microweb.sample.controller;

import com.ultraschemer.microweb.vertx.SimpleController;
import io.vertx.core.MultiMap;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.FileUpload;
import io.vertx.ext.web.RoutingContext;

import java.util.Set;

public class GuiImageCreationController extends SimpleController {
    public GuiImageCreationController() {
        super(500, "98473a7b-3fd6-4ef3-b1b7-b53210f7a75b");
    }

    @Override
    public void executeEvaluation(RoutingContext context, HttpServerResponse response) throws Throwable {
        HttpServerRequest request = context.request();
        String contentType = request.getHeader("Content-type");
        MultiMap attributes = request.formAttributes();
        Set<FileUpload> uploads = context.fileUploads();

        throw new Exception("Unimplemented");
    }
}
