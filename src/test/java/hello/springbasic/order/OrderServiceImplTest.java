package hello.springbasic.order;

import hello.springbasic.discount.FixDiscountPolicy;
import hello.springbasic.member.Grade;
import hello.springbasic.member.Member;
import hello.springbasic.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class OrderServiceImplTest {
	@Test
	void createOrder() {
		MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
		memoryMemberRepository.save(new Member(1L, "name", Grade.VIP));

		OrderServiceImpl orderService = new OrderServiceImpl(memoryMemberRepository, new FixDiscountPolicy());
		Order order = orderService.createOrder(1L, "itemA", 10000);
		assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}
}
