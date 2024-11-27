package com.example.practice6;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Stack;

public class CalcServlet extends HttpServlet
{
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String exp = (String) session.getAttribute("exp");

        if(exp == null)
        {
            exp="";
        }
        String input=req.getParameter("button");
        String operator=req.getParameter("operator");
        String clear=req.getParameter("clear");
        String equal=req.getParameter("calculate");

        if(clear!=null && clear.equals("clear")) {
            exp="";
        }

       else if(equal != null && equal.equals("equal")){
           double result = evaluate(exp);
           exp = String.valueOf(result);
        }

        else if(input != null){
            exp=exp+input;
        }

        else if(operator != null){
            exp=exp+operator;
        }

        session.setAttribute("exp",exp);
        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        rd.forward(req, resp);
    }


    public double evaluate(String expression)
    {
        Stack<Double> numbers=new Stack<>();
        Stack<Character> operators=new Stack<>();

        int length = expression.length();
        for (int i=0;i<length;i++)
        {
            char ch = expression.charAt(i);
            if (ch == ' ') {
                continue;
            }
            if (Character.isDigit(ch)||ch == '.') {
                StringBuilder num=new StringBuilder();
                num.append(ch);
                while (i+1<length && (Character.isDigit(expression.charAt(i+1))||expression.charAt(i+1)=='.'))
                {
                    i++;
                    num.append(expression.charAt(i));
                }
                numbers.push(Double.parseDouble(num.toString()));
            }


            else if(ch == '+' || ch == '-' || ch == '*' || ch == '/')
            {
                while (!operators.isEmpty()&&precedence(ch,operators.peek()))
                {
                    numbers.push(operation(operators.pop(),numbers.pop(),numbers.pop()));
                }
                operators.push(ch);
            }
        }

        while (!operators.isEmpty()) {
            numbers.push(operation(operators.pop(),numbers.pop(),numbers.pop()));
        }

        return numbers.pop();
    }

    public static boolean precedence(char operator1, char operator2) {
        if ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-')) {
            return false;
        }
        return true;
    }

    public static double operation(char operator, double b, double a)
    {
        switch (operator)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                break;
        }
        return 0;
    }

}

