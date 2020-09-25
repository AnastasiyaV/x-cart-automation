package enums;

public enum Urls {
    HOME(""),

    COMMING_SOON("coming-soon/");


    private String url;
    public String getUrl() {
        return String.format("https://taauto.myxcartstore.com/%s", url);
    }

    Urls(String url) {
        this.url = url;
    }
}
