package com.realaicy.tna.modules.core.test.spring;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * 测试基类
 *
 * @author realaicy
 * @version 1.1
 * @email realaicy@gmail.com
 * @qq 8042646
 * @date 14-2-1 上午9:18
 * @description TODO
 * @since 1.1
 */
//@ContextConfiguration({"classpath:applicationContext-core-test.xml"})
@ContextConfiguration(classes=com.realaicy.tna.modules.core.test.spring.SpringTestConfig.class)
public abstract class SpringBaseNGTest extends AbstractTestNGSpringContextTests {

}
