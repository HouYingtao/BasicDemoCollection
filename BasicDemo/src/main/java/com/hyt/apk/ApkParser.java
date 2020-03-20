package com.hyt.apk;

import org.junit.Test;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * 功能介绍
 *
 * @author hou
 * @version 1.0
 * @date 2020-03-20 22:20
 * @since 1.8
 **/
public class ApkParser {

    private static final String PACKAGE = "package";

    private static final String SPLIT_REGEX = "(: )|(=')|(' )|'";

    private static final String COMMAND = "%s%s d badging \"%s\"";

    static String[] shellCommand;

    static String softName = "";

    static {
        shellCommand = new String[2];
        softName = "";
        final String anOSName = System.getProperty("os.name");
        System.out.println(anOSName);
        if (anOSName.toLowerCase().startsWith("windows")) {
            // Windows XP, Vista ...
            shellCommand[0] = "cmd";
            shellCommand[1] = "/C";
            softName = "aapt.exe";
        } else {
            // Unix, Linux ...
            shellCommand[0] = "/bin/sh";
            shellCommand[1] = "-c";
            softName = "aapt";
        }
    }

    @Test
    public void parseApkVersionTest() {
        String apkPath = "D:\\Develop\\DevTool\\bilibili.apk";
        String mAaptDirPath = ApkParser.class.getClassLoader().getResource("").getFile();
        mAaptDirPath = mAaptDirPath.substring(1);
        System.out.println(mAaptDirPath);
        ApkParser apkParser = new ApkParser();
        String apkVersion = apkParser.parseApkVersion(mAaptDirPath, apkPath);
        System.out.println(apkVersion);
    }

    private String parseApkVersion(String mAaptDirPath, String apkPath) {
        String command = String.format(COMMAND, mAaptDirPath, softName, apkPath);
        Process process;
        try {
            process = Runtime.getRuntime().exec(
                    new String[]{shellCommand[0], shellCommand[1], command});
        } catch (IOException e) {
            process = null;
            System.out.println(e.getMessage());
        }
        String source = "";
        String apkVersion = "";
        BufferedReader br = null;
        InputStream is = null;
        try {
            if (process != null) {
                is = process.getInputStream();
                br = new BufferedReader(
                        new InputStreamReader(is, Charset.forName("utf8")));
                source = br.readLine();
            }
            if (source == null || !source.startsWith("package")) {
                throw new Exception("参数不正确，无法正常解析APK包。输出结果为:\n" + source + "...");
            }
            int count = 0;
            do {
                String[] packageInfo = source.split(SPLIT_REGEX);
                apkVersion = packageInfo[6];
                count++;
            } while ((source = br.readLine()) != null && source.startsWith(PACKAGE));
            System.out.println(count);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            process.destroy();
            closeIO(is);
            closeIO(br);
        }
        return apkVersion;
    }

    private final void closeIO(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
