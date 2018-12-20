package com.citystartravel.backend.entity.spare;

import com.citystartravel.backend.entity.sparetype.SpareType;
import com.citystartravel.backend.entity.sparetype.SpareTypeService;
import com.citystartravel.backend.entity.voucher.item.VoucherItem;
import com.citystartravel.backend.entity.voucher.stockreceived.StockReceived;
import com.citystartravel.backend.payload.response.PagedResponse;
import com.citystartravel.backend.security.CurrentUser;
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

    @Autowired
    private SpareTypeService spareTypeService;

    private static final Logger logger = LoggerFactory.getLogger(SpareService.class);

    private UtilityMethods<Spare> utilityMethods = new UtilityMethods<>();

    public PagedResponse<Spare> getAllSpares(UserPrincipal currentUser, int page, int size) {
        return utilityMethods.getAll(spareRepository,currentUser,page,size);
    }

    public Spare getSpareById(Long spareId, @CurrentUser UserPrincipal currentUser) {
        return utilityMethods.getById(spareRepository, currentUser, spareId,"Spare");
    }

    public List<Spare> createSpare(SpareRequest spareRequest, @CurrentUser UserPrincipal currentUser) {

        List<Spare> spares = new ArrayList<>();
        SpareType spareType = spareTypeService.getSpareTypeById(spareRequest.getSpareTypeID(), currentUser);
        for(int i=0 ; i<spareRequest.getQuantity() ; i++) {
            Spare spare = new Spare(spareType);
            spare.setName(spareRequest.getName());
            spareRepository.save(spare);
            logger.info("[CREATED] Spare "+spare.getName()+" Created.");
            spares.add(spare);
        }
        logger.info("[CREATED] "+spareRequest.getQuantity()+
                " new Spares of type "+spareType.getName()+" Created.");
        return spares;
    }

    public List<Spare> createSparesFromVoucherItems(List<VoucherItem> voucherItems, @CurrentUser UserPrincipal currentUser) {
        List<Spare> spares = new ArrayList<>();
        for(VoucherItem voucherItem : voucherItems) {
            for(int i=0 ; i<voucherItem.getQuantity() ; i++) {
                if(voucherItem.getName() != null) {
                    Spare spare = new Spare(voucherItem.getName(), voucherItem.getSpareType(), (StockReceived) voucherItem.getVoucher());
                    spareRepository.save(spare);
                    spares.add(spare);
                }
                else {
                    StockReceived sr = (StockReceived) voucherItem.getVoucher();
                    String spareDefaultName = voucherItem.getSpareType().getName()+sr.getDate();
                    Spare spare = new Spare(spareDefaultName, voucherItem.getSpareType(), sr);
                    spareRepository.save(spare);
                    spares.add(spare);
                }
            }
        }

        return spares;
    }
}
