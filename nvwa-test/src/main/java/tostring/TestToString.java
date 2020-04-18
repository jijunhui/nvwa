package tostring;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.junit.Test;

/**
 * @author jijunhui
 * @version 1.0.0
 * @date 2020/4/7 23:01
 * @description toString测试
 */
public class TestToString {


    @Test
    public void plusTest(){
        String string = "拉设计费卡几十块法师法师福建考试发送九分裤按时缴费as两房加上福建考试福建考试打飞机啊设计费按时缴费案件是否贾师傅卡死放假啊飞机拉斯对接";
        TestClass testClass = new TestClass();
        testClass.setStr1(string);
        testClass.setStr2(string);
        testClass.setStr3(string);
        testClass.setStr4(string);
        testClass.setStr5(string);
        testClass.setStr6(string);
        testClass.setStr7(string);
        testClass.setStr8(string);
        testClass.setStr9(string);
        testClass.setStr10(string);
        long total = 0;
        for (int i=0; i<10; i++){
            long start = System.currentTimeMillis();
            for (int j=0; j<100000; j++){
                System.out.println(testClass);
            }
            total += System.currentTimeMillis() - start;
        }
        System.out.println("10次平均耗时:" + total / 10 + "ms");
    }
    @Test
    public void StringBuilderTest(){
        String string = "拉设计费卡几十块法师法师福建考试发送九分裤按时缴费as两房加上福建考试福建考试打飞机啊设计费按时缴费案件是否贾师傅卡死放假啊飞机拉斯对接";
        TestClass2 testClass = new TestClass2();
        testClass.setStr1(string);
        testClass.setStr2(string);
        testClass.setStr3(string);
        testClass.setStr4(string);
        testClass.setStr5(string);
        testClass.setStr6(string);
        testClass.setStr7(string);
        testClass.setStr8(string);
        testClass.setStr9(string);
        testClass.setStr10(string);
        long total = 0;
        for (int i=0; i<10; i++){
            long start = System.currentTimeMillis();
            for (int j=0; j<100000; j++){
                System.out.println(testClass);
            }
            total += System.currentTimeMillis() - start;
        }
        System.out.println("10次平均耗时:" + total / 10 + "ms");
    }

}

@Setter
@Getter
class TestClass{
    private String str1;
    private String str2;
    private String str3;
    private String str4;
    private String str5;
    private String str6;
    private String str7;
    private String str8;
    private String str9;
    private String str10;

    @Override
    public String toString() {
        return "TestClass{" +
                "str1='" + str1 + '\'' +
                ", str2='" + str2 + '\'' +
                ", str3='" + str3 + '\'' +
                ", str4='" + str4 + '\'' +
                ", str5='" + str5 + '\'' +
                ", str6='" + str6 + '\'' +
                ", str7='" + str7 + '\'' +
                ", str8='" + str8 + '\'' +
                ", str9='" + str9 + '\'' +
                ", str10='" + str10 + '\'' +
                '}';
    }
}
@Setter
@Getter
class TestClass2{
    private String str1;
    private String str2;
    private String str3;
    private String str4;
    private String str5;
    private String str6;
    private String str7;
    private String str8;
    private String str9;
    private String str10;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TestClass2{");
        sb.append("str1='").append(str1).append('\'');
        sb.append(", str2='").append(str2).append('\'');
        sb.append(", str3='").append(str3).append('\'');
        sb.append(", str4='").append(str4).append('\'');
        sb.append(", str5='").append(str5).append('\'');
        sb.append(", str6='").append(str6).append('\'');
        sb.append(", str7='").append(str7).append('\'');
        sb.append(", str8='").append(str8).append('\'');
        sb.append(", str9='").append(str9).append('\'');
        sb.append(", str10='").append(str10).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
