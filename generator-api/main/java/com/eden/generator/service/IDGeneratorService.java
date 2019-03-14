package com.eden.generator.service;

/**
 * Created by 18060757 on 2019/3/14.
 */
public interface IDGeneratorService {
    String next(String bizCode);

    String next(String bizCode, double delta);
}
