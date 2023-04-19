package com.ky.web.filter;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * <p>
 *
 * <p>
 *
 * @author WSH
 * @date 2022-11-07 10:02:44
 */
@SpringBootTest
public class CommonFilterTest {
    @Value("filter.excludes.uris")
    private String[] excludes;

    @Value("filter.excludes.uri")
    private String uri;

    @Test
    public void excludesTest(){
        System.out.println(Arrays.toString(excludes));
        System.out.println(uri);
    }
}
