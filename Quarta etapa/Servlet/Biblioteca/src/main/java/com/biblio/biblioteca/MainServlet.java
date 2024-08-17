package com.biblio.biblioteca;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "mainServlet", value = "/main-servlet")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();
        writer.print("Meus livros");

        writer.print("<ul>");

        writer.print("<li>");
        writer.print("Livro de Java Web");
        writer.print("</li>");

        writer.print("<li>");
        writer.print("Livro de Android");
        writer.print("</li>");

        writer.print("</ul>");
    }
}
