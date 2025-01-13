package deepspot.daemon;

import java.util.Timer;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ScheduleManagerServlet extends HttpServlet {
	private ScheduleManagerTask task;
	private static Timer timer;
	public  static ServletContext ctx;
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println(" ============ Schedule Manager Start ============ ");
		super.init(config);
		ctx   = config.getServletContext();
		timer = new Timer(false);
		task  = new ScheduleManagerTask();
		timer.schedule(task,1000,1000*5);
	}
	

	//�M�ũҦ���{���s��, ����D��{
	public void destroy() {
		test();
		Schedules.getInstance().removeSchedule();
		task.cancel();
		timer.cancel();
		System.out.println(" ============ Schedule Manager Shutdown ============ ");
	}
	
	public synchronized static Timer getTimer() {
		return timer;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws
		ServletException, IOException{
		//response.sendError ( HttpServletResponse.SC_FORBIDDEN );
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws
		ServletException, IOException{
		this.doGet(request,response);
	}
	
	public static void test() {}

}