package com.busstopfinder.busstopfinder.Service;

import com.busstopfinder.busstopfinder.model.Location;
import com.busstopfinder.busstopfinder.model.Province;
import com.busstopfinder.busstopfinder.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.busstopfinder.busstopfinder.repositories.ProvinceRepository;
import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private ProvinceRepository provinceRepository;

    public Location saveLocation(Location location) {
        if (locationRepository.existsByStreetAndSector(location.getStreet(), location.getSector())) {
            throw new RuntimeException("Location with this street and sector already exists!");
        }
        // Load the full province object first
        Province province = provinceRepository.findById(location.getProvince().getId())
            .orElseThrow(() -> new RuntimeException("Province not found!"));
           location.setProvince(province);
    
         return locationRepository.save(location);
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location getLocationById(Long id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found!"));
    }
}
