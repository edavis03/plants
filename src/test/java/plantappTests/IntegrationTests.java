package plantappTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.DependsOn;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import plantapp.PlantController;
import plantapp.PlantService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest(classes = {PlantController.class, PlantService.class})
@AutoConfigureMockMvc
class IntegrationTests {

    @Autowired
    private PlantController plantController;

    @Test
    void controllerGivesPlantsFromDB() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(plantController).build();
        System.out.println(plantController);
        MvcResult result = mockMvc.perform(get("/plants")).andReturn();

        assertEquals("{\"name\":\"snap\",\"name\":\"crackle\",\"name:\":\"pop\"}", result.getResponse().getContentAsString());
    }
}

