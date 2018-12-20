package com.citystartravel.backend.entity.sparetype;

import com.citystartravel.backend.payload.response.PagedResponse;
import com.citystartravel.backend.security.CurrentUser;
import com.citystartravel.backend.security.UserPrincipal;
import com.citystartravel.backend.util.UtilityMethods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpareTypeService {

    @Autowired
    private SpareTypeRepository spareTypeRepository;

    private static final Logger logger = LoggerFactory.getLogger(SpareTypeService.class);

    private UtilityMethods<SpareType> utilityMethods = new UtilityMethods<>();

    public PagedResponse<SpareType> getAllSpareTypes(UserPrincipal currentUser, int page, int size) {
        return utilityMethods.getAll(spareTypeRepository,currentUser,page,size);
    }

    public SpareType getSpareTypeById(Long spareTypeId, @CurrentUser UserPrincipal currentUser) {
        return utilityMethods.getById(spareTypeRepository, currentUser, spareTypeId,"SpareType");
    }

    public SpareType createSpareType(SpareTypeRequest spareTypeRequest) {
        SpareType spareType = new SpareType();
        spareType.setName(spareTypeRequest.getName());
        logger.info("[CREATED] SpareType "+spareType.getName()+" Created.");
        return spareTypeRepository.save(spareType);
    }

}
