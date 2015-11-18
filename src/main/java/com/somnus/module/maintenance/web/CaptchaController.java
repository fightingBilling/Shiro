package com.somnus.module.maintenance.web;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.octo.captcha.service.image.ImageCaptchaService;
import com.somnus.support.web.controller.BaseController;

/**
 * @Description 验证码控制器
 * @author Somnus
 * @date 2015年11月5日 下午10:10:58 
 * @version 1.0
 */
public class CaptchaController extends BaseController {

	/**
	 * 验证码处理
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void handleCaptcha(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		
		byte[] captchaChallengeAsJpeg = null;
		
		ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
		
		String captchaId = session.getId();
		log.debug("captcha id: {}", new Object[]{captchaId});

		BufferedImage challenge = captchaService.getImageChallengeForID(captchaId, request.getLocale());
		
		ImageIO.write(challenge, "jpg", jpegOutputStream);
		
		captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
		
		ServletOutputStream out = response.getOutputStream();
		out.write(captchaChallengeAsJpeg);
		out.flush();
		out.close();
	}

	protected transient Logger log = LoggerFactory.getLogger(this.getClass());
	
	private ImageCaptchaService captchaService;

	public void setCaptchaService(ImageCaptchaService captchaService) {
		this.captchaService = captchaService;
	}
}
