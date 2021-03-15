package plantapp;

import org.springframework.stereotype.Service;
import plantapp.Entities.Plant;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlantService {
    public List<Plant> getAll() {
        return new ArrayList<Plant>();
    }

}
