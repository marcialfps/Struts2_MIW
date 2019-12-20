<!DOCTYPE html >
<%@ page contentType="text/html; charset=iso-8859-1"
	pageEncoding="iso-8859-1" language="java"
	import="java.util.*, com.miw.model.Book,com.miw.presentation.book.*"
	errorPage=""%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false"%>

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
		<article>
			<s:if test="%{#session.shoppingcart == null}">
				
				<p><s:text name="empty-shopping"/></p>
			</s:if>
			<s:else>
				<table>
					<caption><s:text name="your-shoppingcart"/></caption>
					<thead>
						<tr>
							<th><s:text name="title"/></th>
							<th><s:text name="quantity"/></th>
						</tr>
					</thead>
					<tbody>
						
						
							<s:iterator value="%{#session.shoppingcart.list}">
								<tr>
									<td><s:property value="key" /></td>
									<td><s:property value="value" /></td>
								</tr>
							</s:iterator>
						
					</tbody>
				</table>
			</s:else>
			<s:a action="show-books"><s:text name="back"/></s:a>
		</article>
	</section>
	<footer>
		<strong> <s:text name="master"/></strong><br /> <em><s:text name="university"/> </em>
	</footer>
</body>