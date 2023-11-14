package christmas.view;

import christmas.model.*;
import java.util.List;

public class OutputView {
    public void printMenu(List<MenuItem> myorderList) {
        System.out.println();
        System.out.println("<주문 메뉴>");
        for (MenuItem menuItem : myorderList) {
            System.out.println(menuItem.getMenuName() + " " + menuItem.getQuantity() + "개");
            // System.out.println("가격: " + menuItem.getPrice());
        }
    }

    public int MoneyBeforeDiscount(List<MenuItem> myorderList) {
        int sum = 0;

        System.out.println();
        System.out.println("<할인 전 총주문 금액>");
        for (MenuItem menuItem : myorderList) {
            sum = sum + menuItem.getPrice() * menuItem.getQuantity();
        }
        System.out.println(sum + " 원");
        return sum;
    }

    public int presentationMenu(List<MenuItem> myorderList, int sum) {
        System.out.println();
        System.out.println("<증정 메뉴>");

        if (sum >= 120000) {
            System.out.println("샴페인 1개");
            sum = sum - 25000;
        }
        return sum;
    }

}

