package com.eden.generator.util;

import java.util.regex.Pattern;

/**
 * @author chenqw
 * @version 1.0
 * @since 2019/3/14
 */
public class CommonUtils {
    
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

}
