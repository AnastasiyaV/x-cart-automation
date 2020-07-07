public enum Urls {
    HOME (""),
    HOTDEALS ("sale-products/"),
    SHIPPING ("shipping"),
    NEW ("newarrivals/"),
    COMMINGSOON ("coming-soon/"),
    CONTACTUS ("contact-us/"),
    FASHION ("fashion/");

    private final String url;

    Urls (String url){
        this.url = url;
    }

    String getUrl (){
        return "https://trial.x-cart.com/nazarkraniagmailcom/"+url;
    }


}
