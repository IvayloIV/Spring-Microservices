package com.example.mapstructdemo.mappers;

import com.example.mapstructdemo.entities.TestEntity;
import com.example.mapstructdemo.models.TestModel;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TestMapper {

    @BeforeMapping
    default void validateMangers(String name, Integer age) {
        System.out.println("Validate Mangers");
    }

    @Mapping(source = "name", target = "name", qualifiedByName = "toUpperCase")
    @Mapping(source = "age", target = "age")
    TestEntity convert(Integer age, String name);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "age", target = "age")
    void updateExisting(String name, Integer age, @MappingTarget TestEntity testEntity);

    @AfterMapping
    default void updateResult(String name, Integer age, @MappingTarget TestEntity testEntity) {
        System.out.println("Update Result");
    }

    TestModel convert(TestEntity testEntity);

    @Named("toUpperCase")
    default String toUpperCase(String str) {
        return str.toUpperCase();
    }
}
