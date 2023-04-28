package org.example;

import org.example.calculator.Calculator;
import org.example.calculator.value.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(CalculatorServlet.class);
//    private ServletConfig servletConfig;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("service");

        int operand1 = Integer.parseInt(request.getParameter("operand1"));
        String operator = request.getParameter("operator");
        int operand2 = Integer.parseInt(request.getParameter("operand2"));

        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

        PrintWriter writer = response.getWriter();
        writer.println(result);
    }

//    @Override
//    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
//        log.info("service");
//
//        int operand1 = Integer.parseInt(request.getParameter("operand1"));
//        String operator = request.getParameter("operator");
//        int operand2 = Integer.parseInt(request.getParameter("operand2"));
//
//        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
//
//        PrintWriter writer = response.getWriter();
//        writer.println(result);
//    }

    // Servlet 인터페이스를 구현하는 것이 아닌,
    // GenericServlet 추상 클래스를 구현하면
    // 아래의 메서드들은 필요할 때만 오버라이드 해줘도 된다.

//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        log.info("init");
//        this.servletConfig = config;
//    }

//    @Override
//    public void destroy() {
//
//    }
//
//    @Override
//    public ServletConfig getServletConfig() {
//        return this.servletConfig;
//    }
//
//
//
//    @Override
//    public String getServletInfo() {
//        return null;
//    }
}
