package hello.springbasic.order;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Order {
    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;

}
