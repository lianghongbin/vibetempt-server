package com.ruoyi.web.controller.system;

import com.ruoyi.RuoYiApplication;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import com.ruoyi.framework.web.service.PermissionService;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mockStatic;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = RuoYiApplication.class)
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles("dev")
@WithMockUser(authorities = "system:role:list")
public class SysRoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean(name = "ss")
    private PermissionService permissionService;

    @Test
    public void testGetRoleList() throws Exception {
        when(permissionService.hasPermi(org.mockito.ArgumentMatchers.anyString())).thenReturn(true);
        
        // Mock SecurityUtils in each test method
        try (var securityUtilsMock = mockStatic(SecurityUtils.class)) {
            securityUtilsMock.when(SecurityUtils::getUserId).thenReturn(1L);
            
            LoginUser mockLoginUser = new LoginUser();
            mockLoginUser.setUserId(1L);
            
            SysUser mockSysUser = new SysUser();
            mockSysUser.setUserId(1L);
            mockSysUser.setUserName("admin");
            mockLoginUser.setUser(mockSysUser);
            
            securityUtilsMock.when(SecurityUtils::getLoginUser).thenReturn(mockLoginUser);
            
            mockMvc.perform(get("/system/role/list"))
                    .andExpect(status().isOk());
        }
    }

    @Test
    public void testGetRoleInfo() throws Exception {
        when(permissionService.hasPermi(org.mockito.ArgumentMatchers.anyString())).thenReturn(true);
        
        // Mock SecurityUtils in each test method
        try (var securityUtilsMock = mockStatic(SecurityUtils.class)) {
            securityUtilsMock.when(SecurityUtils::getUserId).thenReturn(1L);
            
            LoginUser mockLoginUser = new LoginUser();
            mockLoginUser.setUserId(1L);
            
            SysUser mockSysUser = new SysUser();
            mockSysUser.setUserId(1L);
            mockSysUser.setUserName("admin");
            mockLoginUser.setUser(mockSysUser);
            
            securityUtilsMock.when(SecurityUtils::getLoginUser).thenReturn(mockLoginUser);
            
            Long id = 1L;
            mockMvc.perform(get("/system/role/{id}", id))
                    .andExpect(status().isOk());
        }
    }
} 