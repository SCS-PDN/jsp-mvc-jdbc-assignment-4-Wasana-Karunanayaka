<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Result</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f0f0f0; }
        .container { width: 450px; margin: 100px auto; background: white;
                     padding: 30px; border-radius: 8px; box-shadow: 0 2px 8px rgba(0,0,0,0.2); }
        h2 { color: #333; text-align: center; }
        .message { text-align: center; font-size: 18px;
                   color: #4CAF50; margin: 20px 0; }
        .back-btn { display: block; text-align: center; margin-top: 20px;
                    background: #4CAF50; color: white; padding: 10px;
                    border-radius: 4px; text-decoration: none; }
        .back-btn:hover { background: #45a049; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Registration Result</h2>

        <!-- Display success or already-registered message -->
        <p class="message">${message}</p>

        <p style="text-align:center">Student: <strong>${student.name}</strong></p>

        <!-- Link back to courses page -->
        <a href="${pageContext.request.contextPath}/courses" class="back-btn">Back to Courses</a>
    </div>
</body>
</html>