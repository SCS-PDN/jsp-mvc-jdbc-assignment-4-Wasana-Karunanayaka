<%-- Shows all available courses for the logged-in student --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Available Courses</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f0f0f0; }
        .container { width: 700px; margin: 50px auto; background: white;
                     padding: 30px; border-radius: 8px; box-shadow: 0 2px 8px rgba(0,0,0,0.2); }
        h2 { color: #333; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th { background: #4CAF50; color: white; padding: 10px; text-align: left; }
        td { padding: 10px; border-bottom: 1px solid #ddd; }
        tr:hover { background: #f5f5f5; }
        button { background: #4CAF50; color: white; border: none;
                 padding: 6px 14px; border-radius: 4px; cursor: pointer; }
        button:hover { background: #45a049; }
        .logout { float: right; color: #888; }
        .logout a { color: #e74c3c; text-decoration: none; }
    </style>
</head>
<body>
    <div class="container">
        <span class="logout"><a href="logout">Logout</a></span>
        <h2>Available Courses</h2>
        <p>Welcome, <strong>${student.name}</strong>! Select a course to register.</p>

        <table>
            <tr>
                <th>Course Name</th>
                <th>Instructor</th>
                <th>Credits</th>
                <th>Action</th>
            </tr>
            <%-- loop through courses from the model --%>
            <c:forEach var="course" items="${courses}">
                <tr>
                    <td>${course.name}</td>
                    <td>${course.instructor}</td>
                    <td>${course.credits}</td>
                    <td>
                        <form action="register/${course.courseId}" method="post">
                            <button type="submit">Register</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>