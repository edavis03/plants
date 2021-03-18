package plantappTests;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import plantapp.Entities.Plant;
import plantapp.PlantController;
import plantapp.PlantService;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
public class PlantControllerTests {

    private PlantService mockPlantService = Mockito.mock(PlantService.class);

    @Autowired
    private MockMvc mockMvc = MockMvcBuilders.standaloneSetup(new PlantController(mockPlantService)).build();;

    @Test
    void getPlants() throws Exception {
        ArrayList<Plant> plantsToReturn = new ArrayList<Plant>();
        plantsToReturn.add(new Plant("ivy"));
        plantsToReturn.add(new Plant("fir tree"));
        when(mockPlantService.getAll()).thenReturn(plantsToReturn);

        MvcResult result = this.mockMvc.perform(get("/plants"))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals("[{\"name\":\"ivy\"},{\"name\":\"fir tree\"}]", result.getResponse().getContentAsString());
    }
}
