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

        int discount = 0;

        //증정 메뉴 (할인 금액으로 축적 시키기)
        discount = outputView.presentationMenu(myorderList, sum, discount);

        //혜택 내역
        discount = outputView.BenefitDetails(myorderList, date, discount);

        //총혜택 금액
        outputView.TotalBenefitAmount(discount);

        //할인 후 예상 결제 금액
        outputView.EstimatedPayment(sum, discount);

        //12월 이벤트 배지
        outputView.EventBadge(discount);


    }
}
