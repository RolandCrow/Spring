package SpringWeb;

public class ArtistNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1462190646166272903L;

    public ArtistNotFoundException(String message) {
        super(message);
    }

}
