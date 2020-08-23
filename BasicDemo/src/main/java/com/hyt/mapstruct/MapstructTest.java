package com.hyt.mapstruct;

import java.util.Date;

/**
 * 功能介绍
 *
 * @author hou
 * @version 1.0
 * @date 2020-08-23 14:16
 * @since 1.8
 **/
public class MapstructTest {

    public static void main(String[] args) {
        PersonDO personDO = new PersonDO();
        personDO.setName("Hollis");
        personDO.setAge(26);
        personDO.setBirthday(new Date());
        personDO.setId(1);
        personDO.setGender(Gender.MALE.name());

        PersonDTO personDTO = PersonConverter.INSTANCE.do2dto(personDO);
        System.out.println(personDTO);
    }

}
