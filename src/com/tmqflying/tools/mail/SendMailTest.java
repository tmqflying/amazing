package com.tmqflying.tools.mail;

public class SendMailTest {
	private static String content = "测试邮件";

	public static void main(String[] args){
		String smtp = "smtp.qq.com"; // SMTP服务器
		String from = "tmq@tmqflying.com"; // 发件人
		String to = "tmqflying@qq.com"; // 收件人
		String copyto = "taomaoqi@qq.com"; // 抄送人
		String subject = "测试邮件"; // 邮件主题
		//String content = "这是一个测试邮件，可以忽略"; // 邮件内容
		String filename = "D:/Logging/Util/Copynews/logs/20150113copynews.log"; // 附件路径，如：D:/Logging/Util/Copynews/logs/20150113copynews.log
		String username="tmq@tmqflying.com"; // 用户名
		String password=""; // 密码
		Mail.sendAndCc(smtp, from, to, copyto, subject, content, username, password, filename);
	}
}
