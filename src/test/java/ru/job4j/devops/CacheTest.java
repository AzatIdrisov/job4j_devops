package ru.job4j.devops;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CacheTest {

    @Test
    public void dummyTest() {
        System.out.println("Hello Cache!");
        assertThat(true).isTrue();
    }
}
