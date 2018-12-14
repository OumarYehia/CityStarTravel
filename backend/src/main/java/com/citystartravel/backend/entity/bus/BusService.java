package com.citystartravel.backend.entity.bus;


import com.citystartravel.backend.payload.response.PagedResponse;
import com.citystartravel.backend.security.CurrentUser;
import com.citystartravel.backend.security.UserPrincipal;
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

    public Bus createBus(BusRequest busRequest, @CurrentUser UserPrincipal currentUser) {
        Bus bus = new Bus(busRequest.getName(),
                          busRequest.getPlatesLetters(),
                          busRequest.getPlatesNumbers(),
                          busRequest.getKm());
        String eventLog = utilityMethods.generateEntityCreationMessage("Bus",bus.getPlatesNumbers(),currentUser);
        bus.addBusEvent(new BusEvent(eventLog));
        logger.info(eventLog);
        return busRepository.save(bus);
    }

    public Bus updateBus(Bus bus) {
        return utilityMethods.update(busRepository, bus);
    }

    public void deleteBus(Bus bus) {
        utilityMethods.delete(busRepository, bus);
    }

}
