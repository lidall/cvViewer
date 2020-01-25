<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            
        body {
          font-family: "Open sans", "Segoe UI", "Segoe WP", Helvetica, Arial, sans-serif;
          color: #7F8C9A;
          background: #FCFDFD;
        }
        h1, h4 {
          margin-bottom: 5px;
          font-weight: normal;
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

        .txtcenter {
          margin-top: 4em;
        }
        .copy {
         margin-top: 2em; 
        }
        .copy a {
         text-decoration: none;
         color: #1ABC9C;
        }

        * {
          box-sizing: border-box;
        }

        /* Create three unequal columns that floats next to each other */
        .column {
          float: left;
          padding: 10px;
        }

        .left{
          width: 30%;
        }

        .middle {
          width: 70%;
        }

        /* Clear floats after the columns */
        .row:after {
          content: "";
          display: table;
          clear: both;
        }
        </style>
        <title>Upload Result Page</title>
    </head>
    <body>
        <h4><%=request.getAttribute("message")%></h4>
   
        <div class="row">
        <div class="column left"></div>
        <div class="column middle"><p class="txtcenter"><%=request.getAttribute("outstr")%></p></div>
        </div>

    <center>
    <h4>Want to upload more? Press <a href="${pageContext.request.contextPath}/index.jsp">return!</a></h4>
    </center>

    </body>
</html>
