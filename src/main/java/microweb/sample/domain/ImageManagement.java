package microweb.sample.domain;

import com.ultraschemer.microweb.entity.User;
import com.ultraschemer.microweb.error.StandardException;
import io.vertx.core.Vertx;
import microweb.sample.domain.error.ImageManagementSaveException;
import microweb.sample.entity.Image;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Base64;
import java.util.UUID;
import java.util.function.BiConsumer;

public class ImageManagement extends StandardDomain {
    public ImageManagement(SessionFactory factory, Vertx vertx) {
        super(factory, vertx);
    }

    public void save(User user, String imageFileName, BiConsumer<UUID, StandardException> resultHandler) {
        // Isolate the entire operation in a new thread, since it can be time and resource consuming:
        new Thread(() -> {
            try {
                // Read file:
                File file = new File(imageFileName);
                byte[] fEncoded = Base64.getEncoder().encode(Files.readAllBytes(file.toPath()));

                // Convert it to String:
                String base64contents = new String(fEncoded, StandardCharsets.US_ASCII);

                // Save in database
                try(Session session = this.openTransactionSession()) {
                    Image img = new Image();

                    // Continue from here

                    // Commit saved data:
                    session.getTransaction().commit();

                    // Finish operation:
                    resultHandler.accept(null, null);
                }
            } catch(Exception e) {
                resultHandler.accept(null, new ImageManagementSaveException("Unable to persist image to user: ", e));
            }
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
