package com.kokochi.tech.dbshard.domain;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

@SpringBootTest
@Rollback(false)
@Transactional
public class ProductTest {

}
