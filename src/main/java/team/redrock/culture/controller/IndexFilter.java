package team.redrock.culture.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import team.redrock.culture.entity.Student;
import team.redrock.culture.entity.User;
import team.redrock.culture.domain.UserToken;
import team.redrock.culture.service.StudentService;
import team.redrock.culture.service.UserService;
import team.redrock.culture.util.WeChatUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "filter" , urlPatterns = "/index")
public class IndexFilter implements Filter {

    @Value("${appID}")
    private String appID;

    @Value("${appSecret}")
    private String appSecret;

    @Value("${RedirectURL}")
    private String redirectURL;

    @Value("${scope}")
    private String scope;

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        if (request.getParameter("code")==null){
            response.sendRedirect(WeChatUtil.getUrl(appID,redirectURL,scope));
        }else {
            // 如何code不为空 ，通过传来的code，来得到用户的access_token（与最初的不同）
            UserToken userToken = WeChatUtil.getAccess_token(appID, request.getParameter("code"), appSecret);
            // 通过token，向微信获得用户信息
            User user=WeChatUtil.getUserInfo(userToken.getAccess_token(),userToken.getOpenid());
            if (userService.selectNicknameByopenid(user.getOpenid())==null) {
                Student student = studentService.selectOneByopenid(user.getOpenid());
                user.setCollege(student.getCollege());
                user.setLeftTimes(5);
                user.setPersonalAmount(0);
                userService.insertOne(user);
            }

        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
