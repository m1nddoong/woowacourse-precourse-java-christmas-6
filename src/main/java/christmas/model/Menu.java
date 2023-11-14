package christmas.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private static final List<MenuItem> selectedMenus = new ArrayList<>();
    private static final Map<String, Integer> menuPrices = createMenuPrices();

    private static Map<String, Integer> createMenuPrices() {
        Map<String, Integer> prices = new HashMap<>();
        prices.put("양송이수프", 6000);
        prices.put("타파스", 5500);
        prices.put("시저샐러드", 8000);
        prices.put("티본스테이크", 55000);
        prices.put("바비큐립", 54000);
        prices.put("해산물파스타", 35000);
        prices.put("크리스마스파스타", 25000);
        prices.put("초코케이크", 15000);
        prices.put("아이스크림", 5000);
        prices.put("제로콜라", 3000);
        prices.put("레드와인", 60000);
        prices.put("샴페인", 25000);
        return prices;
    }

    public static int findPrice(String menuName) { //메뉴 이름으로 가격 조회하기
        return menuPrices.getOrDefault(menuName, 0);
    }
}
