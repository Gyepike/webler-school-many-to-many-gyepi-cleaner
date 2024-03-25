package com.anti.weblerschoolmanytomanygyepi.bootstrap;

import com.anti.weblerschoolmanytomanygyepi.entity.base.YourEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import com.anti.weblerschoolmanytomanygyepi.persistence.YourEntityRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final YourEntityRepository yourEntityRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // You can create and save example entities here
        YourEntity exampleEntity1 = new YourEntity();
        exampleEntity1.setName("Example 1");
        yourEntityRepository.save(exampleEntity1);

        YourEntity exampleEntity2 = new YourEntity();
        exampleEntity2.setName("Example 2");
        yourEntityRepository.save(exampleEntity2);
    }
}
