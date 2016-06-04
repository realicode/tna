package com.realaicy.tna.demos.webshowcase.modules.checkwork.service;

import com.realaicy.tna.demos.webshowcase.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by realaicy on 2016/3/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class DefaultCheckItemServiceTest {

    @Autowired
    private CheckItemService checkItemService;

    @Test
    public void testFindAllMenus() throws Exception {
        assertThat(checkItemService.findAllCheckItemExceptRoot().size()).isEqualTo(1);
        assertThat(checkItemService.findAllCheckItemExceptRoot().get(0).getChildren().size()).isEqualTo(13);
    }
}