package com.empauthority.controller;

import java.io.*;
import java.util.*;
import com.empauthority.model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class EmpAuthorityServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		/*************** 顯示新增表單 ***************/
		if ("insertForm".equals(action)) {
		    RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/empauthority/addEmpAuthority.jsp");
		    dispatcher.forward(req, res);
		}

		/*************** 新增 ***************/
		if ("insert".equals(action)) {
			List<String> errorMsgs = new LinkedList<>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				// 1. 接收參數
				Integer empId = Integer.valueOf(req.getParameter("empId").trim());
				Integer functionId = Integer.valueOf(req.getParameter("functionId").trim());
				// 2. 呼叫 Service
				EmpAuthorityService authSvc = new EmpAuthorityService();
				authSvc.addEmpAuthority(empId, functionId);

				// 3. 成功 forward
				String url = "/WEB-INF/empauthority/listAllEmpAuthority.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			} catch (Exception e) {
				errorMsgs.add("新增失敗： " + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/WEB-INF/empauthority/listAllEmpAuthority.jsp");
				failureView.forward(req, res);
			}
		}

		/*************** 刪除 ***************/
		if ("delete".equals(action)) {
			List<String> errorMsgs = new LinkedList<>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				// 1. 接收參數
				Integer empId = Integer.valueOf(req.getParameter("empId"));
				Integer functionId = Integer.valueOf(req.getParameter("functionId"));

				// 2. 呼叫 Service
				EmpAuthorityService authSvc = new EmpAuthorityService();
				authSvc.deleteEmpAuthority(empId, functionId);

				// 3. 成功 forward
				String url = "/WEB-INF/empauthority/listAllEmpAuthority.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			} catch (Exception e) {
				errorMsgs.add("刪除失敗：" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/WEB-INF/empauthority/listAllEmpAuthority.jsp");
				failureView.forward(req, res);
			}
		}

		/*************** 查單筆 ***************/
		if ("getOne".equals(action)) {
			List<String> errorMsgs = new LinkedList<>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				// 1. 接收參數
				Integer empId = Integer.valueOf(req.getParameter("empId"));
				Integer functionId = Integer.valueOf(req.getParameter("functionId"));

				// 2. 呼叫 Service
				EmpAuthorityService authSvc = new EmpAuthorityService();
				EmpAuthorityVO vo = authSvc.getOneEmpAuthority(empId, functionId);

				if (vo == null) {
					throw new Exception("查無資料");
				}

				// 3. 成功 forward
				req.setAttribute("empAuthorityVO", vo);
				String url = "/WEB-INF/empauthority/listOneEmpAuthority.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);
				successView.forward(req, res);

			} catch (Exception e) {
				req.setAttribute("errorMsgs", List.of("查詢失敗： " + e.getLocalizedMessage()));
				RequestDispatcher failureView = req
						.getRequestDispatcher("/WEB-INF/empauthority/listOneEmpAuthority.jsp");
				failureView.forward(req, res);
			}
		}

		/*************** 顯示選單頁 ***************/
		if ("selectPage".equals(action)) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/empauthority/selectEmpAuthority.jsp");
			dispatcher.forward(req, res);
		}

		/*************** 查全部 ***************/
		if ("getAll".equals(action)) {
			List<String> errorMsgs = new LinkedList<>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				EmpAuthorityService authSvc = new EmpAuthorityService();
				req.setAttribute("empAuthorityList", authSvc.getAll());

				String url = "/WEB-INF/empauthority/listAllEmpAuthority.jsp";
				RequestDispatcher successView = req
						.getRequestDispatcher("/WEB-INF/empauthority/listAllEmpAuthority.jsp");
				successView.forward(req, res);

			} catch (Exception e) {
				errorMsgs.add("查詢全部失敗：" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/WEB-INF/empauthority/listAllEmpAuthority.jsp");
				failureView.forward(req, res);

			}
		}
	}

}
