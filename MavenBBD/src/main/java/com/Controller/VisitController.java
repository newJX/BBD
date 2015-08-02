package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//SpringMVC¿ØÖÆÆ÷

@Controller
public class VisitController {
	@RequestMapping("/Index")
	  public String getIndex()
	  {
	    return "Index";
	  }
	@RequestMapping("/Register")
	  public String getRegister()
	  {
	    return "Register";
	  }
	@RequestMapping("/Login")
	  public String getLogin()
	  {
	    return "Login";
	  }
	@RequestMapping("/Order")
	  public String getOrder()
	  {
	    return "Order";
	  }
	@RequestMapping("/")
	  public String getindex()
	  {
	    return "Index";
	  }
	@RequestMapping("/Personal_Info")
	  public String getPersonal_Info()
	  {
	    return "Personal_Info";
	  }
	@RequestMapping("/Change_Pass")
	  public String getChange_Pass()
	  {
	    return "Change_Pass";
	  }
	@RequestMapping("/Success")
	  public String getSuccess()
	  {
	    return "Success";
	  }
	@RequestMapping("/Release_Assign")
	  public String getRelease_Assign()
	  {
	    return "Release_Assign";
	  }
	@RequestMapping("/Accept_Assign")
	  public String getAccept_Assign()
	  {
	    return "Accept_Assign";
	  }
	@RequestMapping("/NewPass_Success")
	  public String getNewPass_Success()
	  {
	    return "NewPass_Success";
	  }
	@RequestMapping("/Order_Success")
	  public String getOrder_Success()
	  {
	    return "Order_Success";
	  }
	@RequestMapping("/Assign_Result")
	  public String getAssign_Result()
	  {
	    return "Assign_Result";
	  }
}
