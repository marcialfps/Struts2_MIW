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
	</header>
	<nav>
		<ul>
			<li><a href="#"><s:text name="start"/></a></li>
			<li><a href="http://miw.uniovi.es"><s:text name="about"/></a></li>
			<li><a href="mailto:dd@email.com"><s:text name="contact"/></a></li>
		</ul>
	</nav>
	<section>
		<article id="a01">
			<label class="mytitle"><s:text name="choose-option"/></label><br /> 
			<a href="show-books.action"><s:text name="show-catalog"/></a><br /> 
			<a href="show-special-offer.action"><s:text name="show-offers"/></a> 
		</article>
	</section>
	<footer>
		<strong> <s:text name="master"/></strong><br /> <em><s:text name="university"/> </em><br/>
			<s:text name="visits"/>	<s:property value="%{#application.counter}" />
			
	</footer>
</body>
