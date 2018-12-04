package com.citystartravel.backend.entity.bus;


import com.citystartravel.backend.payload.response.PagedResponse;
import com.citystartravel.backend.security.UserPrincipal;
import com.citystartravel.backend.util.AppConstants;
import com.citystartravel.backend.util.UtilityMethods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    private static final Logger logger = LoggerFactory.getLogger(BusService.class);

    private UtilityMethods<Bus> utilityMethods = new UtilityMethods<>();

    public PagedResponse<Bus> getAllBuses(UserPrincipal currentUser, int page, int size) {
        return utilityMethods.getAll(busRepository, currentUser, page, size);
    }

    public Bus getBusById(Long busId, UserPrincipal currentUser) {
        return utilityMethods.getById(busRepository,currentUser,busId,"Bus");
    }

    public Bus createBus(BusRequest busRequest) {
        Bus bus = new Bus();
        bus.setName(busRequest.getName());
        bus.setPlatesLetters(busRequest.getPlatesLetters());
        bus.setPlatesNumbers(busRequest.getPlatesNumbers());
        bus.setBusCondition(AppConstants.CONDTION_OK);
        bus.setStatus(AppConstants.CONDTION_OK);

        return busRepository.save(bus);
    }

    public Bus updateBus(Bus bus) {
        return utilityMethods.update(busRepository, bus);
    }

    public void deleteBus(Bus bus) {
        utilityMethods.delete(busRepository, bus);
    }

}
