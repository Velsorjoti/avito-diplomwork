package ru.skypro.project.marketplace.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import ru.skypro.project.marketplace.dto.UserDto;
import ru.skypro.project.marketplace.model.Image;
import ru.skypro.project.marketplace.model.User;


@Mapper(componentModel = "spring")
public interface UserMapper {

    String USER_IMAGE = "/users/image/";
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "image", source = "image", qualifiedByName = "imageMapping")
    UserDto toDto(User user);

    @Named("imageMapping")
    default String imageMapping(Image image) {
        if (image == null) {
            return null;
        }
        return USER_IMAGE + image.getId();
    }

}
