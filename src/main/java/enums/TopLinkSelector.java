package enums;

public enum TopLinkSelector {
    HOME (" "),
    HOTDEALS ("sale-products/"),
    SHIPPING ("shipping"),
    NEW ("newarrivals/"),
    COMMINGSOON ("coming-soon/"),
    CONTACTUS ("contact-us/"),
    FASHION ("fashion/");

    private final String url;

    TopLinkSelector(String url){
        this.url = url;
    }

    public String getCssSelector(){
        return String.format(".top-main-menu .leaf a[href=\"%s\"]", this.url);
    }

    public String getCssSelectorSuffix(){
        return this.url;
    }
}
