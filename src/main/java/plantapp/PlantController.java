package plantapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import plantapp.Entities.Plant;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlantController {

//    @RequestMapping("/plants")
//    public ResponseEntity<List<Plant>> getPlants() {
//        return new ResponseEntity<List<Plant>>(new ArrayList<Plant>(), HttpStatus.OK);
//    }
}
