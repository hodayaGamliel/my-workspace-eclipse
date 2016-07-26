<html>
    <head>
        <title>Throwing an Exception</title>
    </head>

    <body>
        <title>Throwing an Exception</title>
        <%
        try 
        {    
       		throw new ArithmeticException("Math Exception!");
        } 
        catch(ArithmeticException e) 
        {
            out.println("Exception message: " + e);
        }
        %>
    </body>
</html>

          