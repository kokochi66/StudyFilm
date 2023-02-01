package Study.datajpa.repository;

import org.springframework.beans.factory.annotation.Value;

public interface UserNameOnly {

//    String getName();

    @Value("#{target.name +  ' ' + target.age}")
    String getName();
}
