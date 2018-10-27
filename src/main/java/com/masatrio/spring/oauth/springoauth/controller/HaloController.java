package com.masatrio.spring.oauth.springoauth.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HaloController {
	
	@RequestMapping("/halo")
	public void halo(Model m, @RequestParam(required = false) String nama) {
		m.addAttribute("waktu", new Date());
		if(nama != null && !nama.isEmpty()) {
			m.addAttribute("pesan", "Halo, "+nama);
		} else {
			m.addAttribute("pesan", "Halo, Aji");
		}
	}
	@RequestMapping("/")
    public String home() {
        return "Hello Docker World";
    }

}
