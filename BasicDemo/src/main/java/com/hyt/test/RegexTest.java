package com.hyt.test;

import org.junit.Test;
import java.io.Console;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hou
 * @create 2019-07-07 23:09
 **/
public class RegexTest {

    public static void main(String[] args) {
//        adaptIdeConsole();
//        adaptCmdConsole();
    }

    @Test
    public void zeroLengthAssertReg() {
        String ss = "sding sdfing beding";
        Pattern pattern = Pattern.compile("(?<=d)\\w+");
        Matcher matcher = pattern.matcher(ss);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    @Test
    public void zeroLengthAssertReg2() {
        Pattern p = Pattern.compile("(?<aaa>\\w{4})");
        Matcher m = p.matcher("aaaaaf");
        while (m.find()) {
            System.out.println(m.group("aaa"));
            // 结果 aaa aaf
        }
    }

    @Test
    public void matcherMultiLine() {
        //  里面带有换行符
        String testTxt = "1 个文件     59,629,625 字节\r\n7 个文件 41,259,528,192 字节";
        //  (?s)与DOTALL模式相等
        Pattern pat = Pattern.compile("(?s)^(\\d+)\\s+个文件\\s+([0-9,]+)\\s+字节\\s+$");
        Matcher mat = pat.matcher(testTxt);
        //  判断正则表达式是否匹配
        if (mat.matches()) {
            System.out.println(mat.group(1));
            System.out.println(mat.group(2));
            System.out.println("---------");
            System.out.println(mat.group(3));
        }
    }

    @Test
    public void matcherMultiLine2() {
        //  请注意起头的\n字符
        String testTxt = "\n1 个文件     59,629,625 字节\r\n7 个目录 41,259,528,192 可用字节";
        //  (?m)代表启动多行模式
        Pattern pat = Pattern.compile("(?m)^(\\d+)\\s个(?:文件|目录)\\s+([0-9,]+)\\s(?:可用)?字节$");
        Matcher mat = pat.matcher(testTxt);
        //  提取文件数量与字节数量
        while (mat.find()) {
            System.out.println(mat.group(1));
            System.out.println(mat.group(2));
        }
    }

    @Test
    public void matcherMultiLine3() {
        Pattern p2 = Pattern.compile("^.*(b).*$", Pattern.MULTILINE);
        Matcher matcher = p2.matcher("a\nb\nbb");
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }

    @Test
    public void appendReplaceTest() {
        Pattern pattern = Pattern.compile("a|b");
        Matcher m = pattern.matcher("cabcabca@126.com");
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, m.group().toUpperCase());
            System.out.println(sb.toString());
        }
        m.appendTail(sb);
        System.out.println(sb.toString());
    }

    @Test
    public void test1() {
        Pattern pattern = Pattern.compile("[a|b]+");
        Matcher m = pattern.matcher("abababb");
        System.out.println(m.matches());
    }

    private static void adaptIdeConsole() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your regex:");
            String regexStr = scanner.nextLine();
            Pattern pattern = Pattern.compile(regexStr);

            System.out.println("Enter input String to search:");
            String str = scanner.nextLine();
            Matcher matcher = pattern.matcher(str);

            boolean flag = false;
            while (matcher.find()) {
                System.out.printf("Found the text \"%s\" starting at index %d and ending at index %d.%n", matcher.group(), matcher.start(), matcher.end() - 1);
                flag = true;
            }
            if (!flag) {
                System.out.println("No match found.%n");
            }
        }
    }

    /**
     * 使用此方法需要删除首行package
     */
    private static void adaptCmdConsole() {
        Console console = System.console();
        if (null == console) {
            System.err.println("No console");
            System.exit(1);
        }
        while (true) {
            Pattern pattern = Pattern.compile(console.readLine("%nEnter your regex:"));
            Matcher matcher = pattern.matcher(console.readLine("Enter input String to search:"));

            boolean flag = false;
            while (matcher.find()) {
                console.format("Found the text \"%s\" starting at index %d and ending at index %d.%n", matcher.group(), matcher.start(), matcher.end());
                flag = true;
            }
            if (!flag) {
                console.format("No match found.%n");
            }
        }
    }
}
