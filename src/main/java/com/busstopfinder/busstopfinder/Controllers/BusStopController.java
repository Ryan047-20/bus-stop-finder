package com.busstopfinder.busstopfinder.Controllers;

import com.busstopfinder.busstopfinder.model.BusStop;
import com.busstopfinder.busstopfinder.Service.BusStopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bus-stops")
public class BusStopController {

    @Autowired
    private BusStopService busStopService;

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveBusStop(@RequestBody BusStop busStop) {
        try {
            BusStop saved = busStopService.saveBusStop(busStop);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllBusStops() {
        List<BusStop> busStops = busStopService.getAllBusStops();
        return new ResponseEntity<>(busStops, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBusStopById(@PathVariable Long id) {
        try {
            BusStop busStop = busStopService.getBusStopById(id);
            return new ResponseEntity<>(busStop, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
