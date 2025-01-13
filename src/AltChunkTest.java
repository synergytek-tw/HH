import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigInteger;

import javax.xml.namespace.QName;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.CTBodyImpl;

public class AltChunkTest {
	public static void main(String[] args) throws Exception {
		String path = "C:\\Users\\simon\\Downloads\\INV-20201113-0007_test-TM_2020-11-13 (18).doc";
		byte[] b = FileUtils.readFileToString(new File(path), "UTF-8").getBytes();
		
		XWPFDocument doc = new XWPFDocument();
		CTSectPr sectPr = doc.getDocument().getBody().addNewSectPr();
        CTPageMar pageMar = sectPr.addNewPgMar();
        pageMar.setLeft(BigInteger.valueOf(720L));
        pageMar.setTop(BigInteger.valueOf(1440L));
        pageMar.setRight(BigInteger.valueOf(720L));
        pageMar.setBottom(BigInteger.valueOf(720L));
        
		addHtml(doc, "chunk1",
				FileUtils.readFileToString(new File(path), "UTF-8"));
		FileOutputStream out = new FileOutputStream(new File("d:/test.docx"));
		doc.write(out);
	}

	static void addHtml(XWPFDocument doc, String id, String html) throws Exception {
		OPCPackage oPCPackage = doc.getPackage();
		PackagePartName partName = PackagingURIHelper.createPartName("/word/" + id + ".html");
		PackagePart part = oPCPackage.createPart(partName, "text/html");
		class HtmlRelation extends POIXMLRelation {
			private HtmlRelation() {
				super("text/html", "http://schemas.openxmlformats.org/officeDocument/2006/relationships/aFChunk",
						"/word/htmlDoc#.html");
			}
		}
		class HtmlDocumentPart extends POIXMLDocumentPart {
			private HtmlDocumentPart(PackagePart part) throws Exception {
				super(part);
			}

			@Override
			protected void commit() throws IOException {
				try (OutputStream out = part.getOutputStream()) {
					try (Writer writer = new OutputStreamWriter(out, "UTF-8")) {
						writer.write(html);
					}
				}
			}
		}
		;
		HtmlDocumentPart documentPart = new HtmlDocumentPart(part);
		doc.addRelation(id, new HtmlRelation(), documentPart);
		CTBodyImpl b = (CTBodyImpl) doc.getDocument().getBody();
		QName ALTCHUNK = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "altChunk");
		XmlComplexContentImpl altchunk = (XmlComplexContentImpl) b.get_store().add_element_user(ALTCHUNK);
		QName ID = new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "id");
		SimpleValue target = (SimpleValue) altchunk.get_store().add_attribute_user(ID);
		target.setStringValue(id);
	}
}