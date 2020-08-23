package com.hyt.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 功能介绍
 *
 * @author hou
 * @create 2020-08-23 14:10
 **/
@Mapper
public interface PersonConverter {
    PersonConverter INSTANCE = Mappers.getMapper(PersonConverter.class);

    @Mappings(@Mapping(source = "name", target = "userName"))
    PersonDTO do2dto(PersonDO person);
}
