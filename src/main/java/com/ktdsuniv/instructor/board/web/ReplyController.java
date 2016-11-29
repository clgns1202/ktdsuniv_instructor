package com.ktdsuniv.instructor.board.web;

import org.springframework.stereotype.Controller;

import com.ktdsuniv.instructor.board.service.ReplyService;

@Controller
public class ReplyController {

	private ReplyService replyService;
	
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}
	
}
