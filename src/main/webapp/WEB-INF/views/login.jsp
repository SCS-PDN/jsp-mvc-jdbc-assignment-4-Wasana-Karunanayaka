<%-- Login page for the university registration system --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>University Login</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f0f0f0; }
        .container { width: 350px; margin: 100px auto; background: white;
                     padding: 30px; border-radius: 8px; box-shadow: 0 2px 8px rgba(0,0,0,0.2); }
        h2 { text-align: center; color: #333; }
        input[type=text], input[type=password] {
            width: 100%; padding: 10px; margin: 8px 0;
            border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; }
        button { width: 100%; padding: 10px; background: #4CAF50;
                 color: white; border: none; border-radius: 4px; cursor: pointer; }
        button:hover { background: #45a049; }
        .error { color: red; text-align: center; margin-top: 10px; }
    </style>
</head>
<body>
    <div class="container">
        <h2>University Login</h2>

        <form action="login" method="post">
            <label>Email:</label>
            <input type="text" name="email" placeholder="Enter your email" required />

            <label>Password:</label>
            <input type="password" name="password" placeholder="Enter your password" required />

            <button type="submit">Login</button>
        </form>

        <%-- show error if login failed --%>
        <% if (request.getAttribute("error") != null) { %>
            <p class="error">${error}</p>
        <% } %>
    </div>
</body>
</html>