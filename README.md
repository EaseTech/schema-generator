schema-generator
================

A light weight library for generating XSD files at runtime using Java classes

Some examples of generating schema
=================================
* Create a Schema with appinfo tag inside annotation tag 

         Schema schema = new Schema();
         schema.setId("id1");
         schema.setXmlLang("XMLLANG");
         Annotation annotation = new Annotation();
         annotation.setId("Anuj Kumar");
         AppInfo info = new AppInfo();
         info.setContent("This is a simple App Info");
         info.setSource("java");
         annotation.getAppInfo().add(info);
         schema.setAnnotation(annotation);
         System.out.println(fillTemplate(schema));
        
The above Code will generate the XSD as :

        <?xml version='1.0' encoding='UTF-8'?>
		<xsd:schema xmlns:xsd='http://www.w3.org/2001/XMLSchema' targetNamespace='urn:org:easetech:easytest:schema' xmlns:et='urn:org:easetech:easytest:schema' id="id1" xml:lang="XMLLANG" >
			<xsd:annotation id="Anuj Kumar" >
				<xsd:appinfo source="java" >
					"This is a simple App Info"
				</xsd:appinfo>
			</xsd:annotation>
		</xsd:schema>
		
* Create Schema with documentation tag inside annotation tag

		public static void createSchemaWithDocumentation(String content) {
        	Schema schema = new Schema();
        	Annotation annotation = new Annotation();
        	Documentation documentation = new Documentation();
        	documentation.setContent("This is the content");
        	annotation.getDocumentation().add(documentation);
        	schema.setAnnotation(annotation);
        	System.out.println(fillTemplate(schema));
    	}

The above code will generate the XSD as :

			<?xml version='1.0' encoding='UTF-8'?>
			<xsd:schema xmlns:xsd='http://www.w3.org/2001/XMLSchema' targetNamespace='urn:org:easetech:easytest:schema' xmlns:et='urn:org:easetech:easytest:schema' >
				<xsd:annotation >
					<xsd:documentation >
						"This is the content"
					</xsd:documentation>
				</xsd:annotation>
			</xsd:schema>
			
* Create a Document Node inside a schema node. NOTE that the below snippet makes use of XSDUtil class to generate element node and ComplexType node
		
			Schema schema = new Schema();
        	Annotation annotation = new Annotation();
        	Documentation documentation = new Documentation();
        	documentation.setContent("This is the content");
        	annotation.getDocumentation().add(documentation);
        	schema.setAnnotation(annotation);
			schema.getElement().add(
            XSDUtil.generateElement("simpleList", null));
        		Element element = XSDUtil.generateElement("simpleName", "simpleName",
            		"1", "unbounded");

        	ComplexType rootComplexType = XSDUtil.generateComplexType(
            	"simpleList", element);
        	schema.getComplexType().add(rootComplexType);
        	
The above code will generate the XSD as :

			<?xml version='1.0' encoding='UTF-8'?>
			<xsd:schema xmlns:xsd='http://www.w3.org/2001/XMLSchema' targetNamespace='urn:org:easetech:easytest:schema' xmlns:et='urn:org:easetech:easytest:schema' >
				<xsd:annotation >
					<xsd:documentation >
						"This is the content"
					</xsd:documentation>
				</xsd:annotation>
				<xsd:element name="simpleList" type="et:simpleList" >
				</xsd:element>

				<xsd:complexType name="simpleList" >
					<xsd:sequence >
						<xsd:element maxOccurs="unbounded" name="simpleName" type="et:simpleName" minOccurs="1" >
						</xsd:element>
					</xsd:sequence>
				</xsd:complexType>
			</xsd:schema>


You can create any complex XSD using only Java classes and with some knowledge of XSD notations.
Note that it is easier to use the methods in XSDUtil class as they are taking care of lot of things 
for the end user. If you feel a need to have extra methods, I encourage you to extend the XSDUtil class by providing me the patch 
of the code and I will add it to the XSDUtil class so that it can be useful to others as well.
