package christmas.model;

// 메뉴를 나타내는 MenuItem 클래스 (불변한 데이터를 표현하기에 적합)
//public record MenuItem (String menuName, int price, int quantity) {
//}

public class MenuItem {
    private final String menuName;
    private final int price;
    private final int quantity;

    public MenuItem(String menuName, int price, int quantity) {
        this.menuName = menuName;
        this.price = price;
        this.quantity = quantity;
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

    // equals(), hashCode(), toString() 등의 메서드는 자동으로 생성됨
}


