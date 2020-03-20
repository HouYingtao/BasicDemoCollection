package com.hyt.apk;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 功能介绍
 *
 * @author hou
 * @version 1.0
 * @date 2020-03-20 21:38
 * @since 1.8
 **/
@Getter
@Setter
@ToString
public class ApkInfo {
    private String launchableActivity;
    private String sdkVersion;
    private String minOSVersion;
    private String targetSdkVersion;
    private String applicationLable;
    private String applicationIcon;
    private String packageName;
    private String versionCode;
    private String versionName;
    private Long apkFileSize;

}
