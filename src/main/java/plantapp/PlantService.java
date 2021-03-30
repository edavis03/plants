package plantapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plantapp.Entities.Plant;

import java.util.List;

@Service
public class PlantService {

    @Autowired
    private PlantRepository plantRepository;

    public PlantService(PlantRepository repository) {
        this.plantRepository = repository;
    }

    public List<Plant> getAll() {
        return this.plantRepository.findAll();
    }
}
