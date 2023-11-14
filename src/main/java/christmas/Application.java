package christmas;

import christmas.model.MenuItem;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        int date = inputView.readDate(); //날짜 정보
        List<MenuItem> myorderList = inputView.readMenu(); // 내가 주문한 메뉴 목록
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");

        OutputView outputView = new OutputView();

        //주문 메뉴
        outputView.printMenu(myorderList);

        //할인 전 총주문 금액
        int sum = outputView.MoneyBeforeDiscount(myorderList);

        //증정 메뉴
        sum = outputView.presentationMenu(myorderList, sum);

        //혜택 내역
        outputView.BenefitDetails(myorderList, date, sum);

    }
}
