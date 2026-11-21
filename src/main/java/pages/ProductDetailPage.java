package pages;

public class ProductDetailPage {
    public enum Selector {
        ;

        private final String selector;

        Selector(String selector) {
            this.selector = selector;
        }

        public String getSelector() {
            return selector;
        }
    }
}
