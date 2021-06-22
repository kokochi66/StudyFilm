
package org.kochi.repository;

import org.kochi.domain.Board2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board2, Integer> { // BoardRepository 인터페이스를 정의한다. JpaRepository를상속받도록 한다
}
