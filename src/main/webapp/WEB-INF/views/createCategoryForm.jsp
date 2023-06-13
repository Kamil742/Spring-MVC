<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Category Management</title>
    <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #778899;
                margin: 0;
                padding: 0;
                display: flex;
                align-items: center;
                justify-content: center;
            }

            label {
                margin: 5px;
                text-align: start;
            }

            .section {
                background-color: #778899;
                padding: 20px;
                border-radius: 5px;
                text-align: center;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
                width: 350px;
                color: #fff;
            }

            .link-boxes {
                display: flex;
                flex-direction: column;
                margin-bottom: 20px;
            }

            .action-button {
                display: block;
                background-color: #F5F5F5;
                color: #333;
                border: none;
                padding: 10px;
                border-radius: 4px;
                cursor: pointer;
                transition: background-color 0.3s;
                text-decoration: none;
                width: 100%;
                margin-bottom: 5px;
            }

            .action-button:last-child {
                margin-right: 0;
            }

            .action-button:hover {
                background-color: #E8E8E8;
            }

            .cancel-button {
                display: block;
                background-color: #F5F5F5;
                color: #333;
                border: none;
                padding: 10px;
                border-radius: 4px;
                cursor: pointer;
                margin-bottom: 10px;
                width: 100%;
                transition: background-color 0.3s;
                text-decoration: none;
            }

           .separator {
               height: 4px;
               width: 106%;
               background-color: #fff;
               margin-top: 20px;
               margin-bottom: 15px;
           }

           .cancel-button:hover {
               background-color: #E8E8E8;
           }
           input:invalid {
               border-color: red;
           }

           input:invalid:focus {
               outline-color: red;
           }
        </style>
</head>
<body>
    <div class="section">
        <h1>Category</h1>
        <div><h3>Add Category</h3></div>
        <form:form action="/category/add_category">

            <div class="link-boxes" style="flex-direction:column">
            <label for ="categoryName"> Category name</label>
                <input id="categoryName"type="text" name="categoryName" class="action-button" />
            </div>
            <input type="submit" value="Add Category" class="action-button" />
        </form:form>

<div class="separator"></div>
                <div><h3>Edit Category</h3></div>
        <form:form method="GET" action="/category/editCategory">
                    <div class="link-boxes">
                        <label for="categoryId">Category ID</label>
                        <input id="categoryId" type="text" name="categoryId" class="action-button" placeholder="Enter Valid Category ID" required/>
                    </div>

                    <input type="submit" value="Edit Category" class="action-button" />
                </form:form>

            <div class="separator"></div>
                    <div><h3>Delete Category</h3></div>
            <div>
                <form method="GET" action="/category/delete">
                    <div class="link-boxes">
                        <label for="categoryId">Category ID</label>
                        <input id="categoryId" type="text" name="categoryId" class="action-button" placeholder="Enter Valid Category ID" />
                    </div>
                    <input type="submit" value="Delete Category" class="action-button" />
                </form>
            </div>

            <div class="separator"></div>
            <div><h3>Show All Categories</h3></div>
                <div>
                    <form method="GET" action="/category/allCategories">
                        <input type="submit" value="Show All Categories" class="action-button" />
                    </form>
                </div>

            <div class="separator"></div>
        <a href="/webmvc/dashboard" class="cancel-button">Cancel</a>
    </div>

</body>
</html>
