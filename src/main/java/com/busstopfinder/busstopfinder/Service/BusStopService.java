package com.busstopfinder.busstopfinder.Service;

import com.busstopfinder.busstopfinder.model.BusStop;
import com.busstopfinder.busstopfinder.model.Location;
import com.busstopfinder.busstopfinder.model.Province;
import com.busstopfinder.busstopfinder.repositories.ProvinceRepository;
import com.busstopfinder.busstopfinder.repositories.BusStopRepository;
import com.busstopfinder.busstopfinder.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BusStopService {

    @Autowired
    private BusStopRepository busStopRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private ProvinceRepository provinceRepository;

    public BusStop saveBusStop(BusStop busStop) {
        if (busStopRepository.existsByName(busStop.getName())) {
            throw new RuntimeException("Bus stop with this name already exists!");
        }
         // Load the full location object first
           Location location = locationRepository.findById(busStop.getLocation().getId())
            .orElseThrow(() -> new RuntimeException("Location not found!"));
    
           // Load the full province inside the location
            Province province = provinceRepository.findById(location.getProvince().getId())
            .orElseThrow(() -> new RuntimeException("Province not found!"));
            location.setProvince(province);
    
               busStop.setLocation(location);
              return busStopRepository.save(busStop);
    }

    public List<BusStop> getAllBusStops() {
        return busStopRepository.findAll();
    }

    public BusStop getBusStopById(Long id) {
        return busStopRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bus stop not found!"));
    }

}
