package christmas.model;

// 메뉴를 나타내는 MenuItem 클래스 (불변한 데이터를 표현하기에 적합)
//public record MenuItem (String menuName, int price, int quantity) {
//}

public class MenuItem {
    private String menuName;
    private int price;
    private int quantity;
    private boolean isBenefit;

    public MenuItem(String menuName, int price, int quantity, boolean isBenefit) {
        this.menuName = menuName;
        this.price = price;
        this.quantity = quantity;
        this.isBenefit = isBenefit;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean getIsBenefit() {
        return isBenefit;
    }

    public void setIsBenefit(boolean isBenefit) {
        this.isBenefit = isBenefit;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // equals(), hashCode(), toString() 등의 메서드는 자동으로 생성됨
}


