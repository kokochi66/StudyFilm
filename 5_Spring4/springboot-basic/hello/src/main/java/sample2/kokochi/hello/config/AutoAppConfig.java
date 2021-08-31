package sample2.kokochi.hello.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "sample2.kokochi.hello", // 탐색할 패키지의 시작위치를 결정함. 지정하지 않으면 현재 Config 파일의 위치로 지정된다.
        // 권장되는 방법을 패키지 위치를 지정하지 않고, 설정 클래스 자체를 최상단에 두는 방법을 택한다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        // 필터링을 통해서 Configuration.class 컴포넌트가 들어가있는 경우는 제외하여 스캔한다. (다른 Config 파일도 등록되면 오류가 발생하기 때문)
)
public class AutoAppConfig {

}