package com.livethegame.RegisterViewerToBroadcast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.livethegame.RegisterViewerToBroadcast.common.BroadcastViewerResponseMapper;
import com.livethegame.RegisterViewerToBroadcast.controller.RegisterViewerToBroadcastRestController;
import com.livethegame.RegisterViewerToBroadcast.dto.BroadcastViewerRequest;
import com.livethegame.RegisterViewerToBroadcast.dto.BroadcastViewerResponse;
import com.livethegame.RegisterViewerToBroadcast.repository.UserRepository;
import com.livethegame.RegisterViewerToBroadcast.services.BroadcastService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Base64;

@WebMvcTest(RegisterViewerToBroadcastRestController.class)
@AutoConfigureMockMvc
class RegisterViewerToBroadcastApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private BroadcastService broadcastService;
    @MockBean
    private BroadcastViewerResponseMapper broadcastViewerResponseMapper;

    private static final String PASSWORD = "admin";
    private static final String Tournament = "admin";

    @Test
    public void testRegisterViewerToBroadcast_Success() throws Exception {
        BroadcastViewerRequest request = new BroadcastViewerRequest();
        BroadcastViewerResponse response = new BroadcastViewerResponse();
        response.setId(1L);
        mockMvc.perform(MockMvcRequestBuilders.post("/viewer-to-broadcast/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void testRegisterViewerToBroadcast_Business_BroadcastNotFound() throws Exception {

    }
    @Test
    public void testRegisterViewerToBroadcast_Business_UserNotFound() throws Exception {

    }


    @Test
    public void testCreateTournament_Business_WithoutAuthorization() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/viewer-to-broadcast/register")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    public void testCreateTournament_Business_testUnauthorizedAccess() throws Exception {
        Base64.Encoder encoder = Base64.getEncoder();
        String encodingParaUsuarioSinPermiso = encoder.encodeToString(("usuario" + ":" + "password").getBytes());
        mockMvc.perform(MockMvcRequestBuilders.get("/viewer-to-broadcast/register")
                        .header("Authorization", "Basic " + encodingParaUsuarioSinPermiso)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }
    private String asJsonString(Object obj) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

}
