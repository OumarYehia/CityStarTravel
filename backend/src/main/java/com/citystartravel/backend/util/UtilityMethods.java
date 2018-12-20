package com.citystartravel.backend.util;

import com.citystartravel.backend.entity.bus.Bus;
import com.citystartravel.backend.entity.bus.BusResponse;
import com.citystartravel.backend.exception.BadRequestException;
import com.citystartravel.backend.exception.ResourceNotFoundException;
import com.citystartravel.backend.payload.response.PagedResponse;
import com.citystartravel.backend.security.CurrentUser;
import com.citystartravel.backend.security.UserPrincipal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

public class UtilityMethods<T> {

    public void validatePageNumberAndSize(int page, int size) {
        if(page < 0) {
            throw new BadRequestException("Page number cannot be less than zero.");
        }

        if(size > AppConstants.MAX_PAGE_SIZE) {
            throw new BadRequestException("Page size must not be greater than " + AppConstants.MAX_PAGE_SIZE);
        }
    }

    public PagedResponse<T> getAll(JpaRepository<T,Long> repository, @CurrentUser UserPrincipal currentUser, int page, int size) {
        validatePageNumberAndSize(page, size);

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");
        Page<T> pages = repository.findAll(pageable);

        if(pages.getNumberOfElements() == 0) {
            return new PagedResponse<>(Collections.emptyList(), pages.getNumber(),
                    pages.getSize(), pages.getTotalElements(), pages.getTotalPages(), pages.isLast());
        }

        return new PagedResponse<>(pages.getContent(), pages.getNumber(),
                pages.getSize(), pages.getTotalElements(), pages.getTotalPages(), pages.isLast());
    }

    public T getById(JpaRepository<T,Long> repository, @CurrentUser UserPrincipal currentUser, Long id, String resourceName) {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(resourceName, "id", id));
    }

    public T update(JpaRepository<T,Long> repository, T entity) {
        return repository.saveAndFlush(entity);
    }

    public void delete(JpaRepository<T,Long> repository, T entity) {
        repository.delete(entity);
    }

    public String generateEntityCreationMessage(String entityType, String entityName, @CurrentUser UserPrincipal currentUser) {
        return "[CREATED] "+entityType+" "+entityName+" created by "+currentUser.getUsername();
    }

}
