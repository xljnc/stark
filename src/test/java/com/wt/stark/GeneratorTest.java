package com.wt.stark;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: qiyu
 * @date: 2020/1/3 15:10
 * @description:
 */
@SpringBootTest
public class GeneratorTest {

    @Autowired
    private AutoGenerator autoGenerator;

    @Test
    public void testGenerate() {
        autoGenerator.execute();
    }
}
