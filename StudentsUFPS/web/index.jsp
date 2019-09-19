<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/style.css" rel="stylesheet">
        <title>Insert title here</title>
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <meta name="google-signin-client_id" content="923881149215-eqacititaiolmnug083n3g59o5qsn6i6.apps.googleusercontent.com">
    </head>
    <body>
        <script type="text/javascript">
            function onSignIn(googleUser) {
                // window.location.href='success.jsp';
                var profile = googleUser.getBasicProfile();
                var email = profile.getEmail();
                console.log("correo: " + email);
                document.getElementById("emaill").value = email;
                document.getElementById("formulario").submit();

            }
        </script>
        <div class="user_type">
            <div class="select_type">
                <div class="g-signin2" data-onsuccess="onSignIn" id="myP"></div>
                <form name="data" action="./loginGoogle.do" method="POST" style="display:none" id="formulario">
                    <input type="hidden" name="email" id="emaill"/>
                    <input type="submit" value="submit" id="subas"/>
                </form>
            </div>
        </div>
        <div class="google_login"></div>
        <div class="workspace">
            <h1 class="uscore">UScore</h1>
        </div>
    <footer>
        UFPS Cúcuta <br> 2019 © All Rights Reserved. <br> Visualización de calificaciones en la Universidad

    </footer>
</body>
</html>