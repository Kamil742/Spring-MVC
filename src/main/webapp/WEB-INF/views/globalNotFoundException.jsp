<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #F2F2F2;
        }

        .error-container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            background-color: #FFFFFF;
            border: 1px solid #CCCCCC;
            border-radius: 5px;
            text-align: center;
        }

        h1 {
            margin-top: 0;
            color: #FF0000;
        }

        h2 {
            color: #666666;
        }
    </style>
</head>
<body>
    <div class="error-container">
        <h1>Oops....</h1>
        <h1>${message}</h1>
        <h2>You can try with a valid Id</h2>
    </div>
</body>
</html>
