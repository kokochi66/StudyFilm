package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    final private EntityManager em;

    public void save(Item item) {
        if (item.getId() == null) {
            em.persist(item);
        } else {
            em.merge(item);
            // 병합을 사용하면, 모든 속성이 다 관리된다.
            // 병합 시, 값이 존재하지 않으면, 기존에 있던 값도 전부 null로 업데이트를 치게 된다.
        }

    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class).getResultList();
    }

    public List<Item> findAllByName(String name) {
        return em.createQuery("select i from Item i where i.name = :name", Item.class)
                .setParameter("name", name)
                .getResultList();
    }
}
