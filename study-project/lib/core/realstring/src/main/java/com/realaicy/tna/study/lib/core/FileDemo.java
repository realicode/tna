package com.realaicy.tna.study.lib.core;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import sun.swing.StringUIClientPropertyKey;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by realaicy on 16/3/16.
 */
public class FileDemo {
    public static void main(String[] args) {
        File file = new File("/Users/realaicy/Downloads/chkitems_realaicy.txt");
        File distFile = new File("/Users/realaicy/Downloads/chkitems_realaicy_processed_324.txt");

        List<String> lines = new LinkedList<String>();
        List<String> lines2 = new LinkedList<String>();

        List<String> distLines = new LinkedList<String>();
        Map<String, Boolean> leafMap = new HashMap<String, Boolean>();
        Set<String> leafSet = new LinkedHashSet<String>();
        int realindex = 0;//序号和文字的分隔
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
            lines2 = FileUtils.readLines(file, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.reverse(lines);
        /*System.out.println(lines.size());
        for (String stemp : lines) {
            System.out.println(stemp);
        }*/

        Boolean isFirst = Boolean.TRUE;
        String tempID = "";
        String tempPID = "";
        String tempcasID = "";
        String tempIsLeaf = "1";
        String tempIconName = "folder2.png";
        String tempRootKey = "ss_a";
        String tempRootName = "药品生产质量管理规范";
        int tempNewLevel = 0;
        int nowLevel = 0;
        int maxLevel = 0;
        String maxLevelString = "";


        String tempCasIDLevel2 = "0.003";
        String tempCasIDLevel3 = "001";//对应"章"
        String baseParentIDLevel3 = "eb1e0ffd3f5946fca35b23a2f7798c47";
        String tempCasIDLevel4 = "001";//对应"节"
        String baseParentIDLevel4 = "";
        String tempCasIDLevel5 = "001";//对应"节"
        String baseParentIDLevel5 = "";
        String tempCasIDLevel6 = "001";//对应"节"
        String baseParentIDLevel6 = "";
        String tempCasIDLevel7 = "001";//对应"节"
        String baseParentIDLevel7 = "";

        int tempSortLevel = 0;
        int tempSortLevel3 = 10;
        int tempSortLevel4 = 10;
        int tempSortLevel5 = 10;
        int tempSortLevel6 = 10;
        int tempSortLevel7 = 10;

        DecimalFormat df = new DecimalFormat("000");

        for (String stemp : lines) {
            //System.out.println("原串X:\t" + stemp);
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
            endStringTemp = StringUtils.removeEnd(
                    StringUtils.deleteWhitespace(stemp.substring(realindex)), "；");
            // System.out.println("新串A:\t" + newFrontStringTemp + "\t" + endStringTemp);
            tempNewLevel = StringUtils.countMatches(newFrontStringTemp, '.') + 2;

            if (isFirst) {
                leafMap.put(newFrontStringTemp, true);
                leafSet.add(newFrontStringTemp);
                isFirst = false;
            } else {
                if (tempNewLevel >= nowLevel) {
                    leafMap.put(newFrontStringTemp, true);
                    leafSet.add(newFrontStringTemp);
                }

            }
            /*if (tempNewLevel > maxLevel) {
                maxLevel = tempNewLevel;
                maxLevelString = newFrontStringTemp;
            }*/






            /*tempID=UUID.randomUUID().toString().replaceAll("-","");
            tempNewLevel = StringUtils.countMatches("newFrontStringTemp", '.');
            if (tempNewLevel == 1) {//章(例如1.总则;2质量管理)
                tempCascadeID=StringUtils.join("0.003.",
                        StringUtils.leftPad(StringUtils.split(newFrontStringTemp, ".")[1], 3, '0'));
                tempName=StringUtils.removeEnd(StringUtils.deleteWhitespace(stemp.substring(realindex)), "；");
                tempName=StringUtils.removeEnd(tempName, "：");
            }

            if (StringUtils.split(newFrontStringTemp, ".")[1].equals("4")) {

                endStringTemp = StringUtils.removeEnd(StringUtils.deleteWhitespace(stemp.substring(realindex)), "；");

                id = newFrontStringTemp.replace(".", "");
                pid = newFrontStringTemp.substring(0, newFrontStringTemp.lastIndexOf(".")).replace(".", "");
                System.out.println("ori:" + newFrontStringTemp + "\t" + "id:" + id + "\t" + "pid:" + pid + "\t" + endStringTemp);
                distLines.add(id + "\t" + pid + "\t" + endStringTemp);
                realindex = 0;
            }

        }
        try {
            FileUtils.writeLines(distFile, distLines, "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }*/

            nowLevel = tempNewLevel;
            tempNewLevel = 0;
        }//每一行

        /*for (Map.Entry<String, Boolean> entry : leafMap.entrySet()) {

            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

        }*/
        for (String str : leafSet) {
            System.out.println(str);
        }
        // System.out.println("MaxLevel: " + maxLevel + "\t" + maxLevelString);
//_______________________________________________________________________________________________
        for (String stemp2 : lines2) {
            //System.out.println("原串Y:\t" + stemp2);
            for (int index = 0; index < stemp2.length() - 1; index++) {
                String w = stemp2.substring(index, index + 1);
                if (w.compareTo("\u4e00") > 0 && w.compareTo("\u9fa5") < 0) {
                    //System.out.println("第一个中文的索引位置:" + index);
                    realindex = index;
                    break;
                }
            }

            frontStringTemp = StringUtils.deleteWhitespace(stemp2.substring(0, realindex));
            newFrontStringTemp = frontStringTemp.replaceFirst("0", "1");
            endStringTemp = StringUtils.removeEnd(
                    StringUtils.deleteWhitespace(stemp2.substring(realindex)), "；");
            //System.out.println("新串C:\t" + newFrontStringTemp + "\t" + endStringTemp);
            tempNewLevel = StringUtils.countMatches(newFrontStringTemp, '.') + 2;
            tempID = UUID.randomUUID().toString().replaceAll("-", "");
            if (tempNewLevel == 3) {
                System.out.println("原串3:\t" + stemp2);

                tempPID = baseParentIDLevel3;
                baseParentIDLevel4 = tempID;
                tempcasID = tempCasIDLevel2 + "." +
                        StringUtils.leftPad(StringUtils.split(newFrontStringTemp, ".")[1], 3, '0');
                tempCasIDLevel3 = tempcasID;

                System.out.println("新串3:\t" + tempID + "\t" + tempcasID + "\t" + tempPID);
                tempSortLevel = tempSortLevel3;
                tempSortLevel3 += 10;
                tempSortLevel4 = 10;
                tempSortLevel5 = 10;
                tempSortLevel6 = 10;
                tempSortLevel7 = 10;

            }
            if (tempNewLevel == 4) {
                System.out.println("原串4:\t" + stemp2);

                tempPID = baseParentIDLevel4;
                baseParentIDLevel5 = tempID;
                tempcasID = tempCasIDLevel3 + "." +
                        StringUtils.leftPad(StringUtils.split(newFrontStringTemp, ".")[2], 3, '0');
                tempCasIDLevel4 = tempcasID;

                System.out.println("新串4:\t" + tempID + "\t" + tempcasID + "\t" + tempPID);
                tempSortLevel = tempSortLevel4;
                tempSortLevel4 += 10;
                tempSortLevel5 = 10;
                tempSortLevel6 = 10;
                tempSortLevel7 = 10;
            }
            if (tempNewLevel == 5) {
                System.out.println("原串5:\t" + stemp2);

                tempPID = baseParentIDLevel5;
                baseParentIDLevel6 = tempID;
                tempcasID = tempCasIDLevel4 + "." +
                        StringUtils.leftPad(StringUtils.split(newFrontStringTemp, ".")[3], 3, '0');
                tempCasIDLevel5 = tempcasID;

                System.out.println("新串5:\t" + tempID + "\t" + tempcasID + "\t" + tempPID);
                tempSortLevel = tempSortLevel5;
                tempSortLevel5 += 10;
                tempSortLevel6 = 10;
                tempSortLevel7 = 10;
            }
            if (tempNewLevel == 6) {
                System.out.println("原串6:\t" + stemp2);

                tempPID = baseParentIDLevel6;
                baseParentIDLevel7 = tempID;
                tempcasID = tempCasIDLevel5 + "." +
                        StringUtils.leftPad(StringUtils.split(newFrontStringTemp, ".")[4], 3, '0');
                tempCasIDLevel6 = tempcasID;

                System.out.println("新串6:\t" + tempID + "\t" + tempcasID + "\t" + tempPID);
                tempSortLevel = tempSortLevel6;
                tempSortLevel6 += 10;
                tempSortLevel7 = 10;
            }
            if (tempNewLevel == 7) {
                System.out.println("原串7:\t" + stemp2);

                tempPID = baseParentIDLevel7;
                tempcasID = tempCasIDLevel6 + "." +
                        StringUtils.leftPad(StringUtils.split(newFrontStringTemp, ".")[5], 3, '0');
                tempCasIDLevel7 = tempcasID;

                System.out.println("新串7:\t" + tempID + "\t" + tempcasID + "\t" + tempPID);
                tempSortLevel = tempSortLevel7;
                tempSortLevel7 += 10;
            }
            if (leafSet.contains(newFrontStringTemp)) {
                distLines.add(tempID + "\t" + tempcasID + "\t" + "ss_a" + "\t" + "药品生产管理规范" + "\t" + endStringTemp + "\t" +
                        tempPID + "\t" + "1" + "\t"+ "default.png" + "\t" + tempSortLevel);
            } else {
                distLines.add(tempID + "\t" + tempcasID + "\t" + "ss_a" + "\t" + "药品生产管理规范" + "\t" + endStringTemp + "\t" +
                        tempPID + "\t" + "0"+ "\t" + "folder2.png" + "\t" + tempSortLevel);
            }

            /*if (tempNewLevel > maxLevel) {
                maxLevel = tempNewLevel;
                maxLevelString = newFrontStringTemp;
            }*/






            /*tempID=UUID.randomUUID().toString().replaceAll("-","");
            tempNewLevel = StringUtils.countMatches("newFrontStringTemp", '.');
            if (tempNewLevel == 1) {//章(例如1.总则;2质量管理)
                tempCascadeID=StringUtils.join("0.003.",
                        StringUtils.leftPad(StringUtils.split(newFrontStringTemp, ".")[1], 3, '0'));
                tempName=StringUtils.removeEnd(StringUtils.deleteWhitespace(stemp.substring(realindex)), "；");
                tempName=StringUtils.removeEnd(tempName, "：");
            }

            if (StringUtils.split(newFrontStringTemp, ".")[1].equals("4")) {

                endStringTemp = StringUtils.removeEnd(StringUtils.deleteWhitespace(stemp.substring(realindex)), "；");

                id = newFrontStringTemp.replace(".", "");
                pid = newFrontStringTemp.substring(0, newFrontStringTemp.lastIndexOf(".")).replace(".", "");
                System.out.println("ori:" + newFrontStringTemp + "\t" + "id:" + id + "\t" + "pid:" + pid + "\t" + endStringTemp);
                distLines.add(id + "\t" + pid + "\t" + endStringTemp);
                realindex = 0;
            }

        }
        try {
            FileUtils.writeLines(distFile, distLines, "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }*/

            nowLevel = tempNewLevel;
            tempNewLevel = 0;
        }//每一行

        for (String str : distLines) {
            System.out.println(str);
        }
        try {
            FileUtils.writeLines(distFile, distLines, "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
