package com.citystartravel.backend.entity.spare;

import com.citystartravel.backend.payload.response.PagedResponse;
import com.citystartravel.backend.security.UserPrincipal;
import com.citystartravel.backend.util.UtilityMethods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpareService {
    @Autowired
    private SpareRepository spareRepository;

    private static final Logger logger = LoggerFactory.getLogger(SpareService.class);

    private UtilityMethods<Spare> utilityMethods = new UtilityMethods<>();

    public PagedResponse<Spare> getAllSpares(UserPrincipal currentUser, int page, int size) {
        return utilityMethods.getAll(spareRepository,currentUser,page,size);
    }

    public Spare getSpareById(Long spareId, UserPrincipal currentUser) {
        return utilityMethods.getById(spareRepository, currentUser, spareId,"Spare");
    }

    public List<Spare> createSpare(SpareRequest spareRequest) {

        List<Spare> spares = new ArrayList<>();
        for(int i=0 ; i<spareRequest.getQuantity() ; i++) {
            Spare spare = new Spare(spareRequest.getSpareType());
            spareRepository.save(spare);
            logger.info("[CREATED] Spare "+spare.getName()+" Created.");
            spares.add(spare);
        }
        logger.info("[CREATED] "+spareRequest.getQuantity()+
                " new Spares of type "+spareRequest.getSpareType().getName()+" Created.");
        return spares;
    }
}
