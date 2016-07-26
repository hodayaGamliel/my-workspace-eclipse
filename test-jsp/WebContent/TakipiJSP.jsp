<%@page import="java.io.IOException"%>
<html>
    <head>
        <title>Throwing an Exception</title>
    </head>

    <body>
        <title>Throwing an Exception</title>
        <%
        
        try 
        {    
       		throw new IOException("IO Exception!");
        } 
        catch(IOException e) 
        {
            out.println("Exception message: " + e);
        }
        %>
    </body>
</html>

