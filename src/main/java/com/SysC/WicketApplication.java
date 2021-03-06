package com.SysC;

import org.apache.wicket.guice.GuiceComponentInjector;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;

import com.SysC.signIn.SignInPage;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 *
 * @see com.SysC.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return SignInPage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init(){
		super.init();

		// サーバ・クライアント間のリクエスト・レスポンスの文字エンコード
		getRequestCycleSettings().setResponseRequestEncoding("UTF-8");
		// Wicketに取り込まれるHTMLファイルのエンコード
		getMarkupSettings().setDefaultMarkupEncoding("UTF-8");
		initGuiice();
		mountResource();
	}

	/**
	 * Page や Resource をマウントする.
	 * URLの最後尾を好きな名前?で表示できる
	 */
	public void mountResource() {

	}

	@Override
	public MySession newSession(Request request, Response response) {
		return new MySession(request);
	}


	/**
	 * Google Guiceを初期化する.
	 */
	private void initGuiice() {
		getComponentInstantiationListeners().add(new GuiceComponentInjector(this));
	}

}
