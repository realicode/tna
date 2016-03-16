package com.realaicy.tna.study.lib.core;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import sun.swing.StringUIClientPropertyKey;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by realaicy on 16/3/16.
 */
public class FileDemo {
    public static void main(String[] args) {
        File file = new File("/Users/realaicy/Downloads/chkitems_realaicy.txt");
        File distFile = new File("/Users/realaicy/Downloads/chkitems_realaicy_processed.txt");

        List<String> lines = new LinkedList<String>();
        List<String> distLines = new LinkedList<String>();
        int realindex = 0;
        String id;
        String pid;
        String name;
        String content;
        String frontStringTemp;
        String newFrontStringTemp;
        String endStringTemp;
        int pidStartTemp;
        int pidEndTemp;
        try {
            lines = FileUtils.readLines(file, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String stemp : lines) {
            for (int index = 0; index < stemp.length() - 1; index++) {
                String w = stemp.substring(index, index + 1);
                if (w.compareTo("\u4e00") > 0 && w.compareTo("\u9fa5") < 0) {
                    //System.out.println("第一个中文的索引位置:" + index);
                    realindex = index;
                    break;
                }
            }

            frontStringTemp = StringUtils.deleteWhitespace(stemp.substring(0, realindex));
            newFrontStringTemp = frontStringTemp.replaceFirst("0", "1");
            endStringTemp = StringUtils.removeEnd(StringUtils.deleteWhitespace(stemp.substring(realindex)),"；");

            id = newFrontStringTemp.replace(".", "");
            pid = newFrontStringTemp.substring(0, newFrontStringTemp.lastIndexOf(".")).replace(".", "");
            System.out.println("ori:" + newFrontStringTemp + "\t" + "id:" + id + "\t" + "pid:" + pid + "\t" + endStringTemp);
            distLines.add(id + "\t" + pid + "\t" + endStringTemp);
            realindex = 0;
        }
        try {
            FileUtils.writeLines(distFile,distLines,"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
