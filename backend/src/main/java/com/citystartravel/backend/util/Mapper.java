package com.citystartravel.backend.util;


import com.citystartravel.backend.payload.response.PagedResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Mapper<E,D> {

    private ModelMapper modelMapper;

    public Mapper() {
        modelMapper = new ModelMapper();
    }

    public D mapEntityToDto(E e, Class<D> DtoClass) {
        return modelMapper.map(e, DtoClass);
    }

    public PagedResponse<D> mapEntityPagesToDtoPages(PagedResponse<E> entityPagedResponse, Class<D> DtoClass) {
        PagedResponse<D> dtoPagedResponse = new PagedResponse<>();
        dtoPagedResponse.setLast(entityPagedResponse.isLast());
        dtoPagedResponse.setPage(entityPagedResponse.getPage());
        dtoPagedResponse.setSize(entityPagedResponse.getSize());
        dtoPagedResponse.setTotalElements(entityPagedResponse.getTotalElements());
        dtoPagedResponse.setTotalPages(entityPagedResponse.getTotalPages());

        List<E> entities = entityPagedResponse.getContent();
        List<D> dtos = new ArrayList<>();
        for(E e: entities) {
            dtos.add(mapEntityToDto(e, DtoClass));
        }
        dtoPagedResponse.setContent(dtos);
        return dtoPagedResponse;
    }

}
