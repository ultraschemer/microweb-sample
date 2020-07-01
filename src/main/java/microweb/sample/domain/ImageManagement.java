package microweb.sample.domain;

import com.ultraschemer.microweb.entity.User;
import com.ultraschemer.microweb.error.StandardException;
import io.vertx.core.Vertx;
import microweb.sample.entity.Image;
import org.hibernate.SessionFactory;

import java.util.UUID;
import java.util.function.BiConsumer;

public class ImageManagement extends StandardDomain {
    public ImageManagement(SessionFactory factory, Vertx vertx) {
        super(factory, vertx);
    }

    public void save(User user, String imageFileName, BiConsumer<UUID, StandardException> resultHandler) {
        // Isolate the entire operation in a new thread, since it can be time and resource consuming:
        new Thread(() -> {
            // Implement image saving routines here.

            // Locate file

            // Load data

            // Convert it to Base64

            // Save in database

            // Finish operation:
            resultHandler.accept(null, null);
        }).start();
    }

    public Image read(User user, UUID imageId) throws StandardException {
        // Implement image reading routines here.
        return null;
    }

    public static byte[] base64StrToBin(String base64Str) {
        // Helper to implement conversion of image Base64 String to binary
        return null;
    }

    public void linkToUser(User owner, UUID imageId, UUID userId) throws StandardException {
        // Implement user->image linking here.
    }
}
