package SpringWeb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.Test;



import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Test
@WebAppConfiguration
@ContextConfiguration(classes = GatewayAppWebConfig.class)

public class TestGetSongsController extends AbstractTestNGSpringContextTests {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;


    @Test
    public void getSongControllerTest() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

        this.mockMvc.perform(MockMvcRequestBuilders.get("/songs")
                                .param("artist", "van helen")
                                .param("name", "jump")
                                .param(String.valueOf(MediaType.ALL)))
                                .andExpect(status().isOk());




    }

    @Test
    public void getSongsTestWithoutParameters() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

        this.mockMvc.perform(MockMvcRequestBuilders.get("/songs")
                                                    .accept(MediaType.ALL))
                                                    .andExpect(status().is4xxClientError());
    }

    @Test
    public void getSongByArtistTest() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

        this.mockMvc.perform(MockMvcRequestBuilders.get("/songs")
                                                    .accept(MediaType.ALL))
                                                    .andExpect(status().isOk());

    }





    }

