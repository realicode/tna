package com.realaicy.tna.modules.core.utils;

import com.google.common.collect.Lists;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Collecitons3Test {

    @Test
    public void convertElementPropertyToString() {
        TestBean3 bean1 = new TestBean3();
        bean1.setId(1);
        TestBean3 bean2 = new TestBean3();
        bean2.setId(2);

        List list = Lists.newArrayList(bean1, bean2);

        assertThat(Collections3.extractToString(list, "id", ",")).isEqualTo("1,2");
    }

    @SuppressWarnings("unchecked")
    @Test
    public void convertElementPropertyToList() {
        TestBean3 bean1 = new TestBean3();
        bean1.setId(1);
        TestBean3 bean2 = new TestBean3();
        bean2.setId(2);

        List<TestBean3> list = Lists.newArrayList(bean1, bean2);
        List result = Collections3.extractToList(list, "id");
        assertThat(result).containsOnly(1, 2);
    }

    @Test
    public void convertCollectionToString() {
        List<String> list = Lists.newArrayList("aa", "bb");
        String result = Collections3.convertToString(list, ",");
        assertThat(result).isEqualTo("aa,bb");

        result = Collections3.convertToString(list, "<li>", "</li>");
        assertThat(result).isEqualTo("<li>aa</li><li>bb</li>");
    }

    @Test
    public void intersection() {
        List<String> lista = Lists.newArrayList("aa", "bb", "cc");
        List<String> listb = Lists.newArrayList("bb", "cc", "dd");
        List<String> result = Collections3.intersection(lista, listb);
        assertThat(Collections3.convertToString(result, ",")).isEqualTo("bb,cc");


    }

    @SuppressWarnings("unused")
    public static class TestBean3 {

        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

}
