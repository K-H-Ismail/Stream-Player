<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload Fichier</title>
</head>
<body>
        <form method="post" enctype="multipart/form-data" action="../Servlet">
        	<p>
				<input type="text" placeholder="description" name="description" />
            </p>
            <p> 
                <input type="file" id="fichier" name="fichier" />
  			</p>
                <input type="submit" value="Envoyer" />
                <input type="hidden" name="op" value="upload">
       
        </form>
</body>
</html>