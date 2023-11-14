package christmas.view;
import static christmas.model.Menu.findPrice;
import camp.nextstep.edu.missionutils.Console;
import christmas.model.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    public int readDate() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너 입니다.");
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public List<MenuItem> readMenu() {
        System.out.println("주문하실 메뉴를 메누와 개수를 알려 주세요. (e.g. 해산물파스타-2, 레드와인-1, 초코케이크-1)");
        String input = Console.readLine(); // 입력 받기
        String[] menuItems = input.split(","); // 쉼표로 구분하여 배열 menuItems 으로 저장

        List<MenuItem> orderList = new ArrayList<>(); // Menu 클래스형 리스트 선언

        for (String menuItem : menuItems) {  // 배열 menuItems 의 menuItem 하나씩
            String[] parts = menuItem.split("-"); // "-" 로 구분

            if (parts.length == 2) {
                String menuName = parts[0].trim(); // 음식 종류 (앞뒤 공백 제거)
                int quantity = Integer.parseInt(parts[1].trim()); // 음식 양
                MenuItem myMenu = new MenuItem(menuName, findPrice(menuName), quantity);
                orderList.add(myMenu);
            }
        }

        return orderList;
    }
}
