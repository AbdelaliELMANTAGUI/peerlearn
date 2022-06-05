package com.peerlearn.peerlearn.security.filters.group;

import com.peerlearn.peerlearn.constants.GroupRole;
import com.peerlearn.peerlearn.constants.PathVariables;
import com.peerlearn.peerlearn.constants.RequestAttributes;
import com.peerlearn.peerlearn.modules.registration.RegistrationService;
import com.peerlearn.peerlearn.modules.registration.dtos.RegistrationGetDto;
import com.peerlearn.peerlearn.modules.user.dtos.UserTokenPayloadDto;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class IsGroupAdminFilter extends OncePerRequestFilter {

    final RegistrationService registrationService;

    public IsGroupAdminFilter(RegistrationService registrationService) {
        System.out.println("IsGroupAdminFilter()");
        this.registrationService = registrationService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Long uid = ((UserTokenPayloadDto) request.getAttribute(RequestAttributes.USER_DATA)).getId();
        Map pathVariables = (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        System.out.println("pv : "+pathVariables);
        Long gid = Long.parseLong((String) pathVariables.get(PathVariables.GROUP_PATH_VARIABLE));
        RegistrationGetDto reg = registrationService.findRegistrationByGroupIDAndUserID(gid,uid);
        if(!(reg.getRole() == GroupRole.ADMIN)) {
            throw new RuntimeException(" you are not an admin ");// TODO replace
        }
        filterChain.doFilter(request,response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return !request.getMethod().equals("PATCH");
    }
}
