package com.example.mapstructdemo.mappers;

import com.example.mapstructdemo.entities.Status;
import com.example.mapstructdemo.models.StatusModel;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StatusMapper {

//    @ValueMapping(target = "CASE1", source = "ACTIVE")
//    @ValueMapping(target = "CASE2", source = "INACTIVE")
    @EnumMapping(nameTransformationStrategy = MappingConstants.PREFIX_TRANSFORMATION, configuration = "SI_")
    StatusModel entityToModel(Status status);

    @InheritInverseConfiguration
    Status modelToEntity(StatusModel statusModel);
}
