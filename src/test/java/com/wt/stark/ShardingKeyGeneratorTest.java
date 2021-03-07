package com.wt.stark;

import org.apache.commons.lang3.StringUtils;
import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;

/**
 * @author: qiyu
 * @date: 2020/1/13 15:40
 * @description:
 */
public class ShardingKeyGeneratorTest {
    public static void main(String[] args) {
        SnowflakeShardingKeyGenerator generator = new SnowflakeShardingKeyGenerator();
        String workerIdStr = System.getProperty("workerId");
        if (StringUtils.isNotBlank(workerIdStr)) {
            long workerId = Long.valueOf(workerIdStr);
            generator.getProperties().put("worker.id", workerId);
        }
        System.out.println("worker.id:" + generator.getProperties().get("worker.id"));
//        generator.setWorkerId(workerId);
        int i = 0;
        while (i++ < 1000) {
            System.out.println(generator.generateKey());
        }
    }
}
