<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <style>
            
            input[type=submit] {
    color:#08233e;
    font:2.4em Futura, ‘Century Gothic’, AppleGothic, sans-serif;
    font-size:70%;
    padding:10px;
    background:url(overlay.png) repeat-x center #ffcc00;
    background-color:rgba(255,204,0,1);
    border:1px solid #ffcc00;
    -moz-border-radius:10px;
    -webkit-border-radius:10px;
    border-radius:10px;
    border-bottom:1px solid #9f9f9f;
    -moz-box-shadow:inset 0 1px 0 rgba(255,255,255,0.5);
    -webkit-box-shadow:inset 0 1px 0 rgba(255,255,255,0.5);
    box-shadow:inset 0 1px 0 rgba(255,255,255,0.5);
    cursor:pointer;
}
input[type=submit]:hover {
    background-color:rgba(255,204,0,0.8);
}

            
            .file {
  position: relative;
}
.file label {
  background: #39D2B4;
  padding: 5px 20px;
  color: #fff;
  font-weight: bold;
  font-size: .9em;
  transition: all .4s;
}
.file input {
  position: absolute;
  display: inline-block;
  left: 0;
  top: 0;
  opacity: 0.01;
  cursor: pointer;
}
.file input:hover + label,
.file input:focus + label {
  background: #34495E;
  color: #39D2B4;
}



/* Useless styles, just for demo styles */

body {
  font-family: "Open sans", "Segoe UI", "Segoe WP", Helvetica, Arial, sans-serif;
  color: #7F8C9A;
  background: #FCFDFD;
}
h1, h4 {
  margin-bottom: 5px;
  font-weight: normal;
  text-align: center;
  color:#aaa;
}
h1{
  font-size: 50px;
}
h4 {
  margin: 5px 0 2em;
  color: #1ABC9C;
}
form {
  width: 225px;
  margin: 0 auto;
  text-align:center;
}
h4 + P {
  text-align: center;
}
.txtcenter {
  margin-top: 4em;
  font-size: .9em;
  text-align: center;
  color: #aaa;
}
.copy {
 margin-top: 2em; 
}
.copy a {
 text-decoration: none;
 color: #1ABC9C;
}

        </style>
        
        <title>Index Page</title>
    </head>
    <body>
    <center>
        <h1>CV Viewer</h1>
        <br>
        <h4>Please upload your cv at here. (Support PDF and DOCX file)</h4>
        <br>
        <form action="UploadProcess" method="POST" enctype="multipart/form-data">
            <input type="file" name="file"/>
            <br><br>
            <input type="submit" value="Upload your CV"/>
        </form>
    </center>
</body>
</html>
