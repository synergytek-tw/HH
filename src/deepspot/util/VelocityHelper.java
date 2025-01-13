package deepspot.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;


/**
 * 將資料套至樣版
 */
public class VelocityHelper {

	private static final Logger logger = Logger.getLogger(VelocityHelper.class);

	static {
		Properties p = new Properties();
		p.setProperty("resource.loader", "file");
		p.setProperty("file.resource.loader.path", Util.getTomcatPath());
		p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
		p.setProperty("input.encoding", "UTF-8");
		p.setProperty("output.encoding", "UTF-8");
		p.setProperty( "runtime.log.logsystem.log4j.logger", "velocity" );
		
		logger.info("init VelocityHelper");
		try {
			Velocity.init(p);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static VelocityHelper instance;

	private VelocityHelper() {
	}

	public synchronized static VelocityHelper getInstance() {
		if (instance == null) {
			instance = new VelocityHelper();
		}
		return instance;
	}
	
	public void render(String templateName, Object params, Writer writer) throws Exception {
		if (StringUtils.isEmpty(templateName)) {
			return;
		}

		VelocityContext ctx = new VelocityContext();
		if (params != null) {
			ctx.put("params", params);
		}

		Template template = null;
		try {
			if (Velocity.resourceExists(templateName)) {
				template = Velocity.getTemplate(templateName);
			}
			else {
			}
		}
		catch (Exception e) {
			throw new Exception("cannot render template name = " + templateName, e);
			
		}

		if (template == null) {
			throw new Exception("templaten = " + templateName + " is not found");
		}

		try {
			template.merge(ctx, writer);
		}
		catch (Exception e) {
			throw new Exception("cannot render template name = " + templateName, e);
		}
	}
	


	/**
	 * 取得範本
	 * <ul>
	 * <li>step1: 取得多國語言範本 (eg. sample01_en_US.html)</li>
	 * <li>step2: 如果未定義多國語言範本，取得繁體中文範本(eg. sample01_zh_TW.html) </li>
	 * <li>step3: 如果未定義繁體中文範本，取得預設範本 (eg. sample01.html)</li>
	 * </ul>
	 * 
	 * @param templateName
	 * @param locale
	 * @return
	 */
	public Template getTemplate(String templateName) throws Exception {
		 
		logger.debug(String.format("template:%s", templateName));
		 
		if (StringUtils.isEmpty(templateName)) {
			return null;
		}
		
		Template template = null;
		try {
			if (Velocity.resourceExists(templateName)) {
				template = Velocity.getTemplate(templateName);
			}
		}
		catch (Exception e) {
			throw new Exception("cannot get template, template name = " + templateName,e);
		}

		if (template == null) {
			throw new Exception("cannot find template, templante name = " + templateName);
		}

		return template;
	}
	
	public static void main(String[] args) {
		try {

			File srcFile = new File("D:/abc.doc");
			FileOutputStream fos = new FileOutputStream(srcFile);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"));

			VelocityHelper helper = VelocityHelper.getInstance();
			helper.render("/MultiExportCase_All.html", null, writer);

			writer.flush();
			writer.close();
			fos.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}