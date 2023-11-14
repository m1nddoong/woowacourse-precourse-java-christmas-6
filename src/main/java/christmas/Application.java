package christmas;

import christmas.model.MenuItem;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        inputView.readDate();
        List<MenuItem> myorderList = inputView.readMenu(); // 내가 주문한 메뉴 목록

        OutputView outputView = new OutputView();
        outputView.printMenu(myorderList);
        outputView.MoneyBeforeDiscount(myorderList);
    }


}
