package com.hyt.mapstruct;

import lombok.Data;
import java.util.Date;

/**
 * 功能介绍
 *
 * @author hou
 * @version 1.0
 * @date 2020-08-23 14:14
 * @since 1.8
 **/
@Data
public class PersonDTO {
    private String userName;

    private Integer age;

    private Date birthday;

    private Gender gender;
}
