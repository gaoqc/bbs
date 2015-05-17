package bbs.beelt;

import java.io.File;

import org.bee.tl.core.GroupTemplate;
import org.bee.tl.ext.jfinal.BeetlRender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bbs.contant.BbsConstant;

import com.jfinal.kit.PathKit;
import com.jfinal.render.IMainRenderFactory;
import com.jfinal.render.Render;

public class BbsBeetlRenderFactory implements IMainRenderFactory {
	public static final Logger logger = LoggerFactory.getLogger(BbsBeetlRenderFactory.class);
	public static GroupTemplate gt =null; 
	private static final String viewExtension = ".html";

	public BbsBeetlRenderFactory(boolean idDev) {
             File file=new File(PathKit.getWebRootPath()+BbsConstant.BASE_PATH);
             gt=new GroupTemplate(file);
             gt.enableChecker(2);
             gt.setCharset("UTF-8");
//             gt.registerFunction("isSame", new IsSameFunction());
//             gt.registerFunction("printTime", new PrintTimeFunction());
             gt.setStatementStart("@");
             gt.setStatementEnd(null);
		 
	}

	@Override
	public Render getRender(String view) {
		// TODO Auto-generated method stub
		return new BeetlRender(gt, view);
	}

	@Override
	public String getViewExtension() {
		// TODO Auto-generated method stub
		return viewExtension;
	}
}
