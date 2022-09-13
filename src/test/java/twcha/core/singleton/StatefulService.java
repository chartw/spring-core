package twcha.core.singleton;

public class StatefulService {

    private int price; //상태를 유지하는 필드

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // 여기가 문제
    }

    public int getPrice() {
        return price;
    }

    // 공유 필드 문제를 해결하기 위해서는
    // 1. 상태를 유지하는 필드를 제거
    // 2. 메서드 자체에서 price를 바로 반환 (파라미터를 사용하여 무상태로 설계함)
}
