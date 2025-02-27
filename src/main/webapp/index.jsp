<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<head>
<title>Amazin</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<header>
		<h1 class="header">Amazin.com</h1>
		<h2 class="centered">
			<s:text name="welcome-to-the"/> <em><s:text name="smallest"/></em> <s:text name="online-shop-word"/>
		</h2>
		<h3><s:a action="language"><s:text name="change-language"/></s:a></h3>
	</header>
	<nav>
		<ul>
			<li><a href="#"><s:text name="start"/></a></li>
			<li><a href="http://miw.uniovi.es"><s:text name="about"/></a></li>
			<li><a href="mailto:dd@email.com"><s:text name="contact"/></a></li>
		</ul>
	</nav>
	<section>
		<article>
			<label class="mytitle"><s:text name="introduce-login"/></label><br />
			<div style="color: red;">
				<s:property value="#request.mymessage" />
				<br />
			</div>
			<s:form action="login"  >
				<s:textfield name="loginInfo.login" key="login" />
				<s:password name="loginInfo.password" key="password" />
				<s:textfield name="loginInfo.captcha" key="introduce-captcha" />
				<s:submit />
			</s:form>
			<label class="mytitle"><s:text name="create-account"/></label>
			<s:a action="register-form"><s:text name="here"/></s:a>
		</article>
	</section>
	<footer>

		<strong> <s:text name="master"/></strong><br /> <em><s:text name="university"/> </em>
	</footer>
</body>
