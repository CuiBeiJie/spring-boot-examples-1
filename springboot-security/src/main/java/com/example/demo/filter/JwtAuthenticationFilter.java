//package com.example.demo.filter;
//
//import com.example.demo.util.JwtUtils;
//import io.jsonwebtoken.Jwts;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//
///**
// * Created with IntelliJ IDEA.
// * Date: 2017/11/16
// * Time: 11:11
// * Email: hyf_spring@163.com
// *
// * @author huyunfan
// */
//public class JwtAuthenticationFilter extends BasicAuthenticationFilter {
//
//    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
//        super(authenticationManager);
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//        String header = request.getHeader("Authorization");
//
//        if (header == null || !header.startsWith(JwtUtils.getAuthorizationHeaderPrefix())) {
//            chain.doFilter(request, response);
//            return;
//        }
//
//        UsernamePasswordAuthenticationToken authenticationToken = getUsernamePasswordAuthenticationToken(header);
//
//        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//        chain.doFilter(request, response);
//    }
//
//    private UsernamePasswordAuthenticationToken getUsernamePasswordAuthenticationToken(String token) {
//        String user = Jwts.parser()
//                .setSigningKey("PrivateSecret")
//                .parseClaimsJws(token.replace(JwtUtils.getAuthorizationHeaderPrefix(), ""))
//                .getBody()
//                .getSubject();
//
//        if (null != user) {
//            return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
//        }
//
//        return null;
//    }
//}
