package plantapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import plantapp.Entities.Plant;
import java.util.List;

@RestController
public class PlantController {
    @Autowired
    private PlantService plantService;

    public PlantController(PlantService service){
        this.plantService = service;
    }

    @RequestMapping("/plants")
    public ResponseEntity<List<Plant>> getPlants() {
        List<Plant> plantList = plantService.getAll();
        return new ResponseEntity<List<Plant>>(plantList, HttpStatus.OK);
    }
}
