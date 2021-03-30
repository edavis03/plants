package plantappTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import plantapp.PlantAppApplication;
import plantapp.PlantController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest(classes = {PlantAppApplication.class})
@AutoConfigureMockMvc
class IntegrationTests {

    @Autowired
    private PlantController plantController;

    @Test
    void controllerGivesPlantsFromDB() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(plantController).build();
        MvcResult result = mockMvc.perform(get("/plants")).andReturn();

        assertEquals("[{\"id\":1,\"name\":\"snap\"},{\"id\":2,\"name\":\"crackle\"},{\"id\":3,\"name\":\"pop\"}]", result.getResponse().getContentAsString());
    }
}

