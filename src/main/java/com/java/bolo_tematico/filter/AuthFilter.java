package com.java.bolo_tematico.filter;

import com.java.bolo_tematico.model.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        //Libera páginas públicas
        if (uri.endsWith("login") || uri.endsWith("login.html")) {
            chain.doFilter(request, response);
            return;
        }
        HttpSession session = req.getSession(false);
        User usuario = (session != null) ? (User) session.getAttribute("user") :
                null;
        if (usuario == null) {
            resp.sendRedirect("login.html");
            return;
        }
        // RESTRIÇÃO POR PAPEL
        String role = usuario.getRole().name(); // "USER" ou "ADMIN"

        if ("USER".equals(role)) {
            // Usuário comum só pode acessar a página de listar bolos e logout
            if (uri.contains("listarBolos") || uri.contains("bolos/list") || uri.contains("auth/me") || uri.contains("logout")) {
                chain.doFilter(request, response);
            } else {
                // Força redirecionamento para página de bolos
                resp.sendRedirect("listarBolos.html");
            }
        } else if ("ADMIN".equals(role)) {
            // Admin tem acesso a tudo
            chain.doFilter(request, response);
        } else {
            // Papel desconhecido
            resp.sendRedirect("login.html");
        }
    }
}

