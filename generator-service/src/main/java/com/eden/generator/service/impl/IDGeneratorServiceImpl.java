package com.eden.generator.service.impl;

import com.eden.generator.service.IDGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 序列号规则：业务标识 + 时间戳 + 序号
 *
 * @author
 * @since 2019/3/14
 */
@Service
public class IDGeneratorServiceImpl implements IDGeneratorService{

    private static String lastTime;
    private Object lock = new Object();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

    @Autowired
    private RedisService redisService;

    @Override
    public Long next(int bizCode) {
        String serialCode = next(String.valueOf(bizCode), 1);
        return Long.valueOf(serialCode);
    }

    @Override
    public String next(String bizCode) {
        return next(bizCode, 1);
    }

    @Override
    public String next(String bizCode, double delta) {
        String currentTime;
        synchronized (lock) {
            currentTime = dateFormat.format(new Date());
            if (!currentTime.equals(lastTime)) {
                lastTime = currentTime;
                redisService.hset("ID_GENERATOR", bizCode, 0);
            }
        }

        Double serialCode = redisService.hincr("ID_GENERATOR", bizCode, delta);
        return bizCode + currentTime + (serialCode.intValue() + 1000);
    }
}
