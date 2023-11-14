package christmas.view;

import christmas.model.*;
import java.util.List;

public class OutputView {
    public void printMenu(List<MenuItem> myorderList) {
        System.out.println("<주문 메뉴>");
        for (MenuItem menuItem : myorderList) {
            System.out.println(menuItem.getMenuName() + " " + menuItem.getQuantity() + "개");
            // System.out.println("가격: " + menuItem.getPrice());
        }
    }
    // ...
}