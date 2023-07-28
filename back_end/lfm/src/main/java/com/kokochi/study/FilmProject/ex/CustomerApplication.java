package com.kokochi.study.FilmProject.ex;

import com.kokochi.study.FilmProject.domain.MusicVO;
import com.kokochi.study.FilmProject.repository.CategoryRepository;
import com.kokochi.study.FilmProject.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Date;
import java.util.List;

//@SpringBootApplication
public class CustomerApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private MusicRepository musicRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
/*        Customer cus1 = new Customer("kim", "jaewon");
        Customer cus2 = new Customer("kown", "minsub");
        Customer cus3 = new Customer("kim", "minjae");

//        customerRepository.insert(Arrays.asList(cus1, cus2));
//        List<Customer> result = customerRepository.findByFirstName("kim");
//        System.out.println(result);
//        mongoTemplate.insertAll(Arrays.asList(cus1, cus2, cus3));
        List<Customer> result = mongoTemplate.find(
                Query.query(Criteria.where(Customer.FIRST_NAME).is("kim"))
        , Customer.class);
        System.out.println(result);

        mongoTemplate.remove(
                Query.query(Criteria.where(Customer.LAST_NAME).is("jaewon"))
        , Customer.class);*/
        // 기본 예제

//        MusicVO m = new MusicVO();
//        m.setVocal("머드 더 스튜던트");
//        m.setTitle("불협화음");
//        m.setFileName("merryGoRound");
//        m.setExtension("mp3");
//        m.setSize(30000);
//        m.setRegDate(new Date());
//        m.setReadNum(0);
//        m.setHighlight("01:12");
//        m.setPoint(0);
//        musicRepository.insert(m);

//        Category cat = new Category();
//        cat.setCategoryName("재밌음");
//        categoryRepository.insert(cat);
//        System.out.println("삽입 성공");

        //        List<String> mList = new ArrayList<>();
//
//
//        List<Music> bio = musicRepository.findByVocal("비오");
//        for (Music music : bio) {
//            System.out.println(music);
//            mList.add(music.getId());
//        }
//        cat.setItemList(mList);
//        categoryRepository.insert(cat);

//        Category category = categoryRepository.findById("61b990601e76ce383549a37a").get();
//        List<Music> all = musicRepository.findAll();
//        for (Music music : all) {
//            List<String> caList = new ArrayList<>();
//            music.setCategoryList(caList);
//        }
//        musicRepository.saveAll(all);

//        List<Music> list = musicRepository.findByCategoryList("61b98aa9145b7036b0d646c4");
//        List<Music> after = musicRepository.findByCategoryListAfter("61b98aa9145b7036b0d646c4");
//        List<Music> bef = musicRepository.findByCategoryListBefore("61b98aa9145b7036b0d646c4");
//        List<Music> containing = musicRepository.findByCategoryListContaining("61b98aa9145b7036b0d646c4");
//        List<MusicVO> contains = musicRepository.findByCategoryListContains("61b99079f891055402d0fe0b");
//        List<Music> notContains = musicRepository.findByCategoryListNotContains("61b98aa9145b7036b0d646c4");
//        List<Music> endingWith = musicRepository.findByCategoryListEndingWith("61b98aa9145b7036b0d646c4");
//        List<Music> endsWith = musicRepository.findByCategoryListEndsWith("61b98aa9145b7036b0d646c4");
//
//        for (Music category : list) {System.out.println("list :: " + category);}
//        for (Music category : after) {System.out.println("after :: " + category);}
//        for (Music category : bef) {System.out.println("bef :: " + category);}
//        for (Music category : containing) {System.out.println("containing :: " + category);}
//        for (MusicVO category : contains) {System.out.println("contains :: " + category);}
//        for (Music category : notContains) {System.out.println("notContains :: " + category);}
//        for (Music category : endingWith) {System.out.println("endingWith :: " + category);}
//        for (Music category : endsWith) {System.out.println("endsWith :: " + category);}

    }
}
