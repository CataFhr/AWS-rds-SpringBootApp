package com.example.awsrdsspringbootapp.mapper;

import com.example.awsrdsspringbootapp.clientmodel.ImageClientModel;
import com.example.awsrdsspringbootapp.clientmodel.ImageUploadClientModel;
import com.example.awsrdsspringbootapp.entity.ImageEntityModel;
import com.example.awsrdsspringbootapp.service.S3Service;
import org.mapstruct.*;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
@Component
public interface ImageMapper {

    @Mapping(target = "bitmap", ignore = true)
    ImageClientModel toClientModel(ImageEntityModel entityModel, @Context S3Service s3Service);

    ImageEntityModel toEntityModel(ImageUploadClientModel clientModel);

    ImageEntityModel toEntityModel(ImageClientModel clientModel);

    @AfterMapping
    default void setBitmapToClient(@MappingTarget ImageClientModel target, ImageEntityModel source, @Context S3Service s3Service) {
        target.setBitmap(s3Service.downloadObject(source.getName()));
    }
}
