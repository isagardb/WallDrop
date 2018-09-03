package in.dropcodes.walldrop.Model;

public class MainModel {

    private String previewURL;
    private String userImageURL;
    private String user;
    private String largeImageURL;
    private int imageWidth;
    private int imageHeight;


    public MainModel() {
    }

    public MainModel(String previewURL, String userImageURL, String user, String largeImageURL, int imageWidth, int imageHeight) {
        this.previewURL = previewURL;
        this.userImageURL = userImageURL;
        this.user = user;
        this.largeImageURL = largeImageURL;
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
    }

    public String getUserImageURL() {
        return userImageURL;
    }

    public void setUserImageURL(String userImageURL) {
        this.userImageURL = userImageURL;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public void setLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }
}
