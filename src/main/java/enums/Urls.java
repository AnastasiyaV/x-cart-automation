package enums;

public enum Urls {
    HOME("https://taauto.myxcartstore.com/");

    private String url;
    public String getUrl() {
        return url;
    }

    Urls(String url) {
        this.url = url;
    }
}
