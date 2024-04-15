package com.msd.springboot.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.msd.springboot.entities.Entry;
import com.msd.springboot.entities.User;
import com.msd.springboot.service.EntryInterface;
import com.msd.springboot.service.userInterface;

import jakarta.servlet.http.HttpSession;


@Controller
public class MyController {

	@Autowired
	private userInterface userInterface;
	
	public userInterface getUserBussiness() {
		return userInterface;
	}

	public void setUserBussiness(userInterface userInterface) {
		this.userInterface = userInterface;
	}

	@Autowired
	private EntryInterface entryInterface;
	
	public EntryInterface getEntryInterface() {
		return entryInterface;
	}

	public void setEntryInterface(EntryInterface entryInterface) {
		this.entryInterface = entryInterface;
	}

	@Autowired
	HttpSession session;
	
	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	@GetMapping("login")
	public String homepage(Model model) {
		
		return "loginpage";
		
	}

	@GetMapping("register")
	public String registrationpage() {
		
		return "registrationpage";
		
	}
	
	@PostMapping("saveUseruser") //this will taken from form action attribute where by clicking on register button this action will be performed
	public String saveUserUser(@ModelAttribute("user") User user) {  //modelAttribute user contains full fledged object info which will assigned to parametered user object
		
		String model = new String("saveUsersuccess");
				
		userInterface.saveUser(user);
		
		return model;
		
	}
	
	@PostMapping("authenticate") 
	public String authenticateUser(@ModelAttribute("user") User user, Model model) {
		
		String viewname = "loginpage";
		
		User user1 = userInterface.findUserByUsername(user.getUsername());
		
		session.setAttribute("user", user1);

		
		if(user1!=null && user1.getPassword().equals(user.getPassword())) {
			viewname ="userHomePage";
			model.addAttribute("user", user1);
			
			List<Entry> entries= null;


			try {
				entries = entryInterface.findUserById(user1.getId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.addAttribute("entriesList",entries);
		}
		
		return viewname;
		
	}
	
	@GetMapping("addEntry")
	public String addEntry() {
		
		String viewname = "addEntryPage";
		
		User user = (User) session.getAttribute("user");
		if(user == null) {
			viewname="loginpage";
		}
		
		
		return viewname;
		
	}
	
	@PostMapping("saveEntry")
	public String saveUserentry(@ModelAttribute("Entry") Entry entry,Model model) {
	    String viewname = "userHomePage";

	    User user = (User) session.getAttribute("user");
		if(user == null) {
			viewname="loginpage";
		}
	    // Add null check for the user object
	    if (user != null) {
	        // Check if the entry already has a user ID
	        
	            entry.setUser(user); // Set the user in the Entry object
	            entryInterface.saveEntry(entry); // Save the entry to the database

	            List<Entry> entries = null;

	            try {
	                entries = entryInterface.findUserById(user.getId());
	            } catch (Exception e) {
	                e.printStackTrace();
	            }

	            model.addAttribute("entriesList", entries);
	        } 
	    else {
	        viewname= "login";
	    }

	    return viewname;
	}
	
	@GetMapping("viewuser")
	public String  viewuserpage(@RequestParam("id") Long id,Model model) {
		
		String viewname = "viewuserpage";
		
		User user = (User) session.getAttribute("user");
		if(user == null) {
			viewname = "loginpage";
		}
	    
		Entry entry = entryInterface.findById(id);
		
		model.addAttribute("entry",entry);
		
		return viewname;
		
	}
	
	@GetMapping("userhome")
	public String  userhomepage(Model model) {
		
		String viewname = "userHomePage";
		
		User user = (User) session.getAttribute("user");
		if(user == null) {
			viewname = "loginpage";
		}
	    
		List<Entry> entries= null;
		
		try {
			entries = entryInterface.findUserById(user.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("entriesList",entries);
		
		return viewname;
		
	}

	@GetMapping("updateentry")
	public String  userpage(@RequestParam("id") Long id,Model model) {
		
		String viewname = "updateentrypage";
		
		User user = (User) session.getAttribute("user");
		if(user == null) {
			viewname="loginpage";
		}
		
		Entry entry = entryInterface.findById(id);
		
		model.addAttribute("entry",entry);
		
		return viewname;
		
	}
	
	@PostMapping("processupdateentry")
	public String processupdate(@ModelAttribute("updateprocess") @DateTimeFormat(pattern = "yyyy-MM-dd") Entry entry,Model model) {
        String viewname = "userHomePage";

        User user = (User) session.getAttribute("user");

        if (user != null) {
            entry.setUserid(user.getId()); // Set the user ID in the Entry object
            entryInterface.updateEntry(entry); // Update the entry in the database

            List<Entry> entries = null;

            try {
                entries = entryInterface.findUserById(user.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }

            model.addAttribute("entriesList", entries);
        } else {
            viewname="login"; // Redirect to login if the user is null
        }

        return viewname;
	}

	@GetMapping("deleteentry")
	public String deletepage(@RequestParam("id") Long id, Model model) {
		
		String viewname = "userHomePage";
		
		User user = (User) session.getAttribute("user");
		if(user == null) {
			viewname="loginpage";
		}
		
		Entry entry = entryInterface.findById(id);

        if (user != null) {
            entry.setUserid(user.getId()); // Set the user ID in the Entry object
            entryInterface.deleteEntry(entry); // Update the entry in the database

            List<Entry> entries = null;

            try {
                entries = entryInterface.findUserById(user.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }

            model.addAttribute("entriesList", entries);
        } else {
           viewname = "login"; // Redirect to login if the user is null
        }
		return viewname;
		
		
	}
	
	@GetMapping("signout")
	public String signout() {
		
		String viewname =  "loginpage";
		session.invalidate();
		
		return viewname;
		
	}
}
