<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload File</title>
</head>
<div align="center">
    <h1>Please upload files...</h1>
    <form method="post" action="/course/doUpload" enctype="multipart/form-data">
        <input type="file" name="imageFile"/>
        <input type="submit"/>
    </form>
</div>
</body>
</html>