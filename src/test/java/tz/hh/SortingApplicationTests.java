package tz.hh;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class SortingApplicationTests {
    @Autowired
    private MySortedSymbolController controller;

    @Test
    void test1() {
        String s = controller.sortedLine("asdfdfgfdgadvadvdafvd");
        Assert.assertEquals("\"d\": 7,\"a\": 4,\"f\": 4,\"v\": 3,\"g\": 2,\"s\": 1","\"d\": 7,\"a\": 4,\"f\": 4,\"v\": 3,\"g\": 2,\"s\": 1");
    }
    @Test
    void test2() {
        String s = controller.sortedLine("aaaaaaaaaaaaaa");
        Assert.assertEquals("\"a\": 14","\"a\": 14");
    }

}
