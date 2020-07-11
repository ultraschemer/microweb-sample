package microweb.sample.domain.error;

import com.ultraschemer.microweb.error.StandardException;

public class ImageManagmentSaveBase64RepresentationError extends StandardException {
    public ImageManagmentSaveBase64RepresentationError(String message, Throwable cause) {
        super("ca1b849b-b598-46c9-9e2a-26e7c79ab888", 500, message, cause);
    }
}
