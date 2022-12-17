package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    final private ItemRepository itemRepository;

    // 회원 가입
    @Transactional
    public Long saveItem(Item item) {
        itemRepository.save(item);
        return item.getId();
    }

    @Transactional
    public Item updateItem(Long itemId, String name, int price, int stockQuantity) {
        Item findItem = itemRepository.findOne(itemId);
        // 찾아온 item은 영속성 상태가 된다.

        findItem.setPrice(price);
        findItem.setName(name);
        findItem.setStockQuantity(stockQuantity);
        return findItem;        // 영속성 컨텍스트에서 관리해주는 개체를 반환한다.
    }


    // 회원 전체 조회
    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
