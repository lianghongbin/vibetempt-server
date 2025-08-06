package com.ruoyi.web.controller.vibetempt;

import com.ruoyi.RuoYiApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import com.ruoyi.framework.web.service.PermissionService;
import static org.mockito.Mockito.when;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = RuoYiApplication.class)
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles("dev")
@WithMockUser(authorities = "system:conversation:list")
public class AiConversationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean(name = "ss")
    private PermissionService permissionService;

    @Test
    public void testGetConversationList() throws Exception {
        when(permissionService.hasPermi(org.mockito.ArgumentMatchers.anyString())).thenReturn(true);
        mockMvc.perform(get("/vibetempt/conversation/list"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetConversationInfo() throws Exception {
        when(permissionService.hasPermi(org.mockito.ArgumentMatchers.anyString())).thenReturn(true);
        Long id = 1L;
        mockMvc.perform(get("/vibetempt/conversation/{id}", id))
                .andExpect(status().isOk());
    }
} 