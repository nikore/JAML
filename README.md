JAML
==========

A HTML Template lanage in pure java, why write html in text files when you can easily write it in self rendering java. 


Example
---------

To create a basic page you can do the following inside a normal class:

		List<CssInclude> firstCssInclude = Lists.<CssInclude>newArrayList();
		List<JavascriptInclude> firstJSInclude = Lists.<JavascriptInclude>newArrayList();

		firstCssInclude.add(new CssInclude("/test.css"));
		firstJSInclude.add(new JavascriptInclude("/test.js"));

		List<Attribute> attributeList = Lists.<Attribute>newArrayList();

		attributeList.add(new Attribute("xmlns", "http://www.w3.org/1999/xhtml"));
		attributeList.add(new Attribute("xml:lang","en-US"));
		attributeList.add(new Attribute("lang", "en-US"));


		Renderble page = new Renderables(
		        DocType.XHTML_10_STRICT,
		        html(
		                head(title("Test Page"),
		                    new Includes(firstJSInclude, firstCssInclude)
		                ),
		                body(
		                        div(
		                                text("test"),
		                                br(),
		                                text("test2")
		                        )
		                )
		        ).addAttributes(attributeList)
		)


Then you can call page.render() and feed it a PrintWriter or call page.renderString() and get a String for the page. The above example would output the following html:

		<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
		<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-gb" lang="en-gb">
		<head>
		<title>
		Test Page</title>
		<script type="text/javascript" src="/test.js" ></script><link rel="stylesheet" type="text/css" href="/test.css" /></head>
		<body>
		<div>
		test<br />test2</div>
		</body>
		</html>