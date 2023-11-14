package christmas.view;

import static christmas.model.Menu.findPrice;

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

    public int presentationMenu(List<MenuItem> myorderList, int sum, int discount) {

        System.out.println();
        System.out.println("<증정 메뉴>");

        if (sum >= 120000) {
            System.out.println("샴페인 1개");
            discount += 25000;  //삼폐인 가격만큼 할인 가격으로 추가

            for (MenuItem menuItem : myorderList) {
                if ("샴페인".equals(menuItem.getMenuName())) { // 샴페인을 구매해서 구매목록에 있다면 혜택 있음 1 표시, 가격은 줄이기
                    menuItem.setIsBenefit(true); // 샴페인이 이미 있으면 혜탹만 true
                    return discount;
                }
            }

            // 샴페인이 없으면 객체를 만들어주기 - 샴페인 객체 추가 (가격은 제외)
            MenuItem champagne = new MenuItem("샴페인", 0, 1, true);
            myorderList.add(champagne); // 샴페인 객체를 주문목록에 추가
        }
        return discount;
    }

    public int BenefitDetails(List<MenuItem> myorderList, int date, int discount) {
        System.out.println();
        System.out.println("<혜택 내역>");


        int christmasDiscount = 1000 + 100 * (date-1);
        discount += christmasDiscount;
        int thousand = christmasDiscount / 1000;
        int reamining = christmasDiscount % 1000;
        System.out.println("크리스마스 디데이 할인: -" + thousand + "," + reamining + "원");


        // 평일 할인 적용
        for (MenuItem menuItem : myorderList) {
            // 평일인지 아닌지 판단
            if (date >= 1 && date <= 31 && date % 7 >= 1 && date % 7 <= 5) { // 일요일부터 목요일까지
                int weekdayCount = 0;
                String category = Menu.getCategory(menuItem.getMenuName()); // 카테고리 반환해줌
                if ("디저트".equals(category)) {
                    weekdayCount++;
                    // 해당 메뉴의 가격에서 할인 적용
                    int discountedPrice = menuItem.getPrice() - 2023;
                    menuItem.setPrice(discountedPrice);

                    // 할인 가격 축적
                    discount += 2023;
                }
                if (weekdayCount != 0) {
                    System.out.println("평일 할인: -" + weekdayCount * 2 + ",0" + (2023 * weekdayCount - 2000 * weekdayCount) + "원");
                }
            }
        }

        // 주말 할인 적용
        if (isWeekend(date)) {
            int weekendCount = 0;
            for (MenuItem menuItem : myorderList) {
                String category = Menu.getCategory(menuItem.getMenuName()); // 카테고리 반환해줌
                if ("메인".equals(category)) {
                    weekendCount++;
                    int discountedPrice = menuItem.getPrice() - 2023;
                    menuItem.setPrice(discountedPrice);

                    // 할인 가격 축적
                    discount += 2023;
                }
                if (weekendCount != 0) {
                    System.out.println("주말 할인: -" + weekendCount * 2 + ",0" + (2023 * weekendCount - 2000 * weekendCount) + "원");
                }

            }
        }


        // 특별 할인 적용
        if (date == 3 || date == 10 || date == 17 || date == 24 || date == 25 || date == 31) {
            discount += 1000;
            System.out.println("특별 할인: -1,000원");
        }


        for (MenuItem menuItem : myorderList) {
            if (menuItem.getIsBenefit()) {
                System.out.println("증정 이벤트: -25,000원");
            }
        }
        return discount;
    }
    // 주말 여부를 확인하는 메서드
    private boolean isWeekend(int date) {
        return date == 1 || date == 2 || date == 8 || date == 9 || date == 15 || date == 16 || date == 22 || date == 23 || date == 29 || date == 30;
    }


    public void TotalBenefitAmount (int discount) {
        System.out.println();
        System.out.println("<총혜택 금액>");
        System.out.println("-" + discount + "원");
    }

    public void EstimatedPayment (int sum, int discount) {
        System.out.println();
        System.out.println("<할인 후 예상 결제 금액");
        System.out.println((sum - discount)+ "원");
    }

}

