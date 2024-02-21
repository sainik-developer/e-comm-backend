package org.example.mapper;

import org.example.dto.ProductDTO;
import org.example.entity.ProductDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    List<ProductDTO> toDTO(final List<ProductDO> productDO);
}
